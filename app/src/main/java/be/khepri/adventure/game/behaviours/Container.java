package be.khepri.adventure.game.behaviours;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;

import java.util.UUID;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.data.AbstractBehaviour;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = GameObject.class,
        parentColumns = "id",
        childColumns = "id",
        onDelete = CASCADE,
        onUpdate = CASCADE
))
public class Container extends AbstractBehaviour
{
    @Ignore
    public Container() { super(); }
    public Container(UUID id) {
        super(id);
    }
}
