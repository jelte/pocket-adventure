package be.khepri.adventure.game.data.dao.behaviours;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.behaviours.Zone;
import be.khepri.adventure.game.data.DaoImpl;

@Dao
public interface ZoneDao extends DaoImpl<Zone> {
    @Query("SELECT * FROM zone")
    List<Zone> getAll();

    @Query("SELECT * FROM zone WHERE id = :id")
    Zone find(UUID id);
}
