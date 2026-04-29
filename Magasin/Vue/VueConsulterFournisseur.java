package Magasin.Vue;

import Magasin.Model.*;
import Magasin.Controleur.*;

import javax.swing.*;
import java.awt.*;

public class VueConsulterFournisseur extends JFrame {

    JLabel nom = new JLabel("Nom :");
    JLabel lieu = new JLabel("Lieu :");

    JTextField zoneNom = new JTextField();
    JTextField zoneLieu = new JTextField();

    Magasin magasin;

    JButton btnChercher = new JButton("Chercher");
    JButton btnModifier = new JButton("Enregistrer les Modifications");
    JButton btnAnnuler = new JButton("Annuler");
    JButton btnVoirListeClient = new JButton("Voir Liste Fournisseur");

    public VueConsulterFournisseur(Magasin m) {
        this.magasin = m;

        this.setTitle("Consulter / Modifier Fournisseur -" + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 250));

        JPanel formulaire = new JPanel(new GridLayout(2, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(lieu);
        formulaire.add(zoneLieu);

        JPanel boutons = new JPanel();
        boutons.add(btnAnnuler);
        boutons.add(btnChercher);
        boutons.add(btnModifier);
        boutons.add(btnVoirListeClient);

        getContentPane().add(formulaire, BorderLayout.CENTER);
        getContentPane().add(boutons, BorderLayout.SOUTH);

    }

}
