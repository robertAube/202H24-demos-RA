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
        setLettresPhrase.removeAll(setVoyelles);
    }

    private void initSetsAvecLettresDeLaPhrase(String phrase) {
        setLettresPhrase = new HashSet<>();
        phrase = enleverCeQuiNEstPasUneLettre(phrase);
        System.out.println(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            setLettresPhrase.add(phrase.charAt(i));
        }
    }

    private void initSetsAvecLettresDeLaPhraseV2(String phrase) {
    String texte = "abc";
    char[] tableauDeLettres = texte.toCharArray();

    Set<Character> ensembleDeLettres = new HashSet<>();
    for (char lettre : tableauDeLettres) {
        ensembleDeLettres.add(lettre);
    }
}

    private String enleverCeQuiNEstPasUneLettre(String phrase) {
        return phrase.replaceAll("[^a-zA-Zàâéèêëîïôûù]", "");
    }

    private void initSetsDesVoyelles() {
        setVoyelles = new TreeSet<>();
        for (int i = 0; i < VOYELLES.length(); i++) {
            setVoyelles.add(VOYELLES.charAt(i));
        }
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
