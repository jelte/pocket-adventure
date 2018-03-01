package be.khepri.adventure.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import be.khepri.adventure.ui.fragments.CharacterFragment;
import be.khepri.adventure.ui.fragments.ConsoleFragment;
import be.khepri.adventure.ui.fragments.InventoryFragment;
import be.khepri.adventure.ui.fragments.MapFragment;

/**
 * Created by Jelte on 15/02/2018.
 */

public class GameWindowPagerAdapter extends FragmentPagerAdapter
{
    Class<? extends Fragment>[] classes;

    public GameWindowPagerAdapter(FragmentManager fm, Class<? extends Fragment>[] classes) {
        super(fm);
        this.classes = classes;
    }

    @Override
    public Fragment getItem(int position) {
        try {
            return classes[position].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return classes.length;
    }
}
