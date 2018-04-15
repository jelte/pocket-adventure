package be.khepri.adventure.engine;

<<<<<<< HEAD
public interface Command {
    boolean matches(String commandString);
    void execute(String commandString);
=======
import be.khepri.adventure.ui.views.ConsoleView;

public interface Command {
    boolean matches(String commandString);
    void execute(String commandString, ConsoleView console);
>>>>>>> Alpha 1.0
}
