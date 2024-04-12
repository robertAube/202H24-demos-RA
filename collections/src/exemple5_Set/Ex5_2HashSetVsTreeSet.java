package exemple5_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * - Set : TreeSet & HashSet
 * - opérateur : instanceof
 * - Méthodes : add()
 */
public class Ex5_2HashSetVsTreeSet {
    Liquide [] tabLiquide = {
            new Liquide("huile de sésame", 920),
            new Liquide("huile d'olive", 920),
            new Liquide("eau", 999),
            new Liquide("eau", 1000),
            new Liquide("mercure", 13600),
            new Liquide("mercure", 13600),
    };
    public Ex5_2HashSetVsTreeSet() {
        System.out.println("HashSet : ");
        testSet(new HashSet<>(Arrays.asList(tabLiquide)));
        System.out.println("\nTreeSet : ");
        testSet(new TreeSet<>(Arrays.asList(tabLiquide)));
    }

    public void testSet(Set<Liquide> set) {
        // TreeSet n'autorise pas l'ajout d'une valeur null
        if (!(set instanceof TreeSet)) //L'opérateur java instanceof teste si l'objet est une instance du type spécifié (classe ou sous-classe ou interface).
            set.add(null); //Ajoute seulement s'il n'existe pas, sinon retourne false

        // Ne fait rien : ajoute seulement s'il n'existe pas, sinon retourne false
        set.add(new Liquide("eau", 1000));

        // Afficher les éléments du set
        for (Liquide liquide : set) {
            System.out.println(liquide);
        }
    }

    public static void main(String[] args) {
        new Ex5_2HashSetVsTreeSet();
    }
}
/**
 * Si Liquide a un equal(), hashSet() et compareTo() sur nom:
 * HashSet :
 * null
 * huile de sésame - {masseVolumique= 920 Kg/M3, hashCode= 1782076880 (0x6A3855D0) }
 * eau - {masseVolumique= 999 Kg/M3, hashCode= 100185 (0x00018759) }
 * huile d'olive - {masseVolumique= 920 Kg/M3, hashCode= -131812915 (0xF824B1CD) }
 * mercure - {masseVolumique= 13600 Kg/M3, hashCode= 953544447 (0x38D5EEFF) }
 *
 * TreeSet :
 * eau - {masseVolumique= 999 Kg/M3, hashCode= 100185 (0x00018759) }
 * huile d'olive - {masseVolumique= 920 Kg/M3, hashCode= -131812915 (0xF824B1CD) }
 * huile de sésame - {masseVolumique= 920 Kg/M3, hashCode= 1782076880 (0x6A3855D0) }
 * mercure - {masseVolumique= 13600 Kg/M3, hashCode= 953544447 (0x38D5EEFF) }
 */

/**
 * Si Liquide a un equal(), hashSet() et compareTo() sur nom et masseVolumique:
 * HashSet :
 * eau - {masseVolumique= 1000 Kg/M3, hashCode= 3106735 (0x002F67AF) }
 * null
 * eau - {masseVolumique= 999 Kg/M3, hashCode= 3106734 (0x002F67AE) }
 * mercure - {masseVolumique= 13600 Kg/M3, hashCode= -504879615 (0xE1E82601) }
 * huile de sésame - {masseVolumique= 920 Kg/M3, hashCode= -590190648 (0xDCD267C8) }
 * huile d'olive - {masseVolumique= 920 Kg/M3, hashCode= 208767851 (0x0C718B6B) }
 *
 * TreeSet :
 * eau - {masseVolumique= 999 Kg/M3, hashCode= 3106734 (0x002F67AE) }
 * huile d'olive - {masseVolumique= 920 Kg/M3, hashCode= 208767851 (0x0C718B6B) }
 * huile de sésame - {masseVolumique= 920 Kg/M3, hashCode= -590190648 (0xDCD267C8) }
 * mercure - {masseVolumique= 13600 Kg/M3, hashCode= -504879615 (0xE1E82601) }
 */