package exemple1_iterator;

import java.util.*;

/**
 * - List : LinkedList, ArrayList, Vector
 * - méthodes d'un ListIterator :
 *   ++ hasNext(), next(), remove()
 *   ++ hasPrevious(), previous(), set(), add()
 * - autre : list.getClass().getSimpleName()
 */
public class Ex1_2ListIterator {
    private List<Integer>[] tabList = new List[]{new ArrayList<>(), new LinkedList<>(), new Vector<>()};

    List<Integer> list;
    ListIterator<Integer> listIterator; //L'itérateur ListIterator bidirectionnel

    public Ex1_2ListIterator() {
        for (List<Integer> l : tabList) {
            list = l;
            jouerAvecListe();
        }
    }

    private void jouerAvecListe() {
        peupler();
        System.out.println(this);
        supprime(100);
        System.out.println(this);
        System.out.println("Il y a " + nbEgale(20) + " valeur 20.");

        addAfter(20, 19);
        System.out.println(this);
        remplacer(30, 99);
        System.out.println(this);
        System.out.println(allerRetour() + "\n");
    }

    public void add(int i) {
        list.add(i);
    }

    public int nbEgale(int i) {
        int nb = 0;
        for (int element : list) {
            if (element == i)
                nb++;
        }
        return nb;
    }

    public void supprime(Integer elementInt) {
        listIterator = list.listIterator();

        System.out.println("Supprime : " + elementInt);
        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            if (i.equals(elementInt))
                listIterator.remove();
        }
    }
    ////// propre à l'ListIterator
    public void addAfter(Integer elementInt, Integer elementToAdd) {
        listIterator = list.listIterator();

        System.out.println("Ajoute après : " + elementInt + " la valeur " + elementToAdd);
        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            if (i.equals(elementInt))
                listIterator.add(elementToAdd);
        }
    }
    public String allerRetour() {
        StringBuilder strBuilder = new StringBuilder();
        listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            strBuilder.append(i + " ");
        }

        strBuilder.append("<-> ");
        while (listIterator.hasPrevious()) {
            Integer i = listIterator.previous();
            strBuilder.append(i + " ");
        }
        return strBuilder.toString();
    }
    public void remplacer(Integer oldValue, Integer newValue) {
        listIterator = list.listIterator();

        System.out.println("Remplacer " + oldValue + " par " + newValue);
        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            if (i.equals(oldValue))
                listIterator.set(newValue);
        }
    }
    private void peupler() {
        list.add(10);
        list.add(20);
        list.add(100);
        list.add(20);
        list.add(30);
    }

    @Override
    public String toString() {
        return list.getClass().getSimpleName() + list;
    }

    public static void main(String[] args) {
        new Ex1_2ListIterator();
    }

}
/* Exécution pour ArrayList
ArrayList[10, 20, 100, 20, 30]
Supprime : 100
ArrayList[10, 20, 20, 30]
Il y a 2 valeur 20.
Ajoute après : 20 la valeur 19
ArrayList[10, 20, 19, 20, 19, 30]
Remplacer 30 par 99
ArrayList[10, 20, 19, 20, 19, 99]
10 20 19 20 19 99 <-> 99 19 20 19 20 10
*/
