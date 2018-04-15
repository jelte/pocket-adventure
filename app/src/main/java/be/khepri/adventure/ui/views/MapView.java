package be.khepri.adventure.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

<<<<<<< HEAD
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.engine.World;
=======
import java.util.HashMap;
import java.util.List;

import be.khepri.adventure.engine.Character;
import be.khepri.adventure.game.Direction;
import be.khepri.adventure.game.GameObject;
import be.khepri.adventure.game.Vector2D;
import be.khepri.adventure.engine.World;
import be.khepri.adventure.game.behaviours.Room;
>>>>>>> Alpha 1.0
import be.khepri.adventure.game.behaviours.Transform;

public class MapView extends View
{
    static int bg = Color.DKGRAY;
    static int explored = Color.WHITE;

    Vector2D center = Vector2D.ZERO;
    Vector2D position = Vector2D.ZERO, screenCenter, screenSize, renderSize, offset;
<<<<<<< HEAD
=======
    HashMap<String, List<GameObject>> gameObjects = new HashMap<>();
>>>>>>> Alpha 1.0

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

<<<<<<< HEAD

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
=======
    private void drawTile(Canvas g, Vector2D position, Paint p)
    {
        Vector2D dataPosition = position.scale(new Vector2D(1, -1)).plus(center);
        Vector2D drawPosition = position.multiply(100).plus(screenCenter);
        be.khepri.adventure.engine.Room worldRoom = World.getInstance().getRoom(dataPosition);
        if (worldRoom != null && worldRoom.getGameObject() != null) {
            Room room = (Room) worldRoom.getGameObject().getBehaviour(Room.class.getName());
            p.setColor(explored);

            g.drawRect(
                    drawPosition.getX(),
                    drawPosition.getY(),
                    drawPosition.getX() + 100,
                    drawPosition.getY() + 100,
                    p
            );
            p.setColor(Color.BLUE);
            g.drawRect(
                    drawPosition.getX(),
                    drawPosition.getY(),
                    drawPosition.getX() + 100,
                    drawPosition.getY() + 10,
                    p
            );
            g.drawRect(
                    drawPosition.getX(),
                    drawPosition.getY()+90,
                    drawPosition.getX() + 100,
                    drawPosition.getY() + 100,
                    p
            );
            g.drawRect(
                    drawPosition.getX(),
                    drawPosition.getY() ,
                    drawPosition.getX() + 10,
                    drawPosition.getY() + 100,
                    p
            );
            g.drawRect(
                    drawPosition.getX() + 90,
                    drawPosition.getY(),
                    drawPosition.getX() + 100,
                    drawPosition.getY() + 100,
                    p
            );

            p.setColor(Color.YELLOW);
            if (room.hasConnection(Direction.NORTH)) {
                g.drawRect(
                        drawPosition.getX() + 40,
                        drawPosition.getY(),
                        drawPosition.getX() + 60,
                        drawPosition.getY() + 10,
                        p
                );
            }
            if (room.hasConnection(Direction.EAST)) {
                g.drawRect(
                    drawPosition.getX() + 90,
                    drawPosition.getY() + 40,
                    drawPosition.getX() + 100,
                    drawPosition.getY() + 60,
                    p
                );
            }
            if (room.hasConnection(Direction.SOUTH)) {
                g.drawRect(
                    drawPosition.getX() + 40,
                    drawPosition.getY() + 90,
                    drawPosition.getX() + 60,
                    drawPosition.getY() + 100,
                    p
                );
            }
            if (room.hasConnection(Direction.WEST)) {
                g.drawRect(
                    drawPosition.getX(),
                    drawPosition.getY() + 40,
                    drawPosition.getX() + 10,
                    drawPosition.getY() + 60,
                    p
                );
            }
        }
>>>>>>> Alpha 1.0

        if (dataPosition.equals(this.position)) {
            p.setColor(Color.RED);
            // need to flip the world coordinates for the map
            Vector2D pos = drawPosition.plus(new Vector2D(50, 50));
<<<<<<< HEAD
            g.drawCircle(pos.getX(), pos.getY() , 15, p);
        }
    }

    public boolean onWorldUpdate(World world, GameObject gameObject)
    {
        if (world.getPlayerObject().equals(gameObject)) {
            this.position = ((Transform) gameObject.getBehaviour(Transform.class.getName())).getCoordinates();
            this.invalidate();
=======
            g.drawCircle(pos.getX(), pos.getY(), 15, p);
        }
    }

    public boolean onWorldUpdate(World world, Character character)
    {
        if (character.getTransform() != null) {
            position = character.getTransform().getCoordinates();
            invalidate();
        }
        return true;
    }

    public boolean onWorldUpdate(World world, be.khepri.adventure.engine.Room gameObject)
    {
        if (gameObject.getTransform().getCoordinates().equals(position)) {
            invalidate();
>>>>>>> Alpha 1.0
        }
        return true;
    }
}
