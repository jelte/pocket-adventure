package be.khepri.adventure.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.GameObjectListViewAdapter;

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
        World.getInstance().findGameObjects(query).observe(getActivity(), gameObjects -> {
            if (gameObjects == null) {
                return;
            }
            results.setAdapter(new GameObjectListViewAdapter(getContext(), R.layout.search_result_view_gameobject, gameObjects));
        });
    }
}
