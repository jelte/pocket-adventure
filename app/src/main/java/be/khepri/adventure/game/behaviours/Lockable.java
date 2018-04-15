package be.khepri.adventure.game.behaviours;

import android.arch.persistence.room.ColumnInfo;
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
public class Lockable extends AbstractBehaviour
{
    @ColumnInfo
    private boolean locked = false;

    @Ignore
    public Lockable() { super(); }
    public Lockable(UUID id) {
        super(id);
    }

    public boolean isLocked() { return this.locked; }
    public void setLocked(boolean locked) { this.locked = locked; }
}
