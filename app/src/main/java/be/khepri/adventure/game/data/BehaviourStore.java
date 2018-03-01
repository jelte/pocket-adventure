package be.khepri.adventure.game.data;

import android.arch.persistence.room.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import be.khepri.adventure.game.Behaviour;

public class BehaviourStore<T extends Behaviour> {
    private Map<UUID, Behaviour> values;
    private DaoImpl<T> dao;

    public BehaviourStore(DaoImpl<T> dao)
    {
        values = new HashMap<>();
        this.dao = dao;
    }

    public Behaviour find(UUID id) {
        if (values.containsKey(id)) {
            return values.get(id);
        }

        Behaviour value = dao.find(id);
        if (value == null) {
            System.out.println("did not find behaviour");
            return null;
        }

        values.put(id, value);
        return value;
    }

    public void update(Behaviour behaviour) {
        if (behaviour == null) {
            return;
        }

        if (this.find(behaviour.getId()) == null) {
            this.dao.insert((T) behaviour);
        } else {
            this.dao.update((T) behaviour);
        }
    }
}
