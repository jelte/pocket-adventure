package be.khepri.adventure.engine;

public interface Command {
    boolean matches(String commandString);
    void execute(String commandString);
}
