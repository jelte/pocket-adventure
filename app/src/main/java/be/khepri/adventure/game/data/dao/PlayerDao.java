package be.khepri.adventure.game.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.Player;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM player")
    List<Player> getAll();

    @Query("SELECT * FROM player WHERE id = :id")
    Player find(UUID id);

    @Query("SELECT * FROM player WHERE system = 1")
    Player findSystemPlayer();

    @Insert
    void insertAll(Player... players);

    @Update
    void updateAll(Player... players);

    @Delete
    void delete(Player player);
}
