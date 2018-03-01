package be.khepri.adventure.game.data.dao.behaviours;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;
import java.util.UUID;

import be.khepri.adventure.game.behaviours.Character;
import be.khepri.adventure.game.data.DaoImpl;

@Dao
public interface CharacterDao extends DaoImpl<Character> {
    @Query("SELECT * FROM character WHERE id = :id")
    Character find(UUID id);

    @Query("SELECT * FROM character WHERE id IN (:ids)")
    List<Character> find(UUID... ids);

}