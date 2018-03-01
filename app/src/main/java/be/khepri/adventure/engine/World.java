package be.khepri.adventure.engine;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Player;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Character;
import be.khepri.adventure.game.behaviours.Room;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.game.behaviours.Zone;
import be.khepri.adventure.game.data.WorldDatabase;
import be.khepri.adventure.util.Observable;
import be.khepri.adventure.util.Observer;

public class World extends Observable implements Observer {
    private static World instance;
    private WorldDatabase database;
    private Player player;
    private GameObject playerObject;
    private Map<Transform, Room> rooms = new HashMap<>();

    private Map<UUID, GameObject> gameObjects = new HashMap<>();

    public World(Context applicationContext)
    {
        this.database = android.arch.persistence.room.Room.databaseBuilder(applicationContext, WorldDatabase.class, "world").build();

        World.instance = this;
    }

    public World init()
    {
        this.player = getSystemPlayer();
        this.playerObject = getGameObject(this.player.getGameObjectId());

        return this;
    }

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
        }
        // load game object from database.
        GameObject gameObject = this.database.findGameObject(id);
        if (gameObject == null) {
            return null;
        }
        // observer game object for any changes.
        gameObject.addObserver(this);
        // Store game object in memory.
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
}
