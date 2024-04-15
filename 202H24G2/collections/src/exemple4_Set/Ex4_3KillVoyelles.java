package exemple4_Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Retire les voyelles d'une phrase
 * - Set : TreeSet & HashSet
 * - Méthodes : add(), removeAll()
 * - autre : String.replaceAll()
 */
public class Ex4_3KillVoyelles {
    public static String VOYELLES = "aàeéèêëiouùy";
    public static String PHRASE = "mais ou et donc car ni or élève. /$%?&";

    private Set<Character> setVoyelles;
    private Set<Character> setLettresPhrase;

    public Ex4_3KillVoyelles(String phrase) {
        initSetsDesVoyelles();
        initSetsAvecLettresDeLaPhraseV1(phrase);
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

    private void initSetsAvecLettresDeLaPhraseV1(String phrase) {
        setLettresPhrase = new TreeSet<>();
        phrase = enleverCeQuiNEstPasUneLettre(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            setLettresPhrase.add(phrase.charAt(i));
        }
    }

    private void initSetsAvecLettresDeLaPhraseV2(String phrase) {
        char[] tableauDeLettres;
        setLettresPhrase = new TreeSet<>();

        phrase = enleverCeQuiNEstPasUneLettre(phrase);
        tableauDeLettres = phrase.toCharArray();
        for (char c: tableauDeLettres) {
            setLettresPhrase.add(c);
        }
    }

    //optionnel
    private String enleverCeQuiNEstPasUneLettre(String phrase) {
        phrase = phrase.replaceAll("[^a-zA-Zàâéèêëîïôûù]", "");
        return phrase;
    }

    private void initSetsDesVoyelles() {
        setVoyelles = new HashSet<>();
        for (int i = 0; i < VOYELLES.length(); i++) {
            setVoyelles.add(VOYELLES.charAt(i));
        }
    }

    public static void main(String args[]) {
        new Ex4_3KillVoyelles(PHRASE);
    }
}

/*
 Exécution :
 la phrase : mais ou et donc car ni or élève
 lettres présentes : [ , a, c, d, e, è, i, é, l, m, n, o, r, s, t, u, v]
 lettres sans les voyelles : [ , c, d, l, m, n, r, s, t, v]
 */
