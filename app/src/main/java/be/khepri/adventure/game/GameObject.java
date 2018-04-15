package be.khepri.adventure.game;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.data.AbstractBehaviour;
=======
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import be.khepri.adventure.engine.World;
>>>>>>> Alpha 1.0
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
<<<<<<< HEAD
    private List<Behaviour> behaviours;
=======
    private HashMap<String, Behaviour> behaviours;
    @Ignore
    private List<Behaviour> removedBehaviours = new ArrayList<>();
>>>>>>> Alpha 1.0

    @Ignore
    public GameObject()
    {
        this(UUID.randomUUID());
    }

    public GameObject(@NonNull UUID id) {
        this.id = id;
<<<<<<< HEAD
        this.behaviours = new ArrayList<>();
=======
        this.behaviours = new HashMap<>();
>>>>>>> Alpha 1.0
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

<<<<<<< HEAD
    public List<Behaviour> getBehaviours() {
=======
    public HashMap<String, Behaviour> getBehaviours() {
>>>>>>> Alpha 1.0
        return behaviours;
    }

    public boolean hasBehaviour(String behaviourClass) {
<<<<<<< HEAD
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
=======
        return behaviours.containsKey(behaviourClass);
    }

    public Behaviour getBehaviour(String behaviourClass) {
        return behaviours.get(behaviourClass);
    }

    public void addBehaviour(Behaviour behaviour) {
        this.behaviours.put(behaviour.getClass().getName(), behaviour);
        behaviour.addObserver(this);
        this.setChanged();
        this.notifyObservers();
>>>>>>> Alpha 1.0
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(this);
    }
<<<<<<< HEAD
=======

    public void removeBehaviour(Behaviour behaviour) {
        this.behaviours.remove(behaviour.getClass().getName());
        this.removedBehaviours.add(behaviour);
        this.setChanged();
        this.notifyObservers();
    }

    public List<Behaviour> getRemovedBehaviours() { return this.removedBehaviours; }
>>>>>>> Alpha 1.0
}
