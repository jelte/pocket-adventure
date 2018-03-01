package be.khepri.adventure.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import be.khepri.adventure.R;
import be.khepri.adventure.game.GameObject;

public class GameObjectListViewAdapter extends ArrayAdapter<GameObject> {

    private int resource;
    public GameObjectListViewAdapter(@NonNull Context context, int resource, @NonNull List<GameObject> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {

        if (view == null) {

            view = LayoutInflater.from(parent.getContext())
                    .inflate(resource, parent, false);
        }

        GameObject go = getItem(position);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(go.getName());
        TextView description = (TextView) view.findViewById(R.id.description);
        description.setText(go.getDescription());

        return view;
    }
}
