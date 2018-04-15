package be.khepri.adventure.game.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.data.dao.GameObjectDao;

public class GameObjectStore {
<<<<<<< HEAD
    private Map<UUID, GameObject> values;
=======
    private Map<String, GameObject> values;
>>>>>>> Alpha 1.0
    private GameObjectDao dao;

    public GameObjectStore(GameObjectDao dao)
    {
        values = new HashMap<>();
        this.dao = dao;
    }

    public GameObject find(UUID id) {
<<<<<<< HEAD
        if (values.containsKey(id)) {
            return values.get(id);
        }

        return values.put(id, dao.find(id));
    }

    public void update(GameObject gameObject) {
        if (this.find(gameObject.getId()) != null) {
            this.dao.updateAll(gameObject);
        } else {
            this.dao.insertAll(gameObject);
        }
=======
        if (values.containsKey(id.toString())) {
            return values.get(id.toString());
        }

        GameObject gameObject = dao.find(id);
        values.put(id.toString(), gameObject);
        return gameObject;
    }

    public void insert(GameObject gameObject) {
        this.dao.insertAll(gameObject);
        values.put(gameObject.getId().toString(), gameObject);
    }

    public void update(GameObject gameObject) {
        this.dao.updateAll(gameObject);
        values.put(gameObject.getId().toString(), gameObject);
>>>>>>> Alpha 1.0
    }
}
