package cours24_recursivite;

public class DemoRecursivite {
    public DemoRecursivite() {
       // System.out.println(getNbCarInStr("abcd"));
       System.out.println(getNbCarInStr("abca", 'a'));
    }

    private int getNbCarInStr(String str) {
        int nbCar = 0;
        if (!str.equals("")) {
            nbCar = 1 + getNbCarInStr(str.substring(1));
        }
        return nbCar;
    }
    private int getNbCarInStr(String str, char car) {
        int nbCar = 0;
        if (!str.equals("")) {
            if (str.charAt(0) == car) {
                nbCar = 1 + getNbCarInStr(str.substring(1), car);
            } else {
                nbCar = 0 + getNbCarInStr(str.substring(1), car);
            }
        }
        return nbCar;
    }

    public static void main(String[] args) {
        new DemoRecursivite();
    }
}
