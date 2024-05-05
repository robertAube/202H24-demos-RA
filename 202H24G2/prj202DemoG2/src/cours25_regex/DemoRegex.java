package cours25_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegex {
    private String[][] tabTests = {
            {"es", "Les carottes sont cuites"}, //true - false
            {"c.", "abc"}, //false - false
            {"..c", "abc"}, //true - true
            {"...c", "abbc"}, //true - true
            {"\\d", "2"}, //true - true
            {"\\d", "332"}, //true - false
            {"\\d", "123abc"}, //true - false
            {"\\D*", "geek"}, //true - true
    };

    public DemoRegex() {
//        regex1_correspondExactement();
//        regex2_estDansUneChaine();
 //       regex3_trouverLesMatchs();
        regex4_remplacerLesMatchs();
    }

    /**
     * 4 moyens de voir si un patron correspond exactement à une chaine
     */
    private void regex1_correspondExactement() {
        System.out.println("regex1_correspondExactement()");

        boolean estDans;
        String strResultat;
        String strRegex;
        String str;

        for (String[] test : tabTests) {
            strRegex = test[0];
            str = test[1];

            strResultat = "Le patron \"" + strRegex + "\" correspond exactement à \"" + str + "\" = ";

            estDans = correspondExactement_PatternCompile(strRegex, str);
            System.out.println(strResultat + estDans);

            estDans = Pattern.matches(strRegex, str);
            System.out.println(strResultat + estDans);

            estDans = str.matches(strRegex);
            System.out.println(strResultat + estDans);

            estDans = estDansUneChaine_PatternCompile('^' + strRegex + '$', str);
            System.out.println(strResultat + estDans);
        }
    }

    private boolean correspondExactement_PatternCompile(String regex, String str) {
        Pattern pattern;
        Matcher matcher;

        //compilation de la regex avec le motif (patron ou pattern) : regex
        pattern = Pattern.compile(regex);
        //créer et associer le moteur à la regex sur la chaîne str
        matcher = pattern.matcher(str);

        //vrai si, et seulement si, la chaîne correspond exactement et en entier au patron
        return matcher.matches();
    }

    /**
     * Voir si un patron est dans une chaine
     */
    private void regex2_estDansUneChaine() {
        System.out.println("\nregex2_estDansUneChaine()");

        boolean estDans;
        String strResultat;
        String strRegex;
        String str;

        for (String[] test : tabTests) {
            strRegex = test[0];
            str = test[1];

            strResultat = "Le patron \"" + strRegex + "\" a été trouvé dans \"" + str + "\" = ";

            estDans = estDansUneChaine_PatternCompile(strRegex, str);
            System.out.println(strResultat + estDans);
        }
    }

    private boolean estDansUneChaine_PatternCompile(String regex, String str) {
        Pattern pattern;
        Matcher matcher;

        //compilation de la regex avec le motif (patron ou pattern) : regex
        pattern = Pattern.compile(regex);
        //créer et associer le moteur à la regex sur la chaîne str
        matcher = pattern.matcher(str);

        //true si le motif est trouvé
        return matcher.find();
    }

    /**
     * Identifier les correspondences
     */
    private void regex3_trouverLesMatchs() {
        System.out.println("\nregex3_trouverLesMatchs()");

        String regex = "\\d{4}"; //exactement 4 chiffres (\d: un chiffre) ({2,}: 2 ou plus)
        String str = "Les 3 bonnes années sont 1967, 2001 et 2020, mais surtout 1967.";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        for (int no = 1; matcher.find(); no++) { //matcher.find() - true si le motif est trouvé - et avance l'index de recherche
            System.out.println("Correspondance numéro " + no + ": " + matcher.group()); //permet de récupérer le courant dans le groupe de match
        }
    }

    /**
     * 2 façons de remplacer les correspondances
     */
    private void regex4_remplacerLesMatchs() {
        System.out.println("\nregex4_remplacerLesMatchs()");

        String regex = "\\b19"; // \b: début ou fin de mot
        String strOut;
        String str = "1918 oui... mais les 3 bonnes années sont 1968, 2019 et 2020.";

        System.out.println(str);

        strOut = str.replaceAll(regex, "20"); //Méthode de la classe String
        System.out.println(strOut);
        //ou
        strOut = Pattern.compile(regex).matcher(str).replaceAll("20");
        System.out.println(strOut);
    }

    public static void main(String[] args) {
        new DemoRegex();
    }
}
