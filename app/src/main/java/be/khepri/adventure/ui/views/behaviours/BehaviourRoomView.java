package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.Room;

public class BehaviourRoomView extends RelativeLayout {
    public BehaviourRoomView(Context context) {
        super(context);
        init(context, null);
    }

    public BehaviourRoomView(Context context, Room room) {
        super(context);
        init(context, room);
    }

    public void init(Context context, Room room) {
        View rootView = inflate(context, R.layout.view_behaviour_room, this);

        if (room != null) {

        }
    }
}
