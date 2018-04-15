package be.khepri.adventure.ui.activities;

<<<<<<< HEAD
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
=======
import android.app.FragmentManager;
import android.content.res.Resources;
>>>>>>> Alpha 1.0
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
<<<<<<< HEAD
=======
import android.support.v4.view.PagerAdapter;
>>>>>>> Alpha 1.0
import android.support.v4.view.ViewPager;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.World;
<<<<<<< HEAD
import be.khepri.adventure.services.WorldService;
import be.khepri.adventure.ui.GameWindowPagerAdapter;
import be.khepri.adventure.ui.fragments.CharacterFragment;
import be.khepri.adventure.ui.fragments.ConsoleFragment;
import be.khepri.adventure.ui.fragments.InventoryFragment;
=======
import be.khepri.adventure.ui.GameWindowPagerAdapter;
import be.khepri.adventure.ui.fragments.ConsoleFragment;
>>>>>>> Alpha 1.0
import be.khepri.adventure.ui.fragments.LibraryFragment;
import be.khepri.adventure.ui.fragments.MapFragment;
import be.khepri.adventure.ui.fragments.RoomFragment;

public class CreateActivity extends FragmentActivity {
<<<<<<< HEAD
;
=======
>>>>>>> Alpha 1.0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_load_game);

<<<<<<< HEAD
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                initView();
            }
        }, new IntentFilter(WorldService.MSG_WORLD_SERVICE_INITIALIZED));

        /*World manager = World.getInstance();
=======
        World manager = World.getInstance();
>>>>>>> Alpha 1.0

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
<<<<<<< HEAD
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
=======
            initView();
        }
    }

    private void initView() {
        setContentView(R.layout.activity_game);

        ViewPager extraViewPager = findViewById(R.id.view_pager_extra);

        if (extraViewPager != null) {
            initPager(extraViewPager, new Class[] { MapFragment.class });
            initPager(findViewById(R.id.view_pager), new Class[]{
                RoomFragment.class,
                LibraryFragment.class,
                ConsoleFragment.class
            });
        } else {
            initPager(findViewById(R.id.view_pager), new Class[]{
                MapFragment.class,
                RoomFragment.class,
                LibraryFragment.class,
                ConsoleFragment.class
            });
        }
    }

>>>>>>> Alpha 1.0
    private void initPager(ViewPager viewPager, Class<? extends Fragment>[] classes) {
        if (viewPager == null) {
            return;
        }
<<<<<<< HEAD
        GameWindowPagerAdapter mAdapter = new GameWindowPagerAdapter(getSupportFragmentManager(), classes);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(1);
    }
}
=======
        viewPager.clearDisappearingChildren();
        GameWindowPagerAdapter mAdapter = (GameWindowPagerAdapter) viewPager.getAdapter();

        if (mAdapter == null) {
            mAdapter = new GameWindowPagerAdapter(getSupportFragmentManager(), classes);
            viewPager.setAdapter(mAdapter);
        } else {
            mAdapter.setClasses(classes);
        }

        viewPager.setOffscreenPageLimit(classes.length-1);
        if (classes.length > 3) {
            viewPager.setCurrentItem(1);
        } else {
            viewPager.setCurrentItem(0);
        }
    }
}
>>>>>>> Alpha 1.0
