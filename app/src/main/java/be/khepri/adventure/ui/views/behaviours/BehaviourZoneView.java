package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import be.khepri.adventure.R;
import be.khepri.adventure.game.behaviours.Zone;

public class BehaviourZoneView extends RelativeLayout {
    public BehaviourZoneView(Context context) {
        super(context);
        init(context, null);
    }

    public BehaviourZoneView(Context context, Zone zone) {
        super(context);
        init(context, zone);
    }

    public void init(Context context, Zone zone) {
        View rootView = inflate(context, R.layout.view_behaviour_zone, this);

        if (zone != null) {

        }
    }
}
