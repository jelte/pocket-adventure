package be.khepri.adventure.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

import be.khepri.adventure.engine.CommandInterpreter;
import be.khepri.adventure.engine.World;

public class WorldService extends Service {

    public static final String MSG_WORLD_SERVICE_INITIALIZED = "WORLD_SERVICE_INITIALIZED";
    public static final String MSG_TO_WORLD_SERVICE = "WORLD_SERVICE_DO";
    public static final String WORLD_COMMAND = "WORLD_SERVICE_DO_COMMAND";
    public static final String ERR_UNKNOWN_COMMAND = "WORLD_SERVICE_ERROR_UNKNOWN_COMMAND";

    private World world;
    private CommandInterpreter interpreter;

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"World service started",Toast.LENGTH_LONG).show();

        world = new World(getApplicationContext());
        //world.init();

        super.onCreate();

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (!interpreter.interpret(intent.getStringExtra(WORLD_COMMAND))) {
                    Intent errIntent = new Intent(ERR_UNKNOWN_COMMAND);
                    errIntent.putExtra("command", intent.getStringExtra(WORLD_COMMAND));
                    sendBroadcast(errIntent);
                }
            }
        }, new IntentFilter(MSG_TO_WORLD_SERVICE));

        sendBroadcast(new Intent(MSG_WORLD_SERVICE_INITIALIZED));
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
