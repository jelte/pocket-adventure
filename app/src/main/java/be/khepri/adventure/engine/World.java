package be.khepri.adventure.engine;

import android.arch.lifecycle.LiveData;
import android.content.Context;
<<<<<<< HEAD
=======
import android.os.AsyncTask;
>>>>>>> Alpha 1.0

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import be.khepri.adventure.game.GameObject;
<<<<<<< HEAD
import be.khepri.adventure.game.Player;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Character;
import be.khepri.adventure.game.behaviours.Room;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.game.behaviours.Zone;
=======
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Transform;
>>>>>>> Alpha 1.0
import be.khepri.adventure.game.data.WorldDatabase;
import be.khepri.adventure.util.Observable;
import be.khepri.adventure.util.Observer;

public class World extends Observable implements Observer {
<<<<<<< HEAD
    private static World instance;
    private WorldDatabase database;
    private Player player;
    private GameObject playerObject;
    private Map<Transform, Room> rooms = new HashMap<>();

    private Map<UUID, GameObject> gameObjects = new HashMap<>();
=======
    class UpdateRoom extends AsyncTask<Transform, Void, List<GameObject>> {
        private Transform transform;

        @Override
        protected List<GameObject> doInBackground(Transform... transforms) {
            this.transform = transforms[0];
            return database.getGameObjects(this.transform);
        }
        protected void onPostExecute(List<GameObject> result) {
            Room room = new Room(transform, result);
            rooms.put(transform.getCoordinates().toString(), room);
            setChanged();
            notifyObservers(room);
        }
    }

    private static World instance;
    private WorldDatabase database;
    private Character player;
    private static Map<String, Room> rooms = new HashMap<>();

    private Map<String, GameObject> gameObjects = new HashMap<>();
>>>>>>> Alpha 1.0

    public World(Context applicationContext)
    {
        this.database = android.arch.persistence.room.Room.databaseBuilder(applicationContext, WorldDatabase.class, "world").build();

        World.instance = this;
    }

    public World init()
    {
<<<<<<< HEAD
        this.player = getSystemPlayer();
        this.playerObject = getGameObject(this.player.getGameObjectId());
=======
        this.player = getPlayer();
        this.player.addObserver((Observable o, Object arg) -> {
            new UpdateRoom().execute(player.getTransform());
            this.setChanged();
            this.notifyObservers(this.player);
        });
        new UpdateRoom().execute(player.getTransform());
>>>>>>> Alpha 1.0

        return this;
    }

<<<<<<< HEAD
    public Player getSystemPlayer()
    {
        Player player = database.playerDao().findSystemPlayer();
        if (player == null) {

            GameObject zone = new GameObject();
            zone.setName("World");
            zone.addBehaviour(new Zone(zone.getId()));
            GameObject character = new GameObject();
            character.setName("GOD");
            character.addBehaviour(new Transform(character.getId(), zone.getId(), Vector2D.ZERO));
            character.addBehaviour(new Character(character.getId()));

            GameObject room = new GameObject();
            room.setName("Start room");
            room.setDescription("Initial room where it all starts");
            room.addBehaviour(new Transform(room.getId(), zone.getId(), Vector2D.ZERO));
            room.addBehaviour(new Room(room.getId()));

            database.updateGameObjects(zone, character, room);

            player = new Player();
            player.setGameObjectId(character.getId());
            database.playerDao().insertAll(player);
        }

        return player;
    }

    public GameObject getGameObject(UUID id)
    {
        // Check if game object has be previously loaded from database.
        if (gameObjects.containsKey(id)) {
            return gameObjects.get(id);
=======
    public GameObject getGameObject(UUID id)
    {
        // Check if game object has be previously loaded from database.
        if (gameObjects.containsKey(id.toString())) {
            return gameObjects.get(id.toString());
>>>>>>> Alpha 1.0
        }
        // load game object from database.
        GameObject gameObject = this.database.findGameObject(id);
        if (gameObject == null) {
            return null;
        }
        // observer game object for any changes.
        gameObject.addObserver(this);
        // Store game object in memory.
<<<<<<< HEAD
        gameObjects.put(id, gameObject);
        return gameObject;
    }

    public static World getInstance()
    {
        return instance;
    }

    public GameObject getPlayerObject() {
        if (playerObject == null) {
            playerObject = getGameObject(World.getInstance().getSystemPlayer().getGameObjectId());
        }
        return playerObject;
=======
        gameObjects.put(id.toString(), gameObject);
        return gameObject;
    }

    public Character getPlayer() {
        if (player == null) {
            player = new Character(new Transform(null, null, new Vector2D()));
        }
        return player;
>>>>>>> Alpha 1.0
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(o);
    }

    public List<GameObject> getGameObjects(Transform transform) {
        return database.getGameObjects(transform);
    }

    public LiveData<List<GameObject>> findGameObjects(String query) {
        return database.findGameObjects(query);
    }
<<<<<<< HEAD
=======

    public void saveGameObject(GameObject gameObject, boolean isNew) {
        gameObjects.remove(gameObject.getId().toString());
        if (isNew) {
            database.addGameObjects(gameObject);
        } else {
            database.updateGameObjects(gameObject);
        }
        setChanged();
        notifyObservers(gameObject);
        if (gameObject.hasBehaviour(be.khepri.adventure.game.behaviours.Room.class.getName())) {
            Transform transform = (Transform) gameObject.getBehaviour(Transform.class.getName());
            new UpdateRoom().execute(transform);
        }
    }

    public Room getRoom(Vector2D position) {
        return this.rooms.get(position.toString());
    }
    public Room getRoom(Transform transform) {
        if (transform == null) {
            return null;
        }
        return this.getRoom(transform.getCoordinates());
    }

    public static World getInstance()
    {
        return instance;
    }

>>>>>>> Alpha 1.0
}
