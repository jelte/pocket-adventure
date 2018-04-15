package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;

import be.khepri.adventure.R;
import be.khepri.adventure.game.Behaviour;

public class BehaviourNoPropertiesView extends AbstractBehaviourView {

    public BehaviourNoPropertiesView(Context context) {
        super(context);
    }

    @Override
    public Behaviour save() {
        return this.behaviour;
    }

    @Override
    public void init() {
        inflate(getContext(), R.layout.view_behaviour_no_properties, this);
    }
}
