package be.khepri.adventure.game.data.dao.behaviours;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.game.data.DaoImpl;

@Dao
public interface TransformDao  extends DaoImpl<Transform> {
    @Query("SELECT * FROM transform WHERE location = :location AND coordinates = :coordinates")
    List<Transform> getAllAt(UUID location, Vector2D coordinates);

    @Query("SELECT * FROM transform WHERE id = :id")
    Transform find(UUID id);
}
