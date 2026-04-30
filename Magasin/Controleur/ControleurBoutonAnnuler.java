package Magasin.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControleurBoutonAnnuler implements ActionListener {

    private JFrame fenetre;

    public ControleurBoutonAnnuler(JFrame f) {
        this.fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int reponse = JOptionPane.showConfirmDialog(
                fenetre,
                "Voulez-vous vraiment quitter sans enregistrer ?", // Le message
                "Confirmation", // Le titre
                JOptionPane.YES_NO_OPTION, // Les 2 boutons
                JOptionPane.WARNING_MESSAGE // panneau Danger
        );

        // 2. On teste la réponse
        if (reponse == JOptionPane.YES_OPTION) {
            this.fenetre.dispose();
        }

    }
}