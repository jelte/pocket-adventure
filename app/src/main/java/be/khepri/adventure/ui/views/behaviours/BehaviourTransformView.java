package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
import android.view.View;
<<<<<<< HEAD
import android.widget.RelativeLayout;

import be.khepri.adventure.R;
import be.khepri.adventure.game.behaviours.Transform;

public class BehaviourTransformView extends RelativeLayout {

    public BehaviourTransformView(Context context) {
        super(context);
        init(context, null);
    }

    public BehaviourTransformView(Context context, Transform transform) {
        super(context);
        init(context, transform);
    }

    public void init(Context context, Transform transform) {
        View rootView = inflate(context, R.layout.view_behaviour_transform, this);

        if (transform != null) {

        }
=======
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RelativeLayout;

import be.khepri.adventure.R;
import be.khepri.adventure.game.Behaviour;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Transform;

public class BehaviourTransformView extends AbstractBehaviourView {

    View rootView;

    public BehaviourTransformView(Context context) {
        super(context);
    }

    public void init() {
        rootView = inflate(getContext(), R.layout.view_behaviour_transform, this);
        Transform transform = (Transform) this.behaviour;
        if (transform != null && transform.getCoordinates() != null) {
            ((EditText) rootView.findViewById(R.id.txtX)).setText(""+ transform.getCoordinates().getX());
            ((EditText) rootView.findViewById(R.id.txtY)).setText(""+ transform.getCoordinates().getY());
        }
    }

    @Override
    public Behaviour save() {
        Transform transform = (Transform) this.behaviour;
        transform.setCoordinates(new Vector2D(
            Integer.parseInt(((EditText) rootView.findViewById(R.id.txtX)).getText().toString()),
            Integer.parseInt(((EditText) rootView.findViewById(R.id.txtY)).getText().toString())
        ));
        return this.behaviour;
>>>>>>> Alpha 1.0
    }
}
