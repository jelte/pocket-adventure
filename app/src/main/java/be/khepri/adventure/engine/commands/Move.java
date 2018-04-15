package be.khepri.adventure.engine.commands;

import android.graphics.Color;
<<<<<<< HEAD
import android.os.AsyncTask;
=======
>>>>>>> Alpha 1.0

import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
import be.khepri.adventure.engine.Command;
import be.khepri.adventure.game.Direction;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.game.behaviours.Transform;
=======
import be.khepri.adventure.engine.Character;
import be.khepri.adventure.engine.Command;
import be.khepri.adventure.game.Direction;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.engine.World;
>>>>>>> Alpha 1.0
import be.khepri.adventure.ui.views.ConsoleView;

public class Move implements Command
{
    @Override
    public boolean matches(String commandString) {
        return commandString.matches("(move )?(("+String.join( ")|(", directions().keySet())+"))");
    }

    @Override
<<<<<<< HEAD
    public void execute(String commandString) {
=======
    public void execute(String commandString, ConsoleView console) {
>>>>>>> Alpha 1.0
        String value = commandString.replaceAll("(move )?(("+String.join( ")|(", directions().keySet())+"))", "$2");

        final Direction direction = directions().get(value);

<<<<<<< HEAD
        //console.addLine("Moving "+direction.toString().toLowerCase(), Color.WHITE);
        new AsyncTask<Void, Void, GameObject>() {
            @Override
            protected GameObject doInBackground(Void... params) {
                return World.getInstance().getPlayerObject();
            }

            @Override
            protected void onPostExecute(GameObject gameObject) {
                if (gameObject == null) {
                   //console.addLine("Error: Could not move.", Color.RED);
                }
                Transform transform = ((Transform) gameObject.getBehaviour(Transform.class.getName()));
                switch (direction) {
                    case NORTH:
                        transform.move(Vector2D.UP);
                        break;
                    case EAST:
                        transform.move(Vector2D.RIGHT);
                        break;
                    case SOUTH:
                        transform.move(Vector2D.DOWN);
                        break;
                    case WEST:
                        transform.move(Vector2D.LEFT);
                        break;
                }
            }
        }.execute();
=======
        console.addLine("Moving "+direction.toString().toLowerCase(), Color.WHITE);

        Character character = World.getInstance().getPlayer();
        switch (direction) {
            case NORTH:
                character.move(Vector2D.UP);
                break;
            case EAST:
                character.move(Vector2D.RIGHT);
                break;
            case SOUTH:
                character.move(Vector2D.DOWN);
                break;
            case WEST:
                character.move(Vector2D.LEFT);
                break;
        }
>>>>>>> Alpha 1.0
    }

    private Map<String, Direction> directions() {
        Map<String,Direction> values = new HashMap<>();
        for (Direction direction: Direction.values()) {
            values.put(direction.toString().toLowerCase().substring(0, 1), direction);
            values.put(direction.toString().toLowerCase(), direction);
        }
        return values;
    }
}
