package be.khepri.adventure.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.game.behaviours.Transform;

public class MapView extends View
{
    static int bg = Color.DKGRAY;
    static int explored = Color.WHITE;

    Vector2D center = Vector2D.ZERO;
    Vector2D position = Vector2D.ZERO, screenCenter, screenSize, renderSize, offset;

    public MapView(Context context)
    {
        super(context);
    }

    public MapView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MapView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    private void setGeometry()
    {
        screenSize = new Vector2D(getWidth(), getHeight());
        screenCenter = screenSize.divide(2);
        renderSize = screenSize.floor(100);
        offset = screenSize.minus(renderSize).divide(2);

        Vector2D d = renderSize.divide(100);
        center = position.plus(Vector2D.DOWN).round(d).scale(d);
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

        int maxWidth = getWidth()/100;
        int maxHeight = getHeight()/100;
        for (int i = maxWidth/-2; i < maxWidth/2; i++) {
            for (int j = maxHeight/-2; j < maxHeight/2; j++) {
                drawTile(g, new Vector2D(i, j), p);
            }
        }
    }


    private void drawTile(Canvas g, Vector2D position, Paint p)
    {
        p.setColor(explored);
        Vector2D dataPosition = position.scale(new Vector2D(1, -1)).plus(center);
        Vector2D drawPosition = position.multiply(100).plus(screenCenter);

        g.drawRect(
            drawPosition.getX(),
            drawPosition.getY(),
            drawPosition.getX() + 100,
            drawPosition.getY() + 100,
            p
        );

        if (dataPosition.equals(this.position)) {
            p.setColor(Color.RED);
            // need to flip the world coordinates for the map
            Vector2D pos = drawPosition.plus(new Vector2D(50, 50));
            g.drawCircle(pos.getX(), pos.getY() , 15, p);
        }
    }

    public boolean onWorldUpdate(World world, GameObject gameObject)
    {
        if (world.getPlayerObject().equals(gameObject)) {
            this.position = ((Transform) gameObject.getBehaviour(Transform.class.getName())).getCoordinates();
            this.invalidate();
        }
        return true;
    }
}
