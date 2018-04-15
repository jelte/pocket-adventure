package be.khepri.adventure.engine;

import android.graphics.Color;

import java.util.ArrayList;

import be.khepri.adventure.engine.commands.Create;
import be.khepri.adventure.engine.commands.Help;
import be.khepri.adventure.engine.commands.Move;
import be.khepri.adventure.ui.views.ConsoleView;

public class CommandInterpreter {

    private ArrayList<Command> commands = new ArrayList<>();

    public CommandInterpreter()
    {
        commands.add(new Move());
        commands.add(new Help());
        commands.add(new Create());
    }

<<<<<<< HEAD
    public boolean interpret(String commandString)
=======
    public boolean interpret(String commandString, ConsoleView console)
>>>>>>> Alpha 1.0
    {
        commandString = commandString.toLowerCase();
        for (Command command: commands) {
            if (command.matches(commandString)) {
<<<<<<< HEAD
                command.execute(commandString);
                return true;
            }
        }
=======
                command.execute(commandString, console);
                return true;
            }

        }
        console.addLine("Unknown Command: " + commandString, Color.RED);
>>>>>>> Alpha 1.0
        return false;
    }
}
