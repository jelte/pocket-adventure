package be.khepri.adventure.game.behaviours;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;

<<<<<<< HEAD
import java.util.UUID;

=======
import java.util.Arrays;
import java.util.UUID;

import be.khepri.adventure.game.Direction;
>>>>>>> Alpha 1.0
import be.khepri.adventure.game.data.AbstractBehaviour;
import be.khepri.adventure.game.GameObject;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = GameObject.class,
        parentColumns = "id",
        childColumns = "id",
        onDelete = CASCADE,
        onUpdate = CASCADE
))
public class Room extends AbstractBehaviour
{
<<<<<<< HEAD
    public Room(UUID id) {
        super(id);
    }
=======
    @ColumnInfo
    private Direction[] directions;

    @Ignore
    public Room() { super(); }
    public Room(UUID id) {
        super(id);
    }

    public Direction[] getDirections() { return directions; }

    public void setDirections(Direction[] directions) { this.directions = directions; }

    public boolean hasConnection(Direction direction) {
        if (directions == null) {
            return false;
        }
        return Arrays.asList(directions).contains(direction);
    }
>>>>>>> Alpha 1.0
}
