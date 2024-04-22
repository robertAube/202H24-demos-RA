package exemple4_Set;

import java.util.Objects;

/**
 * @author Robert Aubé
 * @version 1.0
 */
public class Coordonnee implements Cloneable, Comparable<Coordonnee> {
    public static final int MIN_XY = -100000;
    public static final int MAX_XY = 100000;

    public static final int X_DEFAULT = 0;
    public static final int Y_DEFAULT = 0;

    private int x;
    private int y;
    private int hash;

    //constructeur par défaut
    public Coordonnee() {
        this(X_DEFAULT, Y_DEFAULT); //appelle le constructeur avec argument
    }

    public Coordonnee(int x, int y) {
        move(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (estValideX(x)) {
            this.x = x;
            setHash();
        } else {
            throw new IllegalArgumentException("X est invalide : " + x);
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (estValideY(y)) {
            this.y = y;
            setHash();
        } else {
            throw new IllegalArgumentException("Y est invalide : " + y);
        }
    }

    private void setHash() {
        hash = 31 * x + y;
    }

    public void translate(int dx, int dy) {
        setX(this.x + dx);
        setY(this.y + dy);
    }

    public void move(int x, int y) {
        setX(x);
        setY(y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static boolean estValideX(int x) {
        return MIN_XY <= x && x <= MAX_XY;
    }

    public static boolean estValideY(int y) {
        return MIN_XY <= y && y <= MAX_XY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordonnee that = (Coordonnee) o;

        return y == that.y && x == that.x;
    }

    @Override
    public int hashCode() {
//        int result = x;
//        result = 31 * result + y;
//        return result;
//        return Objects.hash(x, y);
//        return x + y;
        return hash;
    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y, hash);
//        return hash;
//        return x + y;
//        return x * 31 + y;
//    }

        @Override
    public int compareTo(Coordonnee coordonnee) {
        int compareX =  (x < coordonnee.x) ? -1 : ((x == coordonnee.x) ? 0 : 1);
        if (compareX != 0) {
            return compareX;
        }
        return (y < coordonnee.y) ? -1 : ((y == coordonnee.y) ? 0 : 1);
    }

    public Coordonnee cloner() throws CloneNotSupportedException {
        Coordonnee coordonnee = (Coordonnee) this.clone();
        return coordonnee;
    }


}

