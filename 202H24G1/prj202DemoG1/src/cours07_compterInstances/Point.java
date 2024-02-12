public class Point {
    private int x;
    private int y;

    private static int nbInstance = 0; //variable static (appartient à la classe (donc existe toujours))

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        nbInstance++; //comme il est seulement incrémenté, on ne compte pas les instances détruites
    }

    public int getX() {
        return x;
    }

    public static int getNbInstance() {
        return nbInstance;
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
