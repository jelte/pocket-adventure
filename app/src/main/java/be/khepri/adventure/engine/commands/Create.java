package be.khepri.adventure.engine.commands;

import android.content.Intent;
import android.graphics.Color;

import be.khepri.adventure.engine.Command;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.ui.activities.EditGameObjectActivity;
import be.khepri.adventure.ui.views.ConsoleView;

import static android.support.v4.content.ContextCompat.startActivity;
<<<<<<< HEAD
=======
import static be.khepri.adventure.ui.activities.EditGameObjectActivity.PARAM_LOCATION_ID;
import static be.khepri.adventure.ui.activities.EditGameObjectActivity.PARAM_POSITION_X;
import static be.khepri.adventure.ui.activities.EditGameObjectActivity.PARAM_POSITION_Y;
>>>>>>> Alpha 1.0

public class Create implements Command
{
    @Override
    public boolean matches(String commandString) {
        return commandString.matches("(create)( (.*)?)?");
    }

    @Override
<<<<<<< HEAD
    public void execute(String commandString) {
       // console.addLine("Loading creation screen... please wait...", Color.YELLOW);
        Intent intent = new Intent(null, EditGameObjectActivity.class);
//        intent.putExtra("Transform", World.getInstance().getPlayerObject().getBehaviour(Transform.class.toString()));
        startActivity(null, intent, null);
=======
    public void execute(String commandString, ConsoleView console) {
        console.addLine("Loading creation screen... please wait...", Color.YELLOW);
        Intent intent = new Intent(console.getContext(), EditGameObjectActivity.class);
        if ( commandString.matches("(create)( here)")) {
            Transform transform = World.getInstance().getPlayer().getTransform();
            intent.putExtra(PARAM_LOCATION_ID, transform.getLocation().toString());
            intent.putExtra(PARAM_POSITION_X, transform.getCoordinates().getX());
            intent.putExtra(PARAM_POSITION_Y, transform.getCoordinates().getY());
            startActivity(console.getContext(), intent, null);
        } else {
            startActivity(console.getContext(), intent, null);
        }
>>>>>>> Alpha 1.0
    }
}
