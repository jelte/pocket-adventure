package be.khepri.adventure.game.behaviours;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import java.util.UUID;

import be.khepri.adventure.game.data.AbstractBehaviour;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Vector2D;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {
    @ForeignKey(
        entity = GameObject.class,
        parentColumns = "id",
        childColumns = "id",
        onDelete = CASCADE,
        onUpdate = CASCADE
    ),
    @ForeignKey(
        entity = GameObject.class,
        parentColumns = "id",
        childColumns = "location",
        onDelete = CASCADE,
        onUpdate = CASCADE
    )
})
public class Transform extends AbstractBehaviour
{
    @ColumnInfo
    private UUID location;

    @ColumnInfo
    private Vector2D coordinates;

    @Ignore
    public Transform()
    {
        super();
    }

    public Transform(@NonNull UUID id, UUID location, Vector2D coordinates)
    {
        super(id);
        this.location = location;
        this.coordinates = coordinates;
    }

    public UUID getLocation() { return location; }
    public void setLocation(UUID location) {
        this.location = location;
        this.setChanged();
        this.notifyObservers(this);
    }

    public Vector2D getCoordinates() {
        return coordinates;
    }
    public void move(Vector2D direction) {
        coordinates = coordinates.plus(direction);
        this.setChanged();
        this.notifyObservers(this);
    }
}
