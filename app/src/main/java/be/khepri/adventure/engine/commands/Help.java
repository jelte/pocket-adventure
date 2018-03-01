package be.khepri.adventure.engine.commands;

import android.content.Intent;
import android.graphics.Color;

import be.khepri.adventure.engine.Command;
import be.khepri.adventure.ui.activities.HelpActivity;
import be.khepri.adventure.ui.views.ConsoleView;

import static android.support.v4.content.ContextCompat.startActivity;

public class Help implements Command
{
    @Override
    public boolean matches(String commandString) {
        return commandString.matches("(help)( (.*)?)?");
    }

    @Override
    public void execute(String commandString) {
        //console.addLine("Loading help... please wait...", Color.YELLOW);
        Intent intent = new Intent(null, HelpActivity.class);
        startActivity(null, intent, null);
    }
}
