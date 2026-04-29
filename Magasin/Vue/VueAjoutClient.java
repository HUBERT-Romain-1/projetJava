package Magasin.Vue;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutClient extends JFrame {
    JLabel nom = new JLabel("Nom :");
    JLabel prenom = new JLabel("Prenom :");
    JLabel email = new JLabel("Email :");

    JTextField zoneNom = new JTextField();
    JTextField zonePrenom = new JTextField();
    JTextField zoneEmail = new JTextField();

    JButton btnAjout = new JButton("Enregistrer le Client");
    JButton btnAnnuler = new JButton("Annuler");

    private Magasin magasin;

    public VueAjoutClient(Magasin m) {
        this.magasin = m;

        this.setTitle("Ajout CLient - " + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 250));

        JPanel formulaire = new JPanel(new GridLayout(3, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(prenom);
        formulaire.add(zonePrenom);

        formulaire.add(email);
        formulaire.add(zoneEmail);

        JPanel boutons = new JPanel(new GridLayout(1, 2, 20, 20));
        boutons.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));

        btnAjout.setPreferredSize(new Dimension(200, 40));
        btnAnnuler.setPreferredSize(new Dimension(100, 40));

        boutons.add(btnAnnuler);
        boutons.add(btnAjout);

        getContentPane().add(formulaire, BorderLayout.CENTER);
        getContentPane().add(boutons, BorderLayout.SOUTH);

    }

}
