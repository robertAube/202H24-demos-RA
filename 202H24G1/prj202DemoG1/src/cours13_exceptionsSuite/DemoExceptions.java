package cours13_exceptionsSuite;

/*
420-202 – Traitement de données orienté objet
*/

/*
 * La hiérarchie partielle des Exceptions en Java:
 * Object
 * └── Throwable
 *     ├── Exception
 *     │   ├── RuntimeException (N'ont pas besoin d'être dans des blocs try/catch)
 *     │   │   ├── ArithmeticException
 *     │   │   ├── IllegalArgumentException
 *     │   │   │   └── NumberFormatException
 *     │   │   ├── NullPointerException
 *     │   │   └── IndexOutOfBoundsException
 *     │   │       └── ArrayIndexOutOfBoundsException
 *     │   └── IOException
 *     │       └── FileNotFoundException
 *     └── Error
 *
 * Seuls les exceptions héritant de la classe RuntimeException n'ont pas besoin d'être détectées impérativement par des blocs try/catch.
 * Pour une liste complète des exceptions, faire une recherche avec Google de "java 17 api Throwable" et naviguer dans TREE puis All Packages.
 */
public class DemoExceptions {
    public DemoExceptions() {
        //  tester_lancerUneException();
        try {
            tester_lancerPlusieursException();
        }  catch (Exception exception) {
            System.out.println("catch Exception du constructeur");
            System.out.println(exception.getMessage());
            System.out.println(exception.getClass().getSimpleName());
        }
    }

    private void tester_lancerPlusieursException() throws Exception {
        try {
            lancerUneException(new RuntimeException("C'est une RuntimeException"), false);
            lancerUneException(new IllegalArgumentException("C'est une IllegalArgumentException"), false);
            lancerUneException(new Exception("C'est une Exception"), true);
            System.out.println("Il n'y a pas eu d'exception");
        } catch (IllegalArgumentException exception) {  //Toujours mettre les classes d'exception plus spécifique en premier
            System.out.println("catch IllegalArgumentException");
            System.out.println(exception.getMessage());
            System.out.println(exception.getClass().getSimpleName());
        } catch (RuntimeException exception) {
            System.out.println("catch RuntimeException");
            System.out.println(exception.getMessage());
            System.out.println(exception.getClass().getSimpleName());
        }
        finally {
            System.out.println("Ce code est TOUJOURS exécutés!!!");
        }


        System.out.println("Fin de la méthode tester_lancerPlusieursException()");
    }

    private void tester_lancerUneException() {
        try {
            lancerUneException(new RuntimeException("C'est une RuntimeException"), true);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getClass().getSimpleName());
        }

        System.out.println("Fin de la méthode tester_lancerUneException()");
    }


    /**
     * Méthode bidon qui a pour job de mal aller et lancer une exception pour fin de démonstration
     *
     * @param exception
     * @param doisEtreLance Si c'est vrai l'exception reçue en argument est lancé.
     */
    private void lancerUneException(Exception exception, boolean doisEtreLance) throws Exception {
        if (doisEtreLance) {
            throw exception;
        }
    }

    public static void main(String[] args) {
        new DemoExceptions();
        System.out.println("Fin de la méthode main()");
    }
}
