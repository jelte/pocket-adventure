package be.khepri.adventure.ui.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.CommandInterpreter;
import be.khepri.adventure.services.WorldService;
import be.khepri.adventure.ui.views.ConsoleView;

public class ConsoleFragment extends Fragment {

    CommandInterpreter interpreter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_console, container, false);

        ConsoleView console = view.findViewById(R.id.console_view);

        console.addInputListener((console1, input) -> {
            Intent intent = new Intent(WorldService.MSG_TO_WORLD_SERVICE);
            intent.putExtra(WorldService.WORLD_COMMAND, input);
            getActivity().sendBroadcast(intent);
            return true;
        });

        getActivity().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                console.addLine("Unknown command: "+intent.getStringExtra("command"), Color.RED);
            }
        }, new IntentFilter(WorldService.ERR_UNKNOWN_COMMAND));
/*
        World world = World.getInstance();
        PostExecuteAction<Room> postExecuteAction = returnValue -> {
            if(returnValue.getGameObject() == null) {
                console.addLine("No room add one?", Color.BLUE);
            } else {
                console.addLine("Got Room", Color.GREEN);
            }
        };
        world.addObserver((o, arg) -> {
            if (world.getPlayerObject().equals(arg)) {
            //    new UpdateRoom(world, console, postExecuteAction).execute(((GameObject) arg).getTransform());
            }
        });
*/
        return view;
    }
}
