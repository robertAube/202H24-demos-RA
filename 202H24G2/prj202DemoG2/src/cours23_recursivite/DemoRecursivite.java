package cours23_recursivite;

public class DemoRecursivite {
    public DemoRecursivite() {
        tester_fibonacci();
        //tester_estMultipleDeCinq();
        //tester_getNbCarInStr();
    }

    private void tester_decToBin() {
        System.out.println(decToBin(0).equals("0"));
        System.out.println(decToBin(1).equals("1"));
        System.out.println(decToBin(2).equals("10"));
        System.out.println(decToBin(3).equals("11"));
        System.out.println(decToBin(4).equals("100"));
    }

    /**
     * Fibonacci
     * 1. La suite des nombres de Fibonacci est la suivante 0, 1, 1, 2, 3, 5, 8, 13, 21, etc.
     * Un nombre de Fibonacci se définit de la façon suivante :
     * <p>
     * F(0) = 0, F(1) = 1, F(N) = F(N-2) + F(N-1)
     * <p>
     * Écrivez un algorithme et une méthode récursive qui calcule la somme des N
     * premiers nombres de la suite de Fibonacci F(N). Exemple: F(6) donne 12.
     * https://www.nationalgeographic.fr/sciences/mathematiques-la-fascinante-suite-de-fibonacci-et-le-nombre-dor
     *
     * @param n , la valeur a traiter
     * @return int, l'entier à mettre dans la liste
     */

    private void tester_fibonacci() {
        System.out.println(fibonacci(0) == 0);
        System.out.println(fibonacci(1) == 1);
        System.out.println(fibonacci(2) == 1);
        System.out.println(fibonacci(3) == 2);
        System.out.println(fibonacci(4) == 3);
        System.out.println(fibonacci(14) == 377);
    }

    private int fibonacci(int n) {
        int fibo = n;
        if (n >= 2) {
            fibo = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return fibo;
    }


    public void tester_estMultipleDeCinq() {
        //étape 1
        System.out.println(estMultipleDeCinq(0) == true);
        System.out.println(estMultipleDeCinq(5) == true);
        System.out.println(estMultipleDeCinq(4) == false);
        System.out.println(estMultipleDeCinq(2) == false);
        System.out.println(estMultipleDeCinq(11) == false);
        System.out.println(estMultipleDeCinq(125) == true);

        //étape 2
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
        boolean estMultiple;

        if (n == 0) {
            estMultiple = true;
        } else if (n > 0) {
            estMultiple = estMultipleDeCinq(n - 5);
        } else if (n <= -5) {
            estMultiple = estMultipleDeCinq(-n);
        } else {
            estMultiple = false;
        }

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
