package be.khepri.adventure.ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.services.WorldService;
import be.khepri.adventure.ui.GameWindowPagerAdapter;
import be.khepri.adventure.ui.fragments.CharacterFragment;
import be.khepri.adventure.ui.fragments.ConsoleFragment;
import be.khepri.adventure.ui.fragments.InventoryFragment;
import be.khepri.adventure.ui.fragments.LibraryFragment;
import be.khepri.adventure.ui.fragments.MapFragment;
import be.khepri.adventure.ui.fragments.RoomFragment;

public class CreateActivity extends FragmentActivity {
;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_load_game);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                initView();
            }
        }, new IntentFilter(WorldService.MSG_WORLD_SERVICE_INITIALIZED));

        /*World manager = World.getInstance();

        if (manager == null) {
            manager = new World(getApplicationContext());
            new AsyncTask<World, Void, World>() {
                @Override
                protected World doInBackground(World... worlds) {
                    return worlds[0].init();
                }

                @Override
                protected void onPostExecute(World world) {
                    initView();
                }
            }.execute(manager);
        } else {
        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, WorldService.class));
    }

    private void initView() {

        setContentView(R.layout.activity_game);

        initPager(findViewById(R.id.view_pager), new Class[] {
            MapFragment.class,
            ConsoleFragment.class,
            RoomFragment.class,
            LibraryFragment.class
        });
    }
    private void initPager(ViewPager viewPager, Class<? extends Fragment>[] classes) {
        if (viewPager == null) {
            return;
        }
        GameWindowPagerAdapter mAdapter = new GameWindowPagerAdapter(getSupportFragmentManager(), classes);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(1);
    }
}
