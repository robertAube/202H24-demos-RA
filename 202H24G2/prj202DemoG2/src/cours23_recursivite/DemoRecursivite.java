package cours23_recursivite;

public class DemoRecursivite {
    public DemoRecursivite() {
        tester_getNbCarInStr();
    }

    public void tester_estMultipleDeCinq() {
        System.out.println(estMultipleDeCinq(0) == true);
        System.out.println(estMultipleDeCinq(5) == true);
        System.out.println(estMultipleDeCinq(4) == false);
        System.out.println(estMultipleDeCinq(2) == false);
        System.out.println(estMultipleDeCinq(11) == false);
        System.out.println(estMultipleDeCinq(125) == true);

        System.out.println(estMultipleDeCinq(-2) == false);
        System.out.println(estMultipleDeCinq(-5) == true);
        System.out.println(estMultipleDeCinq(-7) == false);
        System.out.println(estMultipleDeCinq(-12) == false);
        System.out.println(estMultipleDeCinq(-15) == true);
        System.out.println(estMultipleDeCinq(-10) == true);
    }

    /**
     * Par récursion, cette méthode retourne true si le nombre reçu en argument est un multiple de 5.
     * Et false si ce n'est pas un multiple de 5.
     *
     * @param n
     * @return true si le nombre reçu en argument est un multiple de 5. Sinon false.
     */
    public static boolean estMultipleDeCinq(int n) {
        boolean estMultiple = true;

        return estMultiple;
    }

    ////////////////////////////////////////////
    public void tester_getNbCarInStr() {
        System.out.println(getNbCarInStr("abc") == 3);
        System.out.println(getNbCarInStr("") == 0);
        System.out.println(getNbCarInStr("abca", 'a') == 2);
        System.out.println(getNbCarInStr("abca", 'w') == 0);
        System.out.println(getNbCarInStr("", 'w') == 0);
    }
    /**
     * Par récursion, cette méthode retourne vrai si le nombre reçu en argument est un multiple de 5.
     * Et faux si ce n'est pas un multiple de 5.
     *
     * @param n un nombre
     * @return
     */


    ///////////////////////////////////////////////
    private int getNbCarInStr(String str, char car) {
        int nbCar = 0;

        if (!str.equals("")) {
            if (str.charAt(0) == car) {
                nbCar = 1 + getNbCarInStr(str.substring(1), car);
            } else {
                nbCar = getNbCarInStr(str.substring(1), car);
            }
        }

        return nbCar;
    }

    private int getNbCarInStr(String str) {
        int nbCar = 0;

        if (!str.equals("")) {
            nbCar = 1 + getNbCarInStr(str.substring(1));
        }

        return nbCar;
    }

    public static void main(String[] args) {
        new DemoRecursivite();
    }
}
