package be.khepri.adventure.game;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;


@Entity
public class Player {
    @PrimaryKey @NonNull
    private UUID id;
    @ColumnInfo(name="game_object_id")
    private UUID gameObjectId;
    @ColumnInfo
    private boolean system = false;

    public Player()
    {
        this.id = UUID.randomUUID();
        this.system = true;
    }

    public Player(GameObject gameObject)
    {
        this(UUID.randomUUID(), gameObject);
    }

    public Player(UUID uuid, GameObject gameObject)
    {
        this.id = uuid;
        gameObjectId = gameObject.getId();
    }

    public UUID getId()
    {
        return id;
    }
    public void setId(UUID id) { this.id = id; }

    public UUID getGameObjectId()
    {
        return gameObjectId;
    }
    public void setGameObjectId(UUID gameObjectId) { this.gameObjectId = gameObjectId; }

    public boolean isSystem() { return system; }
    public void setSystem(boolean system) { this.system = system; }
}
