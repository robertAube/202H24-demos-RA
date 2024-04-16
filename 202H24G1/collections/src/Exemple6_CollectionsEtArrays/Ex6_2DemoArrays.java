package Exemple6_CollectionsEtArrays;

import java.util.Arrays;

/**
 * Démonstration de la classe Arrays
 * Cette classe fournit des méthodes <b>static</b> pour la manipulation des tableaux statiques
 * Arrays.toString
 * Arrays.copyOf //copie profonde
 * Arrays.fill
 * Arrays.sort
 * Arrays.binarySearch
 */
public class Ex6_2DemoArrays {
    private int tabInt[] = {7, 2, 9, 3, 6, 3};
    private int tabRempli[];
    private int tabIntCopy[] ;


    public Ex6_2DemoArrays() {
        System.out.println("Copier tabInt : ");
        System.out.println("tabInt" + Arrays.toString(tabInt));
        tabIntCopy = Arrays.copyOf(tabInt, tabInt.length);
        System.out.println("tabIntCopy" + Arrays.toString(tabIntCopy));

        Arrays.sort(tabInt); //
        System.out.println("\nArrays.sort(tabInt) : " );
        System.out.println("tabInt" + Arrays.toString(tabInt));

        System.out.println("\nArrays.fill(tabRempli, 7) : ");
        tabRempli = new int[10];
        Arrays.fill(tabRempli, 7); // remplir avec la valeur 7
        System.out.println("tabRempli" + Arrays.toString(tabRempli));

        System.out.println("\nArrays.binarySearch(tabInt) : ");
        System.out.println("tabInt" + Arrays.toString(tabInt));
        System.out.println("tabIntCopy" + Arrays.toString(tabIntCopy));

        // Trouver la valeur dans le tableau valeursInt.
        // binarySearch retourne l'index de la clé de recherche, 
        // Si la valeur renvoyée par la recherche binaire est supérieure ou égale à zéro,
        //   cette valeur correspond à l'indice de l'élément trouvé
        for (int nbCherche = 1; nbCherche < 10; nbCherche++) {
            System.out.print("nb cherché " + nbCherche + " --> " );
            System.out.print("tabInt[" + Arrays.binarySearch(tabInt, nbCherche) + "] - ");
            System.out.println("tabIntCopy["+ Arrays.binarySearch(tabIntCopy, nbCherche) + ']');
        }

        //Vérifier l'égalité
        System.out.println("\nArrays.equals(tabInt, tabIntCopy) : ");
        System.out.println("tabInt" + Arrays.toString(tabInt));
        System.out.println("tabIntCopy" + Arrays.toString(tabIntCopy));
        System.out.print("\nArrays.equals(tabInt, tabIntCopy) = ");
        System.out.println(Arrays.equals(tabInt, tabIntCopy));
    }

    public static void main(String[] args) {
        new Ex6_2DemoArrays();
    }
}


