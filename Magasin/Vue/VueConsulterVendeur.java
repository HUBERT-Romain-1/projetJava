package Magasin.Vue;

import Magasin.Model.*;
import Magasin.Controleur.*;

import javax.swing.*;
import java.awt.*;

public class VueConsulterVendeur extends JFrame {
    JLabel nom = new JLabel("Nom :");
    JLabel prenom = new JLabel("Prenom :");
    JLabel telephone = new JLabel("Téléphone :");

    JTextField zoneNom = new JTextField();
    JTextField zonePrenom = new JTextField();
    JTextField zoneTel = new JTextField();

    JButton btnAnnuler = new JButton("Annuler");
    JButton btnChercher = new JButton("Chercher");
    JButton btnModifier = new JButton("Enregistrer les Modifications");
    JButton btnVoirListeClient = new JButton("Voir Listes Clients");

    private Magasin magasin;

    public VueConsulterVendeur(Magasin m) {
        this.magasin = m;

        this.setTitle("Consulter / Modifier Vendeur - " + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 300));

        JPanel formulaire = new JPanel(new GridLayout(3, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(prenom);
        formulaire.add(zonePrenom);

        formulaire.add(telephone);
        formulaire.add(zoneTel);

        JPanel boutons = new JPanel();
        boutons.add(btnAnnuler);
        boutons.add(btnChercher);
        boutons.add(btnModifier);
        boutons.add(btnVoirListeClient);

        getContentPane().add(formulaire, BorderLayout.CENTER);
        getContentPane().add(boutons, BorderLayout.SOUTH);

    }

}
