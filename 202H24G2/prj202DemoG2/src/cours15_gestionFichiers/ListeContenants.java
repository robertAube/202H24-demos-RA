package cours15_gestionFichiers;

import java.util.ArrayList;

public class ListeContenants  {
    private ArrayList<ContenantLiquide> listeContenant;

    public ListeContenants() {
        listeContenant = new ArrayList<>();
        listeContenant.add(new ContenantLiquide("Verre", new Liquide("Eau", 1000), 300, 250));
        listeContenant.add(new ContenantLiquide("Tasse", new Liquide("café", 1010), 350, 200));
    }

    public void clear() {
        listeContenant.clear();
    }

    public int size() {
        return listeContenant.size();
    }

    @Override
    public String toString() {
        return "ListeContenants{" +
                "listeContenant=" + listeContenant +
                '}';
    }

    public ContenantLiquide get(int i) {
        return listeContenant.get(i);
    }

    public void add(ContenantLiquide contenantLiquide) {
        listeContenant.add(contenantLiquide);
    }
}
