package be.khepri.adventure.game.behaviours;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

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
    public Zone(UUID id) {
        super(id);
    }
}
