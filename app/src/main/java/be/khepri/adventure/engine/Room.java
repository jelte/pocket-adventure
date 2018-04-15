package be.khepri.adventure.engine;

import java.util.ArrayList;
import java.util.List;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.util.Observable;
import be.khepri.adventure.util.Observer;

public class Room extends Observable implements Observer
{
    private Transform transform;
    private GameObject gameObject;
    private List<GameObject> contains = new ArrayList<>();

    public Room(Transform transform, List<GameObject> gameObjects)
    {
        this.transform = transform;
        this.add(gameObjects);
    }

    public void add(List<GameObject> gameObjects) {
        for (GameObject gameObject : gameObjects) {
<<<<<<< HEAD
            if (this.gameObject == null && gameObject.hasBehaviour(be.khepri.adventure.game.behaviours.Room.class.toString())) {
                this.gameObject = gameObject;
            } else if (!contains.contains(gameObject)) {
=======
            if (this.gameObject == null && gameObject.hasBehaviour(be.khepri.adventure.game.behaviours.Room.class.getName())) {
                this.gameObject = gameObject;
            } else {
>>>>>>> Alpha 1.0
                gameObject.addObserver(this);
                contains.add(gameObject);
            }
        }
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public List<GameObject> getContains() {
        return contains;
    }

    public Transform getTransform()
    {
        return this.transform;
    }

<<<<<<< HEAD
    @Override
    public void update(Observable o, Object arg) {
        GameObject gameObject = (GameObject) o;
      /*  if (!gameObject.getTransform().equals(this.transform)) {
            gameObject.deleteObserver(this);
            contains.remove(gameObject);
            this.notifyObservers(RoomAction.Left(gameObject));
        }*/
=======
    public be.khepri.adventure.game.behaviours.Room getBehaviour() {
        if (gameObject == null) {
            return null;
        }
        return (be.khepri.adventure.game.behaviours.Room) gameObject.getBehaviour(be.khepri.adventure.game.behaviours.Room.class.getName());
    }

    @Override
    public void update(Observable o, Object arg) {
        GameObject gameObject = (GameObject) o;
        if (!gameObject.getBehaviour(Transform.class.getName()).equals(this.transform)) {
            gameObject.deleteObserver(this);
            contains.remove(gameObject);
            this.notifyObservers(RoomAction.Left(gameObject));
        }
>>>>>>> Alpha 1.0
    }
}
