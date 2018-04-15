package be.khepri.adventure.game.data;

import android.arch.persistence.room.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import be.khepri.adventure.game.Behaviour;

public class BehaviourStore<T extends Behaviour> {
<<<<<<< HEAD
    private Map<UUID, Behaviour> values;
=======
    private Map<String, Behaviour> values;
>>>>>>> Alpha 1.0
    private DaoImpl<T> dao;

    public BehaviourStore(DaoImpl<T> dao)
    {
        values = new HashMap<>();
        this.dao = dao;
    }

    public Behaviour find(UUID id) {
<<<<<<< HEAD
        if (values.containsKey(id)) {
            return values.get(id);
=======
        if (values.containsKey(id.toString())) {
            return values.get(id.toString());
>>>>>>> Alpha 1.0
        }

        Behaviour value = dao.find(id);
        if (value == null) {
            System.out.println("did not find behaviour");
            return null;
        }

<<<<<<< HEAD
        values.put(id, value);
=======
        values.put(id.toString(), value);
>>>>>>> Alpha 1.0
        return value;
    }

    public void update(Behaviour behaviour) {
        if (behaviour == null) {
            return;
        }

<<<<<<< HEAD
        if (this.find(behaviour.getId()) == null) {
            this.dao.insert((T) behaviour);
        } else {
            this.dao.update((T) behaviour);
        }
=======
        if (values.containsKey(behaviour.getId().toString())) {
            this.dao.update((T) behaviour);
        } else {
            this.dao.insert((T) behaviour);
        }
        values.put(behaviour.getId().toString(), behaviour);
    }

    public void remove(Behaviour behaviour) {
        values.remove(behaviour.getId().toString());
        this.dao.delete((T) behaviour);
    }

    public void insert(Behaviour behaviour) {
        if (behaviour == null) {
            return;
        }

        values.put(behaviour.getId().toString(), behaviour);
        this.dao.insert((T) behaviour);
>>>>>>> Alpha 1.0
    }
}
