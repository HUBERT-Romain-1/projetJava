import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Magasin monMagasin = new Magasin("RoCoorp", "1 rue des JO");

        Rayon football = new Rayon("football", monMagasin, 50);
        Rayon tennis = new Rayon("tennis", monMagasin, 100);
        Rayon natation = new Rayon("natation", monMagasin, 75);

        Article ballonFootball = new Article("Ballon de foot", 10, 10, "Football", monMagasin);
        Article maillotFoot = new Article("Maillot de foot", 90, 10, "Football", monMagasin);

        Client johnn = new Client("John", "Johnn", "johnn.john@gmail.com", monMagasin);
        Client dimitri = new Client("Le prince", "Dimitri", "leprice.dimitri@gmail.com", monMagasin);

        Vendeur vendeur1 = new Vendeur("A", "Bea", "98049409", monMagasin);
        Vendeur vendeur2 = new Vendeur("Dupond", "Patrick", "0123654456", monMagasin);

        Materiel velo = new Materiel("Velo VTT", 250, 10, "Cyclisme", monMagasin, 10, 1500);
        Materiel tablePing = new Materiel("Table de ping-pong", 300, 12, "Ping-Pong", monMagasin, 25, 1000);
        Nourriture barreDeChocolat = new Nourriture("Barre de chocolat", 10, 10, "fitness", monMagasin,
                "chocolat", LocalDate.parse("2026-05-01"));

        Vente vente1 = new Vente(null, dimitri, vendeur2, monMagasin);
        vente1.ajouterProduit(ballonFootball, 2);
        vente1.ajouterProduit(velo, 1);
        vente1.ajouterProduit(barreDeChocolat, 15);

        vente1.toString();
        vendeur2.calculCA();
        monMagasin.affichageMagasin();

    }
}
