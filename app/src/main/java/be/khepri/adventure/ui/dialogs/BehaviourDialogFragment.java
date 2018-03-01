package be.khepri.adventure.ui.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import be.khepri.adventure.R;
import be.khepri.adventure.game.data.AbstractBehaviour;
import be.khepri.adventure.ui.activities.EditGameObjectActivity;

public class BehaviourDialogFragment extends DialogFragment {


    public class BehaviourWrapper<T, J, K> {
        private T key;
        private J primary;
        private K secondary;

        public BehaviourWrapper(T key, J primary, K secondary) {
            this.key = key;
            this.primary = primary;
            this.secondary = secondary;
        }

        public T getKey() { return this.key; }
        public J getPrimary() { return primary; }
        public K getSecondary() { return secondary; }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final EditGameObjectActivity activity = (EditGameObjectActivity) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        Resources res = getResources();
        TypedArray names = res.obtainTypedArray(R.array.behaviours);
        TypedArray classes = res.obtainTypedArray(R.array.behaviourClasses);
        TypedArray views = res.obtainTypedArray(R.array.behaviourViews);

      //  builder.setView(numberPicker);
        builder.setTitle("Add AbstractBehaviour");
        builder.setItems(R.array.behaviours, (dialog, which) -> {
            try {
                activity.onAddBehaviour(new BehaviourWrapper<>(
                    names.getString(which),
                    (AbstractBehaviour) Class.forName(classes.getString(which)).newInstance(),
                    Class.forName(views.getString(which))
                ));
            } catch (java.lang.InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


}
