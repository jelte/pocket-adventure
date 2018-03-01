package be.khepri.adventure.tasks;

import android.os.AsyncTask;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.data.WorldDatabase;

public class SaveGameObject extends AsyncTask<GameObject, Void, Void> {
    private WorldDatabase database;

    public SaveGameObject(WorldDatabase database) {
        this.database = database;
    }

    @Override
    protected Void doInBackground(GameObject... params) {
        System.out.println("Updating gameObject");
        database.updateGameObjects(params);
        return null;
    }
}
