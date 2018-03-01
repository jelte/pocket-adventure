package be.khepri.adventure.game.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.data.dao.GameObjectDao;

public class GameObjectStore {
    private Map<UUID, GameObject> values;
    private GameObjectDao dao;

    public GameObjectStore(GameObjectDao dao)
    {
        values = new HashMap<>();
        this.dao = dao;
    }

    public GameObject find(UUID id) {
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
    }
}
