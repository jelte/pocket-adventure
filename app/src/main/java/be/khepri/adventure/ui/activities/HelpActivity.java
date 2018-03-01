package be.khepri.adventure.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.webkit.WebView;

import be.khepri.adventure.R;
import be.khepri.adventure.ui.GameWindowPagerAdapter;

public class HelpActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        ((WebView) findViewById(R.id.web_view)).loadUrl("file:///android_asset/html/Help.html");

    }
}
