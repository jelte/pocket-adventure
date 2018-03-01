package be.khepri.adventure.game.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

import be.khepri.adventure.game.Behaviour;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.util.Observable;

@Entity
public abstract class AbstractBehaviour extends Observable implements Behaviour
{
    @PrimaryKey
    @NonNull
    private UUID id;

    @Ignore
    protected GameObject gameObject;

    public AbstractBehaviour() {}

    public AbstractBehaviour(@NonNull UUID id) {
        this.id = id;
    }

    @NonNull
    public UUID getId() { return id; }
    public void setId(@NonNull UUID id) { this.id = id; }
}
