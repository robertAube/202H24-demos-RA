package exemple2_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Exemple 2.4 – Utiliser des méthodes spécifiques à LinkedList
 * - méthodes : getFirst(), getLast(), removeFirst(), removeLast(), addFirst()
 */
public class Ex2_4LinkedList {
    List<Integer> linkedList;
    List<Integer> arrayList;

    public Ex2_4LinkedList() {
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        testListe();
        System.out.println(this); //arrayList demeure intacte puisque la structure continue de référer aux éléments.
    }
    public void testListe() {
        peupler(linkedList, 0);
        peupler(arrayList, 2);
        System.out.println(this);

        linkedList = new LinkedList<>(arrayList);
        System.out.println("On a pris les éléments de l'ArrayList et on a fait une LinkedList : " + linkedList);

        //on doit caster liste pour avoir les services spécifique à la LinkedList
        LinkedList linkedList = (LinkedList) this.linkedList;

        System.out.println("On a getFirst() dans la LinkedList : " + linkedList.getFirst());
        System.out.println("On a getLast() dans la LinkedList : " + linkedList.getLast());

        linkedList.removeLast();
        System.out.println("On a removeLast() dans la LinkedList : " + linkedList);

        linkedList.removeFirst();
        System.out.println("On a removeFirst() dans la LinkedList : " + linkedList);

        linkedList.addFirst(5);
        System.out.println("On a addFirst(5) dans la LinkedList : " + this.linkedList);

        linkedList.clear();
        System.out.println("On a clear() la LinkedList : " + this.linkedList);
    }
    private void peupler(List<Integer> vecteur, int valueToAdd) {
        vecteur.add(10 + valueToAdd);
        vecteur.add(20 + valueToAdd);
        vecteur.add(30 + valueToAdd);
    }
    @Override
    public String toString() {
        return "linkedList=" + linkedList + ", arrayList=" + arrayList;
    }

    public static void main(String[] args) {
        new Ex2_4LinkedList();
    }
}
/** exécution :
 linkedList=[10, 20, 30], arrayList=[12, 22, 32]
 On a pris les éléments de l'ArrayList et on a fait une LinkedList : [12, 22, 32]
 On a getFirst() dans la LinkedList : 12
 On a getLast() dans la LinkedList : 32
 On a removeLast() dans la LinkedList : [12, 22]
 On a removeFirst() dans la LinkedList : [22]
 On a addFirst(5) dans la LinkedList : [5, 22]
 On a clear() la LinkedList : []
 linkedList=[], arrayList=[12, 22, 32]
 */

