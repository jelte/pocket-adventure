package be.khepri.adventure.game;

public class Vector2D {
    public static final Vector2D ZERO = new Vector2D();
    public static final Vector2D UP = new Vector2D(0, 1);
    public static final Vector2D DOWN = new Vector2D(0, -1);
    public static final Vector2D LEFT = new Vector2D(-1, 0);
    public static final Vector2D RIGHT = new Vector2D(1, 0);

    private int x = 0, y = 0;

    public Vector2D() {}
    public Vector2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D plus(Vector2D other) { return new Vector2D(x + other.x, y + other.y); }
    public Vector2D minus(Vector2D other) { return this.plus(other.multiply(-1)); }
    public Vector2D multiply(int value) { return new Vector2D(x * value, y * value); }
    public Vector2D divide(int value) { return new Vector2D(x / value, y / value); }
    public Vector2D scale(Vector2D scale) { return new Vector2D(x * scale.x, y * scale.y); }
    public Vector2D floor(int value) { return new Vector2D(x/value*value, y/value*value); }
    public Vector2D floor(Vector2D value) { return new Vector2D(x/value.getX()*value.getX(), y/value.getY()*value.getY()); }
    public Vector2D round(Vector2D d) {
        return new Vector2D((int) Math.round((double) x/d.getX()), (int) Math.round((double) y/d.getY()));
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }

    @Override
    public String toString() {
        return "Vector("+x+","+y+")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2D)) {
            return false;
        }

        return super.equals(obj) || (x == ((Vector2D) obj).getX() && y == ((Vector2D) obj).getY());
    }

}
