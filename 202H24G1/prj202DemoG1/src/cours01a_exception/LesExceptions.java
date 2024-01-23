package cours01a_exception;

public class LesExceptions {
    public LesExceptions() {
        //lancerUneExceptionV1();

        traiterException();

    }

    private void traiterException() {
        try {
            System.out.println("traiterException : avant exception");
            lancerUneExceptionV2(false);
            System.out.println("traiterException : après exception"); //cette ligne est atteinte seulement si la ligne précédente ne fait pas d'erreurs
        } catch (Exception e) {
            System.out.println("Traiter exception");
            System.out.println(e.getMessage());
        }
        System.out.println("traiterException : fin");
    }

    private void lancerUneExceptionV1() {
        try { //bloc try : possible qu'il y ait quelque chose qui ne fonctionne pas comme prévu
            System.out.println("avant exception");
            throw new RuntimeException("Test exception"); // il y a un problème
            //     System.out.println("après exception"); //cette ligne ne pourrait pas être atteint
        } catch (RuntimeException exception) { //bloc catch : traite l'exception du bloc try
            System.out.println(exception.getMessage());
        }
        System.out.println("fin lancerUneExceptionV1");
    }

    private void lancerUneExceptionV2(boolean faireUneErreur) throws Exception { //throws indique que la méthode propage une exception
        if (faireUneErreur) {
            System.out.println("lancerUneExceptionV2 : avant exception");
            throw new Exception("Il y a une erreur");
            //     System.out.println("après exception"); //cette ligne ne pourrait pas être atteinte
        }
        System.out.println("lancerUneExceptionV2 : fin");
    }

    public static void main(String[] args) {
        new LesExceptions();
    }
}
