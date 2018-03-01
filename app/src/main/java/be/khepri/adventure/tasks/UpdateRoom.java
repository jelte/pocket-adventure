package be.khepri.adventure.tasks;

import android.os.AsyncTask;

import be.khepri.adventure.engine.Room;
import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.ui.views.ConsoleView;

/**
 * Created by Jelte on 18/02/2018.
 */

public class UpdateRoom extends AsyncTask<Transform, Void, Room> {
    private PostExecuteAction<Room> postExecuteAction;
    private World world;
    private ConsoleView console;

    public UpdateRoom(World world, ConsoleView console, PostExecuteAction<Room> postExecuteAction) {
        this.world = world;
        this.console = console;
        this.postExecuteAction = postExecuteAction;
    }

    @Override
    protected Room doInBackground(Transform... params) {
        for (Transform transform : params) {
            return new Room(transform, world.getGameObjects(transform));
        }
        return null;
    }

    @Override
    protected void onPostExecute(Room room) {
        this.postExecuteAction.onPostExecute(room);
    }
}
