package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
import android.view.View;
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
    }
}
