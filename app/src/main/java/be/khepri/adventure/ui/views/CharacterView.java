package be.khepri.adventure.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import be.khepri.adventure.game.behaviours.Transform;
import be.khepri.adventure.game.Vector2D;

public class CharacterView extends View
{
    static int bg = Color.DKGRAY;
    static int explored = Color.WHITE;

    Vector2D center = Vector2D.ZERO;
    Vector2D position;
    Vector2D screenVector;

    public CharacterView(Context context)
    {
        super(context);
    }

    public CharacterView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public CharacterView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    private void setGeometry()
    {
        screenVector = new Vector2D(getWidth()/2, getHeight()/2);
    }

    @Override
    public void onDraw(Canvas g)
    {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL);
        p.setColor(bg);
        setGeometry();
        g.drawRect(0,0,getWidth(), getHeight(), p);

        p.setColor(explored);

        int maxWidth = getWidth()/100;
        int maxHeight = getHeight()/100;
        for (int i = 0; i <= maxWidth; i++) {
            for (int j = 0; j <= maxHeight; j++) {
                drawTile(g, new Vector2D(i, j), p);
            }
        }

        if (position != null) {
            p.setColor(Color.RED);
            // need to flip the world coordinates for the map
            Vector2D pos = position.scale(new Vector2D(1, -1)).plus(center).multiply(100).plus(screenVector);
            g.drawCircle(pos.getX() ,pos.getY() , 15, p);
        }
    }

    private void drawTile(Canvas g, Vector2D position, Paint p)
    {
        Vector2D dataPosition = position.plus(center);
        Vector2D drawPosition = position.multiply(100).plus(screenVector);

        System.out.println("Draw: "+dataPosition);

        g.drawRect(drawPosition.getX() -48, drawPosition.getY() -48, drawPosition.getX() +48, drawPosition.getY()+48, p);

    }

    public boolean onMoved(Transform transform)
    {
        this.position = transform.getCoordinates();
        int width = getWidth() / 100;
        int height = getHeight() / 100;
        center = new Vector2D(
            (int) Math.floor((position.getX()+width/2)/(width)),
            (int) Math.floor((position.getY()+height/2)/(height))
        );
        center = center.scale(new Vector2D(width, height));
        System.out.println("Update position: "+position+" - Current Center: " + center);

        this.invalidate();
        return true;
    }
}
