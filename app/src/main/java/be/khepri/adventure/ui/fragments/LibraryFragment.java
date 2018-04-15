package be.khepri.adventure.ui.fragments;

<<<<<<< HEAD
=======
import android.content.Intent;
>>>>>>> Alpha 1.0
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.GameObjectListViewAdapter;
=======
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.ui.GameObjectListViewAdapter;
import be.khepri.adventure.ui.activities.EditGameObjectActivity;

import static android.support.v4.content.ContextCompat.startActivity;
import static be.khepri.adventure.ui.activities.EditGameObjectActivity.PARAM_GAMEOBJECT_ID;
>>>>>>> Alpha 1.0

public class LibraryFragment extends Fragment implements SearchView.OnQueryTextListener {

    private ListView results;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        SearchView search = view.findViewById(R.id.search);
        search.setOnQueryTextListener(this);

        EditText searchText = search.findViewById(search.getContext().getResources().getIdentifier("android:id/search_src_text", null, null));
        searchText.setHintTextColor(Color.LTGRAY);
        searchText.setTextColor(Color.WHITE);

        results = view.findViewById(R.id.results);

<<<<<<< HEAD
=======
        results.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(getContext(), EditGameObjectActivity.class);
            intent.putExtra(PARAM_GAMEOBJECT_ID, ((GameObject) parent.getAdapter().getItem(position)).getId().toString());

            startActivity(intent);
        });

>>>>>>> Alpha 1.0
        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        onSearch(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        onSearch(newText);
        return true;
    }

    private void onSearch(String query)
    {
<<<<<<< HEAD
        World.getInstance().findGameObjects(query).observe(getActivity(), gameObjects -> {
=======
        World.getInstance().findGameObjects(query).observe(getActivity(), (List<GameObject> gameObjects) -> {
>>>>>>> Alpha 1.0
            if (gameObjects == null) {
                return;
            }
            results.setAdapter(new GameObjectListViewAdapter(getContext(), R.layout.search_result_view_gameobject, gameObjects));
<<<<<<< HEAD
=======

>>>>>>> Alpha 1.0
        });
    }
}
