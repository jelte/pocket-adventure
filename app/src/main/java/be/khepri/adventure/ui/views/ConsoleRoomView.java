package be.khepri.adventure.ui.views;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import be.khepri.adventure.R;
import be.khepri.adventure.game.behaviours.Room;

public class ConsoleRoomView extends RelativeLayout {
    public ConsoleRoomView(Context context, be.khepri.adventure.engine.Room room) {
        super(context);
        init(context, room);
    }

    public void init(Context context, be.khepri.adventure.engine.Room room) {
        View rootView = inflate(context, R.layout.view_room_console, this);

        ((TextView) rootView.findViewById(R.id.description)).setText(room.getGameObject().getDescription());
    }
}
