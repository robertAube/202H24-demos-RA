package cours15_StringBuilder;

import java.util.Date;

public class DemoStringBuilder {
    public static int NB_CONCATENATION = 2;
    public static String MOT = "Zut";

    public DemoStringBuilder() {
        long start, end;
        String str;

        JouerAvecStringSimple();

        start = new Date().getTime();
        str = concatenerString_String();
        end = new Date().getTime();
        System.out.println(str.substring(0, 100) + "\n" + (end - start) + " millisecondes");

        start = new Date().getTime();
        str = concatenerString_StringBuilder();
        end = new Date().getTime();
        System.out.println(str.substring(0, 100) + "\n" + (end - start) + " millisecondes");
    }

    private String concatenerString_String() {
        String str = "";
        for (int i = 0; i < NB_CONCATENATION; i++) {
            str += MOT;
        }
        return (str);
    }

    private String concatenerString_StringBuilder() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < NB_CONCATENATION; i++) {
            str.append(MOT);
        }
        return str.toString();
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
