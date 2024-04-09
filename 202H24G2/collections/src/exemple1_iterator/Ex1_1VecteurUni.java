package exemple1_iterator;

import java.util.*;

/**
 * - List :  LinkedList, ArrayList, Vector
 * - méthodes d'un Iterator : hasNext(), next(), remove()
 * - autre : list.getClass().getSimpleName()
 */
public class Ex1_1VecteurUni {
    private List<Integer>[] tabList = new List[]{new ArrayList<>(), new LinkedList<>(), new Vector<>()};

    List<Integer> list;

    public Ex1_1VecteurUni() {
        for (List<Integer> l : tabList) {
            list = l;
            peupler();
            System.out.println(this);
            supprimer(100);
            System.out.println(this);
            System.out.println("Il y a " + getNbEgale(20) + " valeur 20.\n");
        }
    }

    public void add(int i) {
        list.add(i);
    }

    public void supprimer(Integer elementInt) {
        Iterator<Integer> iterateur = list.iterator(); //récupérer un itérateur de la list.

        System.out.println("Supprimer : " + elementInt);
        while (iterateur.hasNext()) { //faux en partant si liste est vide
            Integer i = iterateur.next(); //récupérer l'élément
            if (i.equals(elementInt))
                iterateur.remove();
        }
    }

    public int getNbEgale(int i) {
        int nb = 0;
        for (Integer element : list) {
            if (element.equals(i))
                nb++;
        }
        return nb;
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

    //todo Exercice : Développez un toString avec iterateur


    public static void main(String[] args) {
        Ex1_1VecteurUni vecteur = new Ex1_1VecteurUni();

    }

}
/* exécution
ArrayList[10, 20, 100, 20, 30]
Supprimer : 100
ArrayList[10, 20, 20, 30]
Il y a 2 valeur 20.

LinkedList[10, 20, 100, 20, 30]
Supprimer : 100
LinkedList[10, 20, 20, 30]
Il y a 2 valeur 20.

Vector[10, 20, 100, 20, 30]
Supprimer : 100
Vector[10, 20, 20, 30]
Il y a 2 valeur 20.
*/
