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
<<<<<<< HEAD
        System.out.println("Updating gameObject");
=======
>>>>>>> Alpha 1.0
        database.updateGameObjects(params);
        return null;
    }
}
