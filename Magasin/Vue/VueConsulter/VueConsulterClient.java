package Magasin.Vue.VueConsulter;

import Magasin.Model.*;
import Magasin.Controleur.*;

import javax.swing.*;
import java.awt.*;

public class VueConsulterClient extends JFrame {

    JLabel nom = new JLabel("Nom :");
    JLabel prenom = new JLabel("Prenom :");
    JLabel email = new JLabel("Email :");

    JTextField zoneNom = new JTextField();
    JTextField zonePrenom = new JTextField();
    JTextField zoneEmail = new JTextField();

    // Boutons spécifiques à la consultation
    JButton btnChercher = new JButton("Chercher");
    JButton btnModifier = new JButton("Enregistrer les Modifications");
    JButton btnAnnuler = new JButton("Annuler");
    JButton btnVoirListeClient = new JButton("Voir Liste Client");

    private Magasin magasin;

    public VueConsulterClient(Magasin m) {
        this.magasin = m;

        this.setTitle("Consulter / Modifier Client - " + magasin.getNomMagasin());
        this.setPreferredSize(new Dimension(800, 250));

        // Formulaire (CENTER)
        JPanel formulaire = new JPanel(new GridLayout(3, 2, 20, 20));
        formulaire.setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));
        formulaire.add(nom);
        formulaire.add(zoneNom);
        formulaire.add(prenom);
        formulaire.add(zonePrenom);
        formulaire.add(email);
        formulaire.add(zoneEmail);

        // Barre d'actions
        JPanel boutons = new JPanel();
        boutons.add(btnAnnuler);
        boutons.add(btnChercher);
        boutons.add(btnModifier);
        boutons.add(btnVoirListeClient);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(formulaire, BorderLayout.CENTER);
        this.getContentPane().add(boutons, BorderLayout.SOUTH);
    }
}