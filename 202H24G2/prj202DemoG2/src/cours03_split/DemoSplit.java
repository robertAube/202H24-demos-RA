package cours03_split;

public class DemoSplit {
    public DemoSplit() {
        System.out.println(getMotsDUnePhrase("Autant chercher une aiguille dans une botte de foin."));
    }

    private String getMotsDUnePhrase(String phrase) {
        String unMotParLigne = "";
        String[] tabMots;

        tabMots = phrase.split(" ");

        for (int i = 0; i < tabMots.length; i++) {
            unMotParLigne += tabMots[i] + '\n';
        }

        return unMotParLigne;
    }

    public static void main(String[] args) {
        new DemoSplit();
    }
}
