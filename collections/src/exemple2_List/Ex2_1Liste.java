package exemple2_List;

import java.util.*;

/**
 * Exemple 2.1 - Construire une liste à partir d’une autre liste
 * - Arrays.asList()
 */
public class Ex2_1Liste {
    List<Integer> arrayList;
    List<Integer> linkedList;
    Integer[] tabInt = {4, 3, 6, 9, 0, 1, -2}; //notez qu'ils sont emmagasinés en objets Integer

    public Ex2_1Liste() {
        arrayList = new ArrayList<>(Arrays.asList(tabInt));
        linkedList = new LinkedList<>();

        System.out.println(this);

        linkedList.add(33); //sera évidement perdu...
        System.out.println(this);

        //initialiser une collection avec une autre
        linkedList = new LinkedList<>(arrayList);

        System.out.println(this);
    }

    @Override
    public String toString() {
        return "{" +
                "\n  arrayList=" + arrayList +
                "\n  linkedList=" + linkedList +
                "\n}";
    }

    public static void main(String[] args) {
        new Ex2_1Liste();
    }
}
/**
 * Exécution :
 * {
 *   arrayList=[4, 3, 6, 9, 0, 1, -2]
 *   linkedList=[]
 * }
 * {
 *   arrayList=[4, 3, 6, 9, 0, 1, -2]
 *   linkedList=[4, 3, 6, 9, 0, 1, -2]
 * }
 */