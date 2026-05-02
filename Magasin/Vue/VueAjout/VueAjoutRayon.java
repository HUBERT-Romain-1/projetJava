package Magasin.Vue.VueAjout;

import Magasin.Controleur.*;
import Magasin.Controleur.AjoutRayon.ControleurAjoutRayon;
import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutRayon extends JFrame {

    JLabel nom = new JLabel("Nom :");
    JLabel capacite = new JLabel("Capacité maximum :");

    JTextField zoneNom = new JTextField();
    JTextField zoneCapacite = new JTextField();

    JButton btnAjout = new JButton("Enregistrer le Rayon");
    private JButton btnAnnuler = new JButton("Annuler");

    private Magasin magasin;

    public VueAjoutRayon(Magasin m) {
        this.magasin = m;

        this.setTitle("Ajout Rayon - " + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 225));

        JPanel formulaire = new JPanel(new GridLayout(2, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(capacite);
        formulaire.add(zoneCapacite);

        JPanel boutons = new JPanel(new GridLayout(1, 2, 20, 20));
        boutons.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));

        btnAjout.setPreferredSize(new Dimension(200, 40));
        btnAnnuler.setPreferredSize(new Dimension(100, 40));

        boutons.add(btnAnnuler);
        boutons.add(btnAjout);

        getContentPane().add(formulaire, BorderLayout.CENTER);
        getContentPane().add(boutons, BorderLayout.SOUTH);

        ControleurBoutonAnnuler cont = new ControleurBoutonAnnuler(this);
        btnAnnuler.addActionListener(cont);

        ControleurAjoutRayon contAjout = new ControleurAjoutRayon(m, zoneNom, zoneCapacite, this);
        btnAjout.addActionListener(contAjout);

    }
}
