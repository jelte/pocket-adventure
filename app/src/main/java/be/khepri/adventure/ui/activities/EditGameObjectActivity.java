package be.khepri.adventure.ui.activities;

import android.app.Activity;
<<<<<<< HEAD
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.InvocationTargetException;
=======
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
>>>>>>> Alpha 1.0
import java.util.UUID;

import be.khepri.adventure.R;
import be.khepri.adventure.game.Behaviour;
<<<<<<< HEAD
import be.khepri.adventure.game.data.AbstractBehaviour;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.dialogs.BehaviourDialogFragment;
=======
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.dialogs.BehaviourDialogFragment;
import be.khepri.adventure.ui.views.behaviours.BehaviourView;
>>>>>>> Alpha 1.0

public class EditGameObjectActivity extends Activity {

    public static final String PARAM_GAMEOBJECT_ID = "be.khepri.adventure.GAMEOBJECT_ID";
<<<<<<< HEAD

    private GameObject gameObject;
=======
    public static final String PARAM_LOCATION_ID = "be.khepri.adventure.LOCATION_ID";
    public static final String PARAM_POSITION_X = "be.khepri.adventure.POSITION_X";
    public static final String PARAM_POSITION_Y = "be.khepri.adventure.POSITION_Y";

    private GameObject gameObject;
    private ArrayList<BehaviourView> behaviourViews = new ArrayList<>();
>>>>>>> Alpha 1.0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        String id = getIntent().getStringExtra(PARAM_GAMEOBJECT_ID);
        if (id != null) {
=======

        Intent intent = getIntent();
        if (intent.hasExtra(PARAM_GAMEOBJECT_ID)) {
>>>>>>> Alpha 1.0
            new AsyncTask<String, Void, GameObject>() {
                @Override
                protected GameObject doInBackground(String... id) {
                    return World.getInstance().getGameObject(UUID.fromString(id[0]));
                }

                @Override
                protected void onPostExecute(GameObject gameObject) {
<<<<<<< HEAD
                    loadGameObject(gameObject);
                }
            }.execute(id);
        } else {
            loadGameObject(new GameObject());
        }
    }

    private void loadGameObject(GameObject gameObject) {
=======
                    loadGameObject(gameObject, false);
                }
            }.execute(getIntent().getStringExtra(PARAM_GAMEOBJECT_ID));
        } else {
            GameObject gameObject = new GameObject();
            if (intent.hasExtra(PARAM_POSITION_X) && intent.hasExtra(PARAM_POSITION_Y)) {
                gameObject.addBehaviour(new Transform(
                    gameObject.getId(),
                    intent.hasExtra(PARAM_LOCATION_ID) ? UUID.fromString(intent.getStringExtra(PARAM_LOCATION_ID)) : null,
                    new Vector2D(
                        intent.getIntExtra(PARAM_POSITION_X, 0 ),
                        intent.getIntExtra(PARAM_POSITION_Y, 0 )
                    )
                ));
            }
            loadGameObject(gameObject, true);
        }
    }

    private void loadGameObject(GameObject gameObject, boolean isNew) {
>>>>>>> Alpha 1.0

        this.gameObject = gameObject;

        setContentView(R.layout.activity_edit_game_object);
<<<<<<< HEAD
        LinearLayout container = findViewById(R.id.behaviours);

        for (Behaviour behaviour : gameObject.getBehaviours()) {
//            container.addView(BehaviourViewFactory.createView(behaviour));
=======

        ((TextView) findViewById(R.id.txtTitle)).setText(isNew?R.string.titleCreateGameObject:R.string.titleUpdateGameObject);

        ((EditText) findViewById(R.id.name)).setText(gameObject.getName());
        ((EditText) findViewById(R.id.description)).setText(gameObject.getDescription());

        LinearLayout container = findViewById(R.id.behaviours);

        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            if (v instanceof BehaviourView) {
                container.removeView(v);
            }
        }
        for (Behaviour behaviour : gameObject.getBehaviours().values()) {
            BehaviourView behaviourView = new BehaviourView(getBaseContext(), behaviour);
            behaviourViews.add(behaviourView);
            container.addView(behaviourView);
>>>>>>> Alpha 1.0
        }
    }

    public void addBehaviour(View view) {
        BehaviourDialogFragment dialog = new BehaviourDialogFragment();
        dialog.show(getFragmentManager(), "EditGameObject");
    }

<<<<<<< HEAD
    public void onAddBehaviour(BehaviourDialogFragment.BehaviourWrapper<String, AbstractBehaviour, Class> result) throws java.lang.InstantiationException, IllegalAccessException, ClassNotFoundException {
        this.gameObject.addBehaviour(result.getPrimary());

        try {
            ((LinearLayout) findViewById(R.id.behaviours)).addView((View) result.getSecondary().getConstructor(Context.class).newInstance(getBaseContext()));
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
=======
    public void saveGameObject(View view) {
        this.gameObject.setName(((EditText) findViewById(R.id.name)).getText().toString());
        this.gameObject.setDescription(((EditText) findViewById(R.id.description)).getText().toString());
        for (BehaviourView behaviourView : behaviourViews) {
            if (behaviourView.getVisibility() == View.GONE) {
                this.gameObject.removeBehaviour(behaviourView.getBehaviour());
            } else {
                this.gameObject.addBehaviour(behaviourView.save());
            }
        }
        // Save the game object.
        new AsyncTask<GameObject, Void, Void>() {
            @Override
            protected Void doInBackground(GameObject... gameObjects) {
                // Save the game object.
                World.getInstance().saveGameObject(gameObjects[0], !getIntent().hasExtra(PARAM_GAMEOBJECT_ID));
                return null;
            }

            @Override
            protected void onPostExecute(Void gameObject) {
                // Close the activity when saved.
                finish();
            }
        }.execute(this.gameObject);
    }

    public void onAddBehaviour(BehaviourDialogFragment.BehaviourWrapper<String, Class, Class> result) throws java.lang.InstantiationException, IllegalAccessException, ClassNotFoundException {
        Behaviour behaviour = (Behaviour) result.getPrimary().newInstance();
        behaviour.setId(this.gameObject.getId());
        BehaviourView behaviourView = new BehaviourView(getBaseContext(), behaviour);
        behaviourViews.add(behaviourView);
        ((LinearLayout) findViewById(R.id.behaviours)).addView(behaviourView);
>>>>>>> Alpha 1.0
    }
}
