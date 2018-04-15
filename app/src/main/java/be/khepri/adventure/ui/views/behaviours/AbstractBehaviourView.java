package be.khepri.adventure.ui.views.behaviours;

import android.content.Context;
import android.widget.RelativeLayout;

import be.khepri.adventure.game.Behaviour;

abstract public class AbstractBehaviourView extends RelativeLayout {
    protected Behaviour behaviour;
    public AbstractBehaviourView(Context context) {
        super(context);
    }

    abstract public Behaviour save();

    public void setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    public abstract void init();
}
