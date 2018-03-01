package be.khepri.adventure.game;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.data.AbstractBehaviour;
import be.khepri.adventure.util.Observable;
import be.khepri.adventure.util.Observer;

@Entity
public class GameObject extends Observable implements Observer
{
    @PrimaryKey @NonNull
    private UUID id;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String description;

    @Ignore
    private List<Behaviour> behaviours;

    @Ignore
    public GameObject()
    {
        this(UUID.randomUUID());
    }

    public GameObject(@NonNull UUID id) {
        this.id = id;
        this.behaviours = new ArrayList<>();
    }

    @NonNull
    public UUID getId() {
        return id;
    }
    public void setId(@NonNull UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
        this.setChanged();
        this.notifyObservers();
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Behaviour> getBehaviours() {
        return behaviours;
    }

    public boolean hasBehaviour(String behaviourClass) {
        return getBehaviour(behaviourClass) != null;
    }

    public Behaviour getBehaviour(String behaviourClass) {
        for (Behaviour behaviour : behaviours) {
            if (behaviour.getClass().getName().equals(behaviourClass)) {
                return behaviour;
            }
        }
        return null;
    }

    public void addBehaviour(Behaviour behaviour) {
        this.behaviours.add(behaviour);
        behaviour.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(this);
    }
}
