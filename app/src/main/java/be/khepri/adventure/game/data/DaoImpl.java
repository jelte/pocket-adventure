package be.khepri.adventure.game.data;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import java.util.UUID;

import be.khepri.adventure.game.Behaviour;

public interface DaoImpl<T extends Behaviour> {
    T find(UUID id);

    @Delete
    void delete(T objects);

    @Insert
    void insert(T behaviour);

    @Update
    void update(T behaviour);
}
