package be.khepri.adventure.ui.views;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import be.khepri.adventure.R;
import be.khepri.adventure.engine.Room;

public class ConsoleView extends RelativeLayout implements TextView.OnEditorActionListener, View.OnLayoutChangeListener {


    public interface ConsoleInputListener {
        boolean onConsoleInput(ConsoleView console, String input);
    }

    private ScrollView scrollView;
    private LinearLayout scrollLayout;

    private List<ConsoleInputListener> inputListeners = new ArrayList<>();

    public ConsoleView(Context context) {
        super(context);
        init(context);
    }

    public ConsoleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ConsoleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ConsoleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        View rootView = inflate(context, R.layout.view_console, this);
        this.scrollView = rootView.findViewWithTag("console_scroll");
        this.scrollLayout = rootView.findViewWithTag("console_scroll_layout");
        ((EditText) rootView.findViewWithTag("console_input")).setOnEditorActionListener(this);
        this.scrollLayout.addOnLayoutChangeListener(this);


    }

    public void addLine(String response, int color)
    {
        TextView line = new TextView(getContext());
        line.setText(response);
        line.setTextColor(color);
        scrollLayout.addView(line);
    }

    public void addRoom(Room room) {
        scrollLayout.addView(new ConsoleRoomView(getContext(), room));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
    {
        String command = v.getText().toString();
        if (
            command.length() == 0   ||
            (event == null && actionId != EditorInfo.IME_ACTION_DONE) ||
            (event != null && event.getKeyCode() != KeyEvent.KEYCODE_ENTER)
        ) {
            return false;
        }

        addLine(" > " + command, Color.GREEN);

        inputListeners.forEach(consoleInputListener -> consoleInputListener.onConsoleInput(this, command));

        v.setText("");
        return true;
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        scrollView.scrollTo(0,  scrollLayout.getMeasuredHeight());
    }

    public void addInputListener(ConsoleInputListener listener) {
        inputListeners.add(listener);
    }
    public void removeInputListener(ConsoleInputListener listener) { inputListeners.remove(listener); }
}
