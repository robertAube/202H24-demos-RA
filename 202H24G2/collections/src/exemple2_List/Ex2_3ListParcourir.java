package exemple2_List;

import java.util.*;

/**
 * Exemple 2.3 – Parcourir des listes avec fori, foreach et itérateur
 */
public class Ex2_3ListParcourir {
    private List<String>[] tabList = new List[]{new ArrayList<>(), new LinkedList<>(),  new Vector<>(), new Stack<>()};

    public Ex2_3ListParcourir() {
        for (List<String> list: tabList) {
            initialiser(list);
            System.out.println(list.getClass().getSimpleName() + list);

            nettoyerListeFori(list);
            System.out.println(list.getClass().getSimpleName() + list);

            initialiser(list);
            nettoyerListeForeach(list); //le moins bon
            System.out.println(list.getClass().getSimpleName() + list);

            initialiser(list);
            nettoyerListeIterator(list);
            System.out.println(list.getClass().getSimpleName() + list);
        }
    }
    private void nettoyerListeFori(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).trim());
        }
    }
    private void nettoyerListeForeach(List<String> list) {
        int index;
        for (String str : list) {
            //recherche séquentielle du str dans arrayList grace au equals de String
            //marche pour le 2e ottawa, le 1er ayant changé.
            index = list.indexOf(str);
            list.set(index, str.trim());
        }
    }
    private void nettoyerListeIterator(List<String> list) {
        ListIterator<String> listedIterator = list.listIterator();
        while (listedIterator.hasNext()) {
            listedIterator.set(listedIterator.next().trim()); //set nécessite le ListIterator
        }
    }
    private void initialiser(List<String> list) {
        list.clear();
        list.add("Paris ");
        list.add(" Londre");
        list.add(" Ottawa   ");
        list.add("New Delhi  ");
        list.add(" Ottawa   ");
    }

    public static void main(String args[]) {
        new Ex2_3ListParcourir();
    }
}
/** Exécution peu importe la liste choisie
 * ArrayList[Paris ,  Londre,  Ottawa   , New Delhi  ,  Ottawa   ]
 * ArrayList[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * ArrayList[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * ArrayList[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * LinkedList[Paris ,  Londre,  Ottawa   , New Delhi  ,  Ottawa   ]
 * LinkedList[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * LinkedList[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * LinkedList[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * Vector[Paris ,  Londre,  Ottawa   , New Delhi  ,  Ottawa   ]
 * Vector[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * Vector[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * Vector[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * Stack[Paris ,  Londre,  Ottawa   , New Delhi  ,  Ottawa   ]
 * Stack[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * Stack[Paris, Londre, Ottawa, New Delhi, Ottawa]
 * Stack[Paris, Londre, Ottawa, New Delhi, Ottawa]
 */

