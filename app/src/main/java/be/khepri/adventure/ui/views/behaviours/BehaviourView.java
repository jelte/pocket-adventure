package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import be.khepri.adventure.R;
import be.khepri.adventure.game.Behaviour;

public class BehaviourView extends RelativeLayout {
    public BehaviourView(Context context) {
        super(context);
        init(context, null);
    }

    public BehaviourView(Context context, Behaviour behaviour) {
        super(context);
        init(context, behaviour);
    }

    public void init(Context context, Behaviour behaviour) {
        View rootView = inflate(context, R.layout.view_behaviour, this);

        CheckBox active = ((CheckBox)rootView.findViewById(R.id.active));
        active.setChecked(true);
        /*active.setText();

        if (room != null) {

        }*/
    }
}
