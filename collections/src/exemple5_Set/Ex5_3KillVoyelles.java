package exemple5_Set;

import java.util.HashSet;
import java.util.Set;

/**
 * - Set : TreeSet & HashSet
 * - opérateur : instanceof
 * - Méthodes : add(), removeAll()
 * - autre : String.replaceAll()
 */
public class Ex5_3KillVoyelles {
    Set<Character> lettres;
    Set<Character> voyelles;

    public Ex5_3KillVoyelles(String phrase) {
        initSets(phrase, "aàeéèêëiouùy");
    }

    public Set<Character> getLettres() {
        return lettres;
    }

    public void initSets(String phrase, String voy) {
        lettres = new HashSet<>();
        voyelles = new HashSet<>();
        for (int i = 0; i < phrase.length(); i++)
            lettres.add(phrase.charAt(i));

        for (int i = 0; i < voy.length(); i++)
            voyelles.add(voy.charAt(i));
    }

    public void effaceVoyelles() {
        lettres.removeAll(voyelles);
    }

    public static void main(String args[]) {
        String phrase = "mais ou et donc car ni or";
        phrase = phrase.replaceAll("[^a-zA-Zàâéèêëîïôûù]", ""); //retire tout ce qui n'est pas une lettre en français.

        Ex5_3KillVoyelles voyelle = new Ex5_3KillVoyelles(phrase);
        System.out.println("lettres présentes : " + voyelle.getLettres());
        voyelle.effaceVoyelles();
        System.out.println("lettres sans les voyelles : " + voyelle.getLettres());
    }
}

/** Exécution :
 * lettres présentes : [a, r, s, c, t, d, u, e, i, m, n, o]
 * lettres sans les voyelles : [r, s, c, t, d, m, n]
 */
