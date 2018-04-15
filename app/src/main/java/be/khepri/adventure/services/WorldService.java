package be.khepri.adventure.services;

import android.app.Service;
<<<<<<< HEAD
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
=======
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import be.khepri.adventure.engine.CommandInterpreter;

public class WorldService extends Service {

    CommandInterpreter commandInterpreter = new CommandInterpreter();

    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {

            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.  We also make it
        // background priority so CPU-intensive work will not disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
>>>>>>> Alpha 1.0
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
