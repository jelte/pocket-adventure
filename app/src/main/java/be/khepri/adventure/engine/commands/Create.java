package be.khepri.adventure.engine.commands;

import android.content.Intent;
import android.graphics.Color;

import be.khepri.adventure.engine.Command;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.ui.activities.EditGameObjectActivity;
import be.khepri.adventure.ui.views.ConsoleView;

import static android.support.v4.content.ContextCompat.startActivity;

public class Create implements Command
{
    @Override
    public boolean matches(String commandString) {
        return commandString.matches("(create)( (.*)?)?");
    }

    @Override
    public void execute(String commandString) {
       // console.addLine("Loading creation screen... please wait...", Color.YELLOW);
        Intent intent = new Intent(null, EditGameObjectActivity.class);
//        intent.putExtra("Transform", World.getInstance().getPlayerObject().getBehaviour(Transform.class.toString()));
        startActivity(null, intent, null);
    }
}
