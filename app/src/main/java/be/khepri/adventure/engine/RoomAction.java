package be.khepri.adventure.engine;

import be.khepri.adventure.game.GameObject;

class RoomAction {

    enum Action {LEFT,JOINED}

    private GameObject gameObject;
    private Action action;

    public RoomAction(GameObject gameObject, Action action) {
        this.gameObject = gameObject;
        this.action = action;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public Action getAction() {
        return action;
    }

    public static RoomAction Left(GameObject gameObject) {
        return new RoomAction(gameObject, Action.LEFT);
    }
}
