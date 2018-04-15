package be.khepri.adventure.engine;

import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.util.Observable;
import be.khepri.adventure.util.Observer;

public class Character extends Observable implements Observer {
    private Transform transform;

    public Character(Transform transform)
    {
        this.transform = transform;
        this.transform.addObserver(this);
    }

    public void move(Vector2D direction) {
        transform.move(direction);
    }

    public Transform getTransform() {
        return transform;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATING PLAYER");
        setChanged();
        notifyObservers(this);
    }
}
