package be.khepri.adventure.ui.fragments;

<<<<<<< HEAD
=======
import android.content.Intent;
import android.database.DataSetObserver;
>>>>>>> Alpha 1.0
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD

import be.khepri.adventure.R;

public class RoomFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room, container, false);
=======
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.Room;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.game.Direction;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.ui.GameObjectListViewAdapter;
import be.khepri.adventure.ui.activities.EditGameObjectActivity;
import be.khepri.adventure.util.Observable;
import be.khepri.adventure.util.Observer;

import static be.khepri.adventure.ui.activities.EditGameObjectActivity.PARAM_LOCATION_ID;
import static be.khepri.adventure.ui.activities.EditGameObjectActivity.PARAM_POSITION_X;
import static be.khepri.adventure.ui.activities.EditGameObjectActivity.PARAM_POSITION_Y;

public class RoomFragment extends Fragment implements Observer {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_room, container, false);

        Transform transform = World.getInstance().getPlayer().getTransform();

        view.findViewById(R.id.btnNorth).setOnClickListener((View v) -> {
            transform.move(Vector2D.UP);
        });
        view.findViewById(R.id.btnEast).setOnClickListener((View v) -> {
            transform.move(Vector2D.RIGHT);
        });
        view.findViewById(R.id.btnSouth).setOnClickListener((View v) -> {
            transform.move(Vector2D.DOWN);
        });
        view.findViewById(R.id.btnWest).setOnClickListener((View v) -> {
            transform.move(Vector2D.LEFT);
        });
        view.findViewById(R.id.btnCreateHere).setOnClickListener((View v) -> {
            Intent intent = new Intent(getContext(), EditGameObjectActivity.class);
            // re-enable once zones are implemented in navigation.
           // intent.putExtra(PARAM_LOCATION_ID, transform.getLocation().toString());
            intent.putExtra(PARAM_POSITION_X, transform.getCoordinates().getX());
            intent.putExtra(PARAM_POSITION_Y, transform.getCoordinates().getY());
            startActivity(intent);
        });


        World.getInstance().addObserver(this);

        Room room = World.getInstance().getRoom(transform);
        if (room == null) {
            return view;
        }

        initRoom(room);

        return view;
    }

    private void initRoom(Room room) {

        ((TextView) view.findViewById(R.id.txtName)).setText(R.string.missing);
        ((TextView) view.findViewById(R.id.txtDescription)).setText(R.string.missing_description);
        view.findViewById(R.id.btnNorth).setEnabled(false);
        view.findViewById(R.id.btnEast).setEnabled(false);
        view.findViewById(R.id.btnSouth).setEnabled(false);
        view.findViewById(R.id.btnWest).setEnabled(false);
        view.findViewById(R.id.btnNorth).setVisibility(View.GONE);
        view.findViewById(R.id.btnEast).setVisibility(View.GONE);
        view.findViewById(R.id.btnSouth).setVisibility(View.GONE);
        view.findViewById(R.id.btnWest).setVisibility(View.GONE);

        view.findViewById(R.id.btnCreateHere).setEnabled(false);
        view.findViewById(R.id.btnCreateHere).setVisibility(View.GONE);

        if (room != null && room.getGameObject() != null) {
            ((TextView) view.findViewById(R.id.txtName)).setText(room.getGameObject().getName());
            ((TextView) view.findViewById(R.id.txtDescription)).setText(room.getGameObject().getDescription());

            if (room.getBehaviour() != null) {
                if (room.getBehaviour().hasConnection(Direction.NORTH)) {
                    view.findViewById(R.id.btnNorth).setEnabled(true);
                    view.findViewById(R.id.btnNorth).setVisibility(View.VISIBLE);
                }
                if (room.getBehaviour().hasConnection(Direction.EAST)) {
                    view.findViewById(R.id.btnEast).setEnabled(true);
                    view.findViewById(R.id.btnEast).setVisibility(View.VISIBLE);
                }
                if (room.getBehaviour().hasConnection(Direction.SOUTH)) {
                    view.findViewById(R.id.btnSouth).setEnabled(true);
                    view.findViewById(R.id.btnSouth).setVisibility(View.VISIBLE);
                }
                if (room.getBehaviour().hasConnection(Direction.WEST)) {
                    view.findViewById(R.id.btnWest).setEnabled(true);
                    view.findViewById(R.id.btnWest).setVisibility(View.VISIBLE);
                }
            }

            LinearLayout container = view.findViewById(R.id.listContains);
            container.removeAllViewsInLayout();
            if (room.getContains() != null && view.getContext() != null) {
                for (GameObject gameObject : room.getContains()) {
                    TextView name = new TextView(view.getContext());
                    name.setText(gameObject.getName());
                    container.addView(name);
                }
            }
        }

        if (room == null || room.getGameObject() == null || room.getBehaviour() == null) {
            view.findViewById(R.id.btnCreateHere).setEnabled(true);
            view.findViewById(R.id.btnCreateHere).setVisibility(View.VISIBLE);
        }
        view.invalidate();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Room) {
            initRoom((Room) arg);
        }
>>>>>>> Alpha 1.0
    }
}
