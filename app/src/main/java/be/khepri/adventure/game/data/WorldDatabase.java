package be.khepri.adventure.game.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import be.khepri.adventure.game.Behaviour;
import be.khepri.adventure.game.Converters;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Player;
import be.khepri.adventure.game.behaviours.Character;
<<<<<<< HEAD
=======
import be.khepri.adventure.game.behaviours.Container;
import be.khepri.adventure.game.behaviours.Lockable;
>>>>>>> Alpha 1.0
import be.khepri.adventure.game.behaviours.Room;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.game.behaviours.Zone;
import be.khepri.adventure.game.data.dao.GameObjectDao;
import be.khepri.adventure.game.data.dao.PlayerDao;
import be.khepri.adventure.game.data.dao.behaviours.CharacterDao;
<<<<<<< HEAD
=======
import be.khepri.adventure.game.data.dao.behaviours.ContainerDao;
import be.khepri.adventure.game.data.dao.behaviours.LockableDao;
>>>>>>> Alpha 1.0
import be.khepri.adventure.game.data.dao.behaviours.RoomDao;
import be.khepri.adventure.game.data.dao.behaviours.TransformDao;
import be.khepri.adventure.game.data.dao.behaviours.ZoneDao;
import be.khepri.adventure.tasks.SaveGameObject;

@Database(entities = {
    Player.class,
    GameObject.class,
    Zone.class,
    Transform.class,
    Room.class,
<<<<<<< HEAD
    Character.class
}, version = 1)
=======
    Character.class,
    Lockable.class,
    Container.class
}, version = 1, exportSchema = false)
>>>>>>> Alpha 1.0
@TypeConverters({Converters.class})
public abstract class WorldDatabase extends RoomDatabase {
    public abstract PlayerDao playerDao();
    public abstract GameObjectDao gameObjectDao();
    public abstract ZoneDao zoneDao();
    public abstract RoomDao roomDao();
    public abstract TransformDao transformDao();
    public abstract CharacterDao characterDao();
<<<<<<< HEAD
=======
    public abstract LockableDao lockableDao();
    public abstract ContainerDao containerDao();
>>>>>>> Alpha 1.0

    private GameObjectStore gameObjects;
    private Map<String, BehaviourStore> memories;

    @Override
    public void init(@NonNull DatabaseConfiguration configuration) {
        super.init(configuration);

        gameObjects = new GameObjectStore(gameObjectDao());
        memories = new HashMap<>();
        memories.put(Zone.class.getName(), new BehaviourStore<Zone>(zoneDao()));
        memories.put(Room.class.getName(), new BehaviourStore<Room>(roomDao()));
        memories.put(Transform.class.getName(), new BehaviourStore<Transform>(transformDao()));
        memories.put(Character.class.getName(), new BehaviourStore<Character>(characterDao()));
<<<<<<< HEAD
=======
        memories.put(Lockable.class.getName(), new BehaviourStore<Lockable>(lockableDao()));
        memories.put(Container.class.getName(), new BehaviourStore<Container>(containerDao()));
>>>>>>> Alpha 1.0
    }

    public GameObject findGameObject(UUID id) {
        // Retrieve Game Object from database
        GameObject gameObject = gameObjects.find(id);

        if (gameObject == null) {
            return null;
        }

        // Load behaviours
        for (Map.Entry<String, BehaviourStore> dm : memories.entrySet()) {
            Behaviour behaviour = dm.getValue().find(gameObject.getId());
            if (behaviour != null) {
                gameObject.addBehaviour(behaviour);
            }
        }

        // Add save observer
        gameObject.addObserver((o, arg) -> {
            new SaveGameObject(this).execute((GameObject) o);
        });

        return gameObject;
    }

    public List<GameObject> getGameObjects(Transform transform) {
<<<<<<< HEAD
        List<Transform> transforms = transformDao().getAllAt(transform.getLocation(), transform.getCoordinates());
        UUID[] ids = new UUID[transforms.size()];
        int i = 0;
        for (Transform trans : transforms) {
            ids[i++] = trans.getId();
        }
        return gameObjectDao().find(ids);
    }

    public void updateGameObjects(GameObject... gameObjects) {
        for (GameObject gameObject : gameObjects) {
            this.gameObjects.update(gameObject);
            for (Map.Entry<String, BehaviourStore> entry : this.memories.entrySet()) {
                entry.getValue().update(gameObject.getBehaviour(entry.getKey()));
=======
        ArrayList<GameObject> objects = new ArrayList<>();
        if (transform == null) {
            return objects;
        }
        List<Transform> transforms = transformDao().getAllAt(transform.getCoordinates());
        for (Transform trans : transforms) {
            GameObject gameObject = findGameObject(trans.getId());
            if (gameObject != null) {
                objects.add(gameObject);
            }
        }
        return objects;
    }

    public void addGameObjects(GameObject... gameObjects) {
        for (GameObject gameObject : gameObjects) {
            this.gameObjects.insert(gameObject);

            for (Map.Entry<String, Behaviour> entry : gameObject.getBehaviours().entrySet()) {
                memories.get(entry.getKey()).insert(entry.getValue());
            }
        }
    }


    public void updateGameObjects(GameObject... gameObjects) {
        for (GameObject gameObject : gameObjects) {
            this.gameObjects.update(gameObject);

            for (Map.Entry<String, Behaviour> entry : gameObject.getBehaviours().entrySet()) {
                memories.get(entry.getKey()).update(entry.getValue());
            }

            for (Behaviour removed : gameObject.getRemovedBehaviours()) {
                this.memories.get(removed.getClass().getName()).remove(removed);
>>>>>>> Alpha 1.0
            }
        }
    }

    public LiveData<List<GameObject>> findGameObjects(String query) {
        return this.gameObjectDao().search("%"+query+"%");
    }
}
