package exemple5_Map;

import java.util.*;

/**
 * Exemple 4.1 Les maps
 * - méthodes sur Map : get(k), put(k, v)
 * - map foreach
 * - méthodes sur Entry : getKey(), getValue(), setValue()
 */
public class Ex5_2Map {
    private String[] tabContenu = {"À bon chat, bon rat.", "Appeler un chat un chat.", "La nuit, tous les chats sont gris."};
    private Map<String, Integer>[] tabMap = new Map[]{
            new TreeMap<>(), //ordonné par clé
            new HashMap<>(), //sans ordre
            new Hashtable<>() //sans ordre
    };
    private Map<String, Integer> map;

    public Ex5_2Map() {
        for (Map<String, Integer> m: tabMap) {
            map = m;
            renseignerMap();
            System.out.println(map.getClass().getSimpleName() + map);
            parcourirLesMaps();
        }
    }
    private void renseignerMap() {
        for (String phrase : tabContenu) {
            traiterPhrase(phrase);
        }
    }

    private void traiterPhrase(String phrase) {
        String[] tabMot;
        Integer value;

        phrase = nettoyerPhrase(phrase);
        tabMot = phrase.split("\s+"); //séparateur du split: espace(\s) de 1 à n fois(+)

        for (String mot : tabMot) {
            value = map.get(mot); //Récupérer la valeur du mot. Retourne null si le mot n'Existe pas.
            if (value == null) //ne contient pas la clé
            { //L'entrée <k, v> est ajouté.
                map.put(mot, 1); //comme la clé (ou le mot) n'existe pas, le put ajoute
            } else { //Contient la clé. La valeur est remplacée. Jamais de doublon de clé.
                map.put(mot, value + 1); //comme la clé (ou le mot) existe, le put remplace
            }
        }
    }

    /**
     * Transformer la phrase ne liste de mots
     * @param phrase
     * @return
     */
    private String nettoyerPhrase(String phrase) {
        String strPhraseRetour;
        strPhraseRetour = phrase.replace(',', ' ');
        strPhraseRetour = strPhraseRetour.replace('\'', ' ');
        strPhraseRetour = strPhraseRetour.toLowerCase(Locale.CANADA_FRENCH);
        strPhraseRetour = strPhraseRetour.replaceAll("[^a-zàâéèêëîïôûù ]", "");

        return strPhraseRetour.trim();
    }
    private void parcourirLesMaps() {
        parcourirMap_foreach();
        parcourirMap_entrySetIterator();
        parcourirMap_foreach_entrySet();
        parcourirMap_foreach_keySet();
    }

    private void parcourirMap_foreach() {
        System.out.println("parcourirMap_foreach()");
        map.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
    private void parcourirMap_entrySetIterator() {
        System.out.println("parcourirMap_entrySetIterator()");
        Iterator entryIterator = map.entrySet().iterator(); //récupère le set des clés de le Map puis retourne un itérateur sur le set
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) entryIterator.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private void parcourirMap_foreach_entrySet() {
        System.out.println("parcourirMap_foreach_entrySet()");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {  //map.entrySet(), retourne un ensemble d'entrée dont la clé est associée à une valeur.
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    private void parcourirMap_foreach_keySet() {
        System.out.println("parcourirMap_foreach_keySet()");
        for (String key : map.keySet()) { // map.keySet() retourne un Set des clés
            System.out.println(key + " -> " + map.get(key));
        }
    }
    public static void main(String[] args) {
        new Ex5_2Map();
    }
}
/**
 * Exécution partielle:
 * TreeMap{appeler=1, bon=2, chat=3, chats=1, gris=1, la=1, les=1, nuit=1, rat=1, sont=1, tous=1, un=2, à=1}
 * HashMap{à=1, bon=2, appeler=1, nuit=1, rat=1, gris=1, tous=1, la=1, chat=3, sont=1, chats=1, un=2, les=1}
 * Hashtable{tous=1, nuit=1, la=1, à=1, appeler=1, les=1, gris=1, un=2, sont=1, bon=2, chats=1, rat=1, chat=3}
 */
