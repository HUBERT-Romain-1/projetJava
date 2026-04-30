package Magasin.Controleur;

import Magasin.Model.*;
import Magasin.Vue.*;

import javax.swing.*;
import java.awt.event.*;

public class ControleurPagePrincipale implements ActionListener {

    Magasin magasin;

    public ControleurPagePrincipale(Magasin m) {
        this.magasin = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String texteBouton = ((JButton) e.getSource()).getText();

        JFrame vue = null;

        if (texteBouton.equals("Ajouter Client")) {
            vue = new VueAjoutClient(magasin);
        }

        else if (texteBouton.equals("Ajouter Vendeur")) {
            vue = new VueAjoutVendeur(magasin);
        }

        else if (texteBouton.equals("Ajouter Vente")) {
            vue = new VueAjoutVente(magasin);
        }

        else if (texteBouton.equals("Ajouter Article")) {
            vue = new VueAjoutArticle(magasin);
        }

        else if (texteBouton.equals("Ajouter Fournisseur")) {
            vue = new VueAjoutFournisseur(magasin);
        }

        else if (texteBouton.equals("Ajouter Rayon")) {
            vue = new VueAjoutRayon(magasin);
        }

        else if (texteBouton.equals("Ajouter Rayon")) {
            vue = new VueAjoutRayon(magasin);
        }

        else if (texteBouton.equals("Consulter Client")) {
            vue = new VueConsulterClient(magasin);
        }

        else if (texteBouton.equals("Consulter Vendeur")) {
            vue = new VueConsulterVendeur(magasin);
        }

        else if (texteBouton.equals("Consulter Vente")) {
            vue = new VueConsulterVente(magasin);
        }

        else if (texteBouton.equals("Consulter Article")) {
            vue = new VueConsulterArticle(magasin);
        }

        else if (texteBouton.equals("Consulter Fournisseur")) {
            vue = new VueConsulterArticle(magasin);
        }

        else if (texteBouton.equals("Consulter Rayon")) {
            vue = new VueConsulterRayon(magasin);
        }

        // else {
        // vue = new VueStatistique(magasin);
        // }

        if (vue != null) {
            vue.pack();
            vue.show();
        }
    }
}
