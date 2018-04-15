package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
<<<<<<< HEAD
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

=======
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

>>>>>>> Alpha 1.0
import be.khepri.adventure.R;
import be.khepri.adventure.game.Behaviour;

public class BehaviourView extends RelativeLayout {
<<<<<<< HEAD
    public BehaviourView(Context context) {
        super(context);
        init(context, null);
=======
    private AbstractBehaviourView view;
    private Behaviour behaviour;
    public BehaviourView(Context context) {
        super(context);
        init(context);
>>>>>>> Alpha 1.0
    }

    public BehaviourView(Context context, Behaviour behaviour) {
        super(context);
<<<<<<< HEAD
        init(context, behaviour);
    }

    public void init(Context context, Behaviour behaviour) {
        View rootView = inflate(context, R.layout.view_behaviour, this);

        CheckBox active = ((CheckBox)rootView.findViewById(R.id.active));
        active.setChecked(true);
        /*active.setText();

        if (room != null) {

        }*/
=======
        this.behaviour = behaviour;
        init(context);
    }

    public void init(Context context) {
        View rootView = inflate(context, R.layout.view_behaviour, this);

        CheckBox active = rootView.findViewById(R.id.active);
        active.setChecked(true);
        active.setText(behaviour.getClass().getSimpleName());

        rootView.findViewById(R.id.btnRemove).setOnClickListener((View v) -> {
            rootView.setVisibility(GONE);
        });

        Resources res = getResources();
        TypedArray classes = res.obtainTypedArray(R.array.behaviourClasses);
        TypedArray views = res.obtainTypedArray(R.array.behaviourViews);
        int which = findIndex(classes, behaviour.getClass().getName());
        try {
            view = (AbstractBehaviourView) Class.forName(views.getString(which)).getConstructor(Context.class).newInstance(getContext());
            view.setBehaviour(behaviour);
            view.init();
            ((LinearLayout) findViewById(R.id.behaviour)).addView(view);
        } catch (NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public Behaviour save()
    {
        return view.save();
    }

    private int findIndex(TypedArray values, String value)
    {
        for (int i = 0; i < values.length(); i++) {
            if (values.getString(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public Behaviour getBehaviour() {
        return this.behaviour;
>>>>>>> Alpha 1.0
    }
}
