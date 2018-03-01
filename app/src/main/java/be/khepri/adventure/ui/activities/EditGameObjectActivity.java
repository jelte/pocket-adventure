package be.khepri.adventure.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import be.khepri.adventure.R;
import be.khepri.adventure.game.Behaviour;
import be.khepri.adventure.game.data.AbstractBehaviour;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.dialogs.BehaviourDialogFragment;

public class EditGameObjectActivity extends Activity {

    public static final String PARAM_GAMEOBJECT_ID = "be.khepri.adventure.GAMEOBJECT_ID";

    private GameObject gameObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String id = getIntent().getStringExtra(PARAM_GAMEOBJECT_ID);
        if (id != null) {
            new AsyncTask<String, Void, GameObject>() {
                @Override
                protected GameObject doInBackground(String... id) {
                    return World.getInstance().getGameObject(UUID.fromString(id[0]));
                }

                @Override
                protected void onPostExecute(GameObject gameObject) {
                    loadGameObject(gameObject);
                }
            }.execute(id);
        } else {
            loadGameObject(new GameObject());
        }
    }

    private void loadGameObject(GameObject gameObject) {

        this.gameObject = gameObject;

        setContentView(R.layout.activity_edit_game_object);
        LinearLayout container = findViewById(R.id.behaviours);

        for (Behaviour behaviour : gameObject.getBehaviours()) {
//            container.addView(BehaviourViewFactory.createView(behaviour));
        }
    }

    public void addBehaviour(View view) {
        BehaviourDialogFragment dialog = new BehaviourDialogFragment();
        dialog.show(getFragmentManager(), "EditGameObject");
    }

    public void onAddBehaviour(BehaviourDialogFragment.BehaviourWrapper<String, AbstractBehaviour, Class> result) throws java.lang.InstantiationException, IllegalAccessException, ClassNotFoundException {
        this.gameObject.addBehaviour(result.getPrimary());

        try {
            ((LinearLayout) findViewById(R.id.behaviours)).addView((View) result.getSecondary().getConstructor(Context.class).newInstance(getBaseContext()));
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
