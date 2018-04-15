package be.khepri.adventure.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import be.khepri.adventure.R;
<<<<<<< HEAD
import be.khepri.adventure.services.WorldService;
=======
>>>>>>> Alpha 1.0

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onItemSelect(View source)
    {
        Class activityClass = null;
        switch(source.getId()) {
            case R.id.btn_create:
                activityClass = CreateActivity.class;
                break;
            case R.id.btn_play:
                activityClass = CreateActivity.class;
                break;
            case R.id.btn_help:
                activityClass = HelpActivity.class;
                break;
        }
        startActivity(new Intent(getBaseContext(), activityClass), null);
    }
}
