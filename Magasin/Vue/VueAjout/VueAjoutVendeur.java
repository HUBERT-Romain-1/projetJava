package Magasin.Vue.VueAjout;

import Magasin.Controleur.ControleurBoutonAnnuler;
import Magasin.Controleur.AjoutVendeur.ControleurAjoutVendeur;
import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutVendeur extends JFrame {

    JLabel nom = new JLabel("Nom :");
    JLabel prenom = new JLabel("Prenom :");
    JLabel telephone = new JLabel("Telephone :");

    JTextField zoneNom = new JTextField();
    JTextField zonePrenom = new JTextField();
    JTextField zoneTel = new JTextField();

    JButton btnAjout = new JButton("Enregistrer le Vendeur");
    private JButton btnAnnuler = new JButton("Annuler");

    private Magasin magasin;

    public VueAjoutVendeur(Magasin m) {
        this.magasin = m;

        this.setTitle("Ajout Vendeur - " + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 250));

        JPanel formulaire = new JPanel(new GridLayout(3, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(prenom);
        formulaire.add(zonePrenom);

        formulaire.add(telephone);
        formulaire.add(zoneTel);

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

        ControleurAjoutVendeur contAjout = new ControleurAjoutVendeur(m,
                zoneNom, zonePrenom, zoneTel, this);
        btnAjout.addActionListener(contAjout);
    }

}
