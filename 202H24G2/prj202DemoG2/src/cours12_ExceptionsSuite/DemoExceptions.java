package cours12_ExceptionsSuite;

/*
420-202 – TP2 – Traitement de données orienté objet
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
    public DemoExceptions() throws Exception {
//        tester_lancerUneException();
        demoExceptionsPlusieursCatchs();
    }

    private void demoExceptionsPlusieursCatchs() throws Exception {
        try {
            lancerUneException(new NumberFormatException("Je suis une NumberFormatException"), false);
            lancerUneException(new IllegalArgumentException("Je suis une IllegalArgumentException"), false);
            System.out.println("Après tous les exceptions");
            throw new Exception("Ca marche jamais");
        } catch (NumberFormatException e) { //Toujours mettre les classes d'exception plus spécifique en premier
            System.out.println("catch #1 : NumberFormatException");
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
        } catch (IllegalArgumentException e) { //Toujours mettre les classes d'exception plus spécifique en premier
            System.out.println("catch #2 : IllegalArgumentException");
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
        } catch (RuntimeException e) { //Toujours mettre les classes d'exception plus générale à la fin
            System.out.println("catch #3 : Exception");
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
        } finally { //dans vraiment tous les cas, ce code est exécutés
            System.out.println("Ce code est toujours exécutés!!!");
        }
        System.out.println("Fin de la méthode demoExceptionsPlusieursCatchs()");
    }

    /**
     * Méthode bidon qui a pour job de mal aller et lancer une exception pour fin de démonstration
     *
     * @param exception
     * @throws Exception
     */

    private void lancerUneException(RuntimeException exception, boolean doisEtreLance) throws RuntimeException {
        if (doisEtreLance) {
            throw exception;
        }
    }

    private void tester_lancerUneException() {
        try {
            lancerUneException(new RuntimeException("RuntimeException"), true);
            System.out.println("Après appel lancerUneException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
        }

    }


    public static void main(String[] args) {
        try {
            new DemoExceptions();
        }
        catch (Exception e) {
            System.out.println("Catch dans le main");
        }
        System.out.println("Fin main()");
    }
}
