package be.khepri.adventure.game.behaviours;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
<<<<<<< HEAD
=======
import android.arch.persistence.room.Index;
>>>>>>> Alpha 1.0
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
<<<<<<< HEAD
})
=======
}, indices = @Index("location"))
>>>>>>> Alpha 1.0
public class Transform extends AbstractBehaviour
{
    @ColumnInfo
    private UUID location;
<<<<<<< HEAD

=======
>>>>>>> Alpha 1.0
    @ColumnInfo
    private Vector2D coordinates;

    @Ignore
    public Transform()
    {
        super();
<<<<<<< HEAD
=======
        this.coordinates = new Vector2D();
>>>>>>> Alpha 1.0
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
<<<<<<< HEAD
        this.notifyObservers(this);
=======
>>>>>>> Alpha 1.0
    }

    public Vector2D getCoordinates() {
        return coordinates;
    }
    public void move(Vector2D direction) {
        coordinates = coordinates.plus(direction);
        this.setChanged();
<<<<<<< HEAD
        this.notifyObservers(this);
=======
    }

    public void setCoordinates(Vector2D coordinates) {
        this.coordinates = coordinates;
        this.setChanged();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Transform)) {
            return false;
        }

        return super.equals(obj) || this.coordinates.equals(((Transform) obj).coordinates);
    }

    public String toString()
    {
        return "Transform: " + this.coordinates.toString();
>>>>>>> Alpha 1.0
    }
}
