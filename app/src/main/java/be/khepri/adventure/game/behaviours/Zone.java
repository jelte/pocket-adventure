package be.khepri.adventure.game.behaviours;

<<<<<<< HEAD
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;
=======
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
>>>>>>> Alpha 1.0

import java.util.UUID;

import be.khepri.adventure.game.data.AbstractBehaviour;
import be.khepri.adventure.game.GameObject;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = GameObject.class,
        parentColumns = "id",
        childColumns = "id",
        onDelete = CASCADE,
        onUpdate = CASCADE
))
public class Zone extends AbstractBehaviour
{
<<<<<<< HEAD
=======
    @Ignore
    public Zone() { super(); }
>>>>>>> Alpha 1.0
    public Zone(UUID id) {
        super(id);
    }
}
