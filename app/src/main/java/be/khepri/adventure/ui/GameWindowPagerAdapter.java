package be.khepri.adventure.ui;

<<<<<<< HEAD
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import be.khepri.adventure.ui.fragments.CharacterFragment;
import be.khepri.adventure.ui.fragments.ConsoleFragment;
import be.khepri.adventure.ui.fragments.InventoryFragment;
import be.khepri.adventure.ui.fragments.MapFragment;
=======
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
>>>>>>> Alpha 1.0

/**
 * Created by Jelte on 15/02/2018.
 */

<<<<<<< HEAD
public class GameWindowPagerAdapter extends FragmentPagerAdapter
=======
public class GameWindowPagerAdapter extends FragmentStatePagerAdapter
>>>>>>> Alpha 1.0
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
<<<<<<< HEAD
=======

    public void setClasses(Class<? extends Fragment>[] classes) {
        this.classes = classes;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {

    }
>>>>>>> Alpha 1.0
}
