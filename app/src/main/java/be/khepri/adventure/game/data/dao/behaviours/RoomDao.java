package be.khepri.adventure.game.data.dao.behaviours;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.behaviours.Room;
import be.khepri.adventure.game.data.DaoImpl;

@Dao
public interface RoomDao extends DaoImpl<Room> {
    @Query("SELECT * FROM room WHERE id = :id")
    Room find(UUID id);

    @Query("SELECT * FROM room WHERE id IN (:ids)")
    List<Room> find(UUID... ids);
}
