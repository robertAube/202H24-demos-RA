package cours15_cloneEnProfondeur;

/*
420-202 – Traitement de données orienté objet
*/
public class AppClonePizza {
    private Pizza p1;
    private Pizza p2;
    public AppClonePizza() {
        try {
            testerClonerPizza();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private void testerClonerPizza() throws CloneNotSupportedException {
        System.out.println("testerClonerPizza()");

        p1 = new Pizza(1,2,"rouge", 3);

        System.out.println(p1);

        //todo cloner p1 dans pizza p2
        System.out.println("On clone : ");
        p2 = p1; //Remplacer cette ligne pour réellement cloner une pizza

        p2.setAll(3,4,"bleu", 5);

        les2PizzasSontEgales(); // pizza p1 devrait être totalement différent de pizza p2
        System.out.println(p1);
        System.out.println(p2);
    }

    private void les2PizzasSontEgales() {
        afficherEstEgal("x est égal", p1.getX(), p2.getX());
        afficherEstEgal("y est égal", p1.getY(), p2.getY());
        afficherEstEgal("couleur est égale", p1.getCouleur(), p2.getCouleur());
        afficherEstEgal("vitesse est égale", p1.getVitesse(), p2.getVitesse());
    }

    private void afficherEstEgal(String str, Object o1, Object o2) {
        boolean estEgal = o1.equals(o2);
        String s1 = estEgal ? "=" : " != ";
        System.out.println(str + " : " + o1 + s1 + o2);
    }

    public static void main(String[] args) {
        new AppClonePizza();
    }
}
