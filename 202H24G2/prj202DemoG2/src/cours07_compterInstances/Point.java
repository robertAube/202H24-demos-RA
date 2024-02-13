package cours07_compterInstances;

public class Point {
    private int x;
    private int y;

    private static int nbInstanceCree = 0;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        nbInstanceCree++;
    }

    public static int getNbInstanceCree() {
        return nbInstanceCree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
