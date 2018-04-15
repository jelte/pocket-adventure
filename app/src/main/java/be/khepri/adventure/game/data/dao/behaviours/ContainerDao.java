package be.khepri.adventure.game.data.dao.behaviours;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.behaviours.Container;
import be.khepri.adventure.game.data.DaoImpl;

@Dao
public interface ContainerDao extends DaoImpl<Container> {
    @Query("SELECT * FROM container")
    List<Container> getAll();

    @Query("SELECT * FROM container WHERE id = :id")
    Container find(UUID id);
}
