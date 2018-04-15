package be.khepri.adventure.game.data.dao.behaviours;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.behaviours.Lockable;
import be.khepri.adventure.game.data.DaoImpl;

@Dao
public interface LockableDao extends DaoImpl<Lockable> {
    @Query("SELECT * FROM lockable")
    List<Lockable> getAll();

    @Query("SELECT * FROM lockable WHERE id = :id")
    Lockable find(UUID id);
}
