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
<<<<<<< HEAD

=======
>>>>>>> Alpha 1.0
            view = LayoutInflater.from(parent.getContext())
                    .inflate(resource, parent, false);
        }

        GameObject go = getItem(position);

<<<<<<< HEAD
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(go.getName());
        TextView description = (TextView) view.findViewById(R.id.description);
=======
        TextView name = view.findViewById(R.id.name);
        name.setText(go.getName());
        TextView description = view.findViewById(R.id.description);
>>>>>>> Alpha 1.0
        description.setText(go.getDescription());

        return view;
    }
}
