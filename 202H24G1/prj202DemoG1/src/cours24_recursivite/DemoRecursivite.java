package cours24_recursivite;

import java.util.Arrays;

public class DemoRecursivite {
    public DemoRecursivite() {
//        tester_max1();
//        trouverValTest();
        tester_max2();
//        tester_decToBin();
//        tester_fibonacci();
        //tester_estMultipleDeCinq();
        //tester_getNbCarInStr();
    }

    private void tester_max1() {
        System.out.println(max1(new int[]{3, 1, 6, 2, 5}));
        System.out.println(max1(new int[]{9}));
        System.out.println(max1(new int[]{}));
    }

    private void tester_max2() {
        System.out.println(max2(new int[]{3, 1, 6, 2, 5}));
        System.out.println(max2(new int[]{9}));
        System.out.println(max2(new int[]{}));
    }

    public static int max2(int[] tab) {
        int max;
        int maxDesSuivants;
        int tabRestant[];

        max = tab[0];
        if (tab.length > 1) {
            tabRestant = Arrays.copyOfRange(tab, 1, tab.length);
            maxDesSuivants = max2(tabRestant);
//            max = max > maxDesSuivants ? max : maxDesSuivants;
            max= Math.max(max, maxDesSuivants);
        }

        return max;
    }


    public static int max1(int[] tab) {
        return max1(tab, 0, tab.length - 1);
    }

    private static int max1(int[] tab, int iDebut, int iFin) {
        int max;
        if (iDebut == iFin) {
            max = tab[iDebut];
        } else {
            if (tab[iDebut] < tab[iFin]) {
                max = max1(tab, iDebut + 1, iFin);
            } else {
                max = max1(tab, iDebut, iFin - 1);
            }
        }
        return max;
    }

    private void trouverValTest() {
        int tab[] = {1, 3, 4, 7, 8, 9, 10};
        int itrouve;

        System.out.println(Arrays.toString(tab));

        System.out.println(trouverVal(tab, 0) == -1);
        System.out.println(trouverVal(tab, 2) == -1);
        System.out.println(trouverVal(tab, 11) == -1);

        for (int i = 0; i < tab.length; i++) {
            itrouve = trouverVal(tab, tab[i]);
            System.out.println(tab[i] + " est trouvé à l'indice " + itrouve + '.');
        }

        System.out.println(trouverVal(tab, 7) == 3);
        System.out.println(trouverVal(tab, 4) == 2);
        System.out.println(trouverVal(tab, 1) == 0);
        System.out.println(trouverVal(tab, 10) == 6);
    }

    /**
     * Fonction récursive qui retournera l'indice où se trouve un <b>entier recherché</b>
     * dans un tableau de N entiers triés en ordre croissant.
     * Utilisez la recherche dichotomique.
     *
     * @param tab          le tableau de recherche
     * @param valRecherche l'entier à trouver
     * @return l'indice de l'entier trouvé ou -1 si pas trouvé.
     */
    public static int trouverVal(int[] tab, int valRecherche) {
        return trouverVal(tab, valRecherche, 0, tab.length - 1);
    }

    public static int trouverVal(int[] tab, int valRecherche, int iDebut, int iFin) {
        int iTrouve = -1;
        int iMilieu;

        if (iDebut <= iFin) { //si je ne suis pas à la fin de la recherche
            iMilieu = (iDebut + iFin) / 2;
            if (tab[iMilieu] == valRecherche) {
                iTrouve = iMilieu;
            } else if (valRecherche < tab[iMilieu]) {
                iTrouve = trouverVal(tab, valRecherche, iDebut, iMilieu - 1);
            } else {
                iTrouve = trouverVal(tab, valRecherche, iMilieu + 1, iFin);
            }
        }
        return iTrouve;
    }


    private void tester_decToBin() {
        System.out.println(decToBin(0).equals("0"));
        System.out.println(decToBin(1).equals("1"));
        System.out.println(decToBin(2).equals("10"));
        System.out.println(decToBin(3).equals("11"));
        System.out.println(decToBin(4).equals("100"));

        for (int i = 0; i < 24; i++) {
            System.out.println(i + "d = " + decToBin(i) + "b");
        }
    }

    public static String decToBin(int n) {
        String str;

        if (n == 0) {
            str = "0";
        } else if (n == 1) {
            str = "1";
        } else if (n % 2 == 0) { //si paire
            str = decToBin(n / 2) + '0';
        } else {
            str = decToBin((n - 1) / 2) + '1';
        }

        return str;
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


    ///////////////////////////////////////////
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
        boolean estMultiple = true;

        if (n == 0) {
            estMultiple = true;
        } else if (n > 0) {
            estMultiple = estMultipleDeCinq(n - 5);
        } else if (n > -5) {
            estMultiple = false;
        } else {
            estMultiple = estMultipleDeCinq(-n);
        }

        return estMultiple;
    }

    ////////////////////////////////////////////
    public void tester_getNbCarInStr() {
        // System.out.println(getNbCarInStr("abcd"));

        System.out.println(getNbCarInStr("abc") == 3);
        System.out.println(getNbCarInStr("") == 0);
        System.out.println(getNbCarInStr("abca", 'a') == 2);
        System.out.println(getNbCarInStr("abca", 'w') == 0);
        System.out.println(getNbCarInStr("", 'w') == 0);
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
