package Magasin.Vue;

import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutFournisseur extends JFrame {

    JLabel nom = new JLabel("Nom :");
    JLabel lieu = new JLabel("Lieu :");

    JTextField zoneNom = new JTextField();
    JTextField zoneLieu = new JTextField();

    JButton btnAjout = new JButton("Enregistrer le Fournisseur");
    private JButton btnAnnuler = new JButton("Annuler");

    private Magasin magasin;

    public VueAjoutFournisseur(Magasin m) {
        this.magasin = m;

        this.setTitle("Ajout Fournisseur - " + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 250));

        JPanel formulaire = new JPanel(new GridLayout(2, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(lieu);
        formulaire.add(zoneLieu);

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
