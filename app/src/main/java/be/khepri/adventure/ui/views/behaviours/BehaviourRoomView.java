package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
import android.view.View;
<<<<<<< HEAD
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

=======
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.UUID;

import be.khepri.adventure.R;
import be.khepri.adventure.game.Behaviour;
import be.khepri.adventure.game.Direction;
import be.khepri.adventure.game.behaviours.Room;

public class BehaviourRoomView extends AbstractBehaviourView {

    View rootView;

    public BehaviourRoomView(Context context) {
        super(context);
    }

    @Override
    public Behaviour save() {
        Room room = (Room) this.behaviour;

        ArrayList<Direction> directions = new ArrayList<>();
        if (((CheckBox) rootView.findViewById(R.id.connection_north)).isChecked()) {
            directions.add(Direction.NORTH);
        }
        if (((CheckBox) rootView.findViewById(R.id.connection_east)).isChecked()) {
            directions.add(Direction.EAST);
        }
        if (((CheckBox) rootView.findViewById(R.id.connection_south)).isChecked()) {
            directions.add(Direction.SOUTH);
        }
        if (((CheckBox) rootView.findViewById(R.id.connection_west)).isChecked()) {
            directions.add(Direction.WEST);
        }
        room.setDirections(directions.toArray(new Direction[directions.size()]));
        return this.behaviour;
    }

    public void init() {
        rootView = inflate(getContext(), R.layout.view_behaviour_room, this);

        Room room = (Room) this.behaviour;

        if (room != null) {
            ((CheckBox) rootView.findViewById(R.id.connection_north)).setChecked(room.hasConnection(Direction.NORTH));
            ((CheckBox) rootView.findViewById(R.id.connection_east)).setChecked(room.hasConnection(Direction.EAST));
            ((CheckBox) rootView.findViewById(R.id.connection_south)).setChecked(room.hasConnection(Direction.SOUTH));
            ((CheckBox) rootView.findViewById(R.id.connection_west)).setChecked(room.hasConnection(Direction.WEST));
>>>>>>> Alpha 1.0
        }
    }
}
