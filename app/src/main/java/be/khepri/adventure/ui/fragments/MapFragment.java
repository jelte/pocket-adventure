package be.khepri.adventure.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.khepri.adventure.R;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.views.MapView;

public class MapFragment extends Fragment {
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
        return view;
    }
}
