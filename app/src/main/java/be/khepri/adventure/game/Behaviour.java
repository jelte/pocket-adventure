package be.khepri.adventure.game;

import java.io.Serializable;
import java.util.UUID;

import be.khepri.adventure.util.Observer;

public interface Behaviour extends Serializable {
    UUID getId();
    void addObserver(Observer o);
    void deleteObserver(Observer o);
}
