package Magasin.Vue;

import Magasin.Controleur.ControleurAjoutFournisseur;
import Magasin.Controleur.ControleurBoutonAnnuler;
import Magasin.Model.*;
import javax.swing.*;
import java.awt.*;

public class VueAjoutFournisseur extends JFrame {

    JLabel nom = new JLabel("Nom :");
    JLabel numero = new JLabel("N° de la rue :");
    JLabel rue = new JLabel("Nom de la rue :");
    JLabel ville = new JLabel("Ville :");

    JTextField zoneNom = new JTextField();
    JTextField zoneNumero = new JTextField();
    JTextField zoneRue = new JTextField();
    JTextField zoneVille = new JTextField();

    JButton btnAjout = new JButton("Enregistrer le Fournisseur");
    private JButton btnAnnuler = new JButton("Annuler");

    private Magasin magasin;

    public VueAjoutFournisseur(Magasin m) {
        this.magasin = m;

        this.setTitle("Ajout Fournisseur - " + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 300));

        JPanel formulaire = new JPanel(new GridLayout(4, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        formulaire.add(nom);
        formulaire.add(zoneNom);

        formulaire.add(numero);
        formulaire.add(zoneNumero);

        formulaire.add(rue);
        formulaire.add(zoneRue);

        formulaire.add(ville);
        formulaire.add(zoneVille);

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

        ControleurAjoutFournisseur contAjout = new ControleurAjoutFournisseur(m, zoneNom, zoneNumero, zoneRue,
                zoneVille, this);
        btnAjout.addActionListener(contAjout);
    }

}
