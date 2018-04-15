package be.khepri.adventure.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.khepri.adventure.R;
<<<<<<< HEAD
import be.khepri.adventure.game.GameObject;
=======
import be.khepri.adventure.engine.Character;
import be.khepri.adventure.engine.Room;
>>>>>>> Alpha 1.0
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.views.MapView;

public class MapFragment extends Fragment {
<<<<<<< HEAD
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
/*
        MapView mapView = view.findViewById(R.id.map);
        World.getInstance().addObserver((o, arg) -> {
            if (arg instanceof GameObject) {
                mapView.onWorldUpdate((World) o, (GameObject) arg);
            }
        });
*/
=======

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        MapView mapView = view.findViewById(R.id.map);
        World.getInstance().addObserver((o, arg) -> {
            if (arg instanceof Character) {
                mapView.onWorldUpdate((World) o, (Character) arg);
            } else if (arg instanceof Room) {
                mapView.onWorldUpdate((World) o, (Room) arg);
            }
        });
        mapView.onWorldUpdate(World.getInstance(), World.getInstance().getPlayer());
>>>>>>> Alpha 1.0
        return view;
    }
}
