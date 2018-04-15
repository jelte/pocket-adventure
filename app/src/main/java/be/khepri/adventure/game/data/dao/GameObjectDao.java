package be.khepri.adventure.game.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.game.data.DaoImpl;

@Dao
public interface GameObjectDao {
    @Query("SELECT go.* FROM gameObject go JOIN transform t WHERE t.location = :location and t.coordinates = :coordinates")
    List<GameObject> getAllAtPosition(UUID location, Vector2D coordinates);

    @Query("SELECT * FROM gameObject WHERE id = :uuid")
    GameObject find(UUID uuid);

    @Query("SELECT * FROM gameObject WHERE id IN (:ids)")
    List<GameObject> find(UUID... ids);

    @Insert
    void insertAll(GameObject... objects);

    @Update
    void updateAll(GameObject... objects);

    @Delete
    void delete(GameObject objects);

    @Query("SELECT * FROM gameObject WHERE name like :query or description like :query")
    LiveData<List<GameObject>> search(String query);
<<<<<<< HEAD
=======

    @Query("SELECT * FROM gameObject")
    List<GameObject> findAll();
>>>>>>> Alpha 1.0
}
