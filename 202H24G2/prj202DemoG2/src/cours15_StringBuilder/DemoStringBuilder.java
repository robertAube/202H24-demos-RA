package cours15_StringBuilder;

import java.util.Date;

public class DemoStringBuilder {
    public static int NB_CONCATENATION = 50000;
    public static int NB_CAR_A_AFFICHER = 80;
    public static String MOT = "Bla ";

    public DemoStringBuilder() {
        long start, end;
        String str;

        JouerAvecStringSimple();

        start = new Date().getTime(); //Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
        str = concatenerString_String();
        end = new Date().getTime();

        str = str.substring(0, str.length() < NB_CAR_A_AFFICHER  ? str.length() : NB_CAR_A_AFFICHER);
        System.out.println(str + "\n" + (end - start) + " millisecondes");

        start = new Date().getTime(); //Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
        str = concatenerString_StringBulider();
        end = new Date().getTime();

        str = str.substring(0, Math.min(str.length(), NB_CAR_A_AFFICHER));
        System.out.println(str + "\n" + (end - start) + " millisecondes");
    }

    private String concatenerString_String() {
        String str = "";
        for (int i = 0; i < NB_CONCATENATION; i++) {
            str += MOT; //instanciation d'une nouvelle String à chaque fois
        }
        return (str);
    }

    private String concatenerString_StringBulider() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < NB_CONCATENATION; i++) {
            str.append(MOT); //instanciation d'une nouvelle String à chaque fois
        }
        return (str.toString());
    }


    private void JouerAvecStringSimple() {
        String s1 = "Hello";
        String s2 = "World";

        s1 += " " + s2; // concaténation de deux chaînes de caractères

        System.out.println(s1); // affiche "Hello World"
    }


    public static void main(String[] args) {
        new DemoStringBuilder();
    }
}
