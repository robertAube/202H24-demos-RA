package cours02a_exceptions;

public class LesExceptions {
    public LesExceptions() {
        //lancerUneExceptionV1();
        traiterException();
    }

    private void traiterException() {
        try {
            System.out.println("traiterException : avant appel de lancerUneExceptionV2()");
            lancerUneExceptionV2(false);
            System.out.println("traiterException : après appel de lancerUneExceptionV2(false)"); //cette ligne est atteinte seulement si lancerUneExceptionV2() ne lance pas d'exception
            lancerUneExceptionV2(true);
            System.out.println("traiterException : après appel de lancerUneExceptionV2(true)"); //cette ligne est atteinte seulement si lancerUneExceptionV2() ne lance pas d'exception
        } catch (Exception exception) {
            System.out.println("Traiter exception");
            System.out.println(exception.getMessage());
        }
        System.out.println("traiterException : fin");
    }

    private void lancerUneExceptionV2(boolean faireUneErreur) throws Exception { //throws indique que la méthode propage une exception
        if (faireUneErreur) {
            throw new Exception("quelque chose qui ne va pas dans lancerUneExceptionV2!");
            // System.out.println("après exception"); //cette ligne ne pourra pas être atteinte
        }
        System.out.println("lancerUneExceptionV2 : fin");
    }

    private void lancerUneExceptionV1() {
        try { //bloc try : possible qu'il y ait quelque chose qui ne fonctionne pas comme prévu
            //on lance une exception quand il y a quelque chose qui ne va pas et on ne sait pas comment le régler.
            throw new RuntimeException("quelque chose qui ne va pas!");// il y a un problème. J'instancie une excpetion (classe RuntimeException)
            // System.out.println("après exception"); //cette ligne ne pourra pas être atteinte
        } catch (RuntimeException exception) { //bloc catch : traite l'Exception du bloc try
            System.out.println(exception.getMessage());
        }
        System.out.println("lancerUneExceptionV1() : fin");
    }


    public static void main(String[] args) {
        new LesExceptions();
    }
}
