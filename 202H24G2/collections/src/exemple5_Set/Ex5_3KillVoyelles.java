package exemple5_Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Retire les voyelles d'une phrase
 * - Set : TreeSet & HashSet
 * - opérateur : instanceof
 * - Méthodes : add(), removeAll()
 * - autre : String.replaceAll()
 */
public class Ex5_3KillVoyelles {
    public static String VOYELLES = "aàeéèêëiouùy";
    public static String PHRASE = "#34 23 mais ou et donc car ni or élève";

    private Set<Character> setVoyelles;
    private Set<Character> setLettresPhrase;

    public Ex5_3KillVoyelles(String phrase) {
        initSetsDesVoyelles();
        initSetsAvecLettresDeLaPhrase(phrase);
//
        System.out.println("la phrase : " + phrase);
        System.out.println("les voyelles : " + setVoyelles);
        System.out.println("lettres présentes : " + setLettresPhrase);
        effaceVoyelles();
        System.out.println("lettres sans les voyelles : " + setLettresPhrase);
    }

    private void effaceVoyelles() {
        //todo
    }

    private void initSetsAvecLettresDeLaPhrase(String phrase) {
//todo
    }

    private void initSetsDesVoyelles() {
        //dodo
    }

    public static void main(String args[]) {
        new Ex5_3KillVoyelles(PHRASE);
    }
}

/*
 Exécution :
 la phrase : mais ou et donc car ni or élève
 lettres présentes : [ , a, c, d, e, è, i, é, l, m, n, o, r, s, t, u, v]
 lettres sans les voyelles : [ , c, d, l, m, n, r, s, t, v]
 */
