package Magasin.Controleur.AjoutArticle;

import javax.swing.*;
import java.awt.event.*;
import java.awt.CardLayout;

public class ControleurRetourArticle implements ActionListener {
    private JPanel conteneurPrincipal;
    private CardLayout clPrincipal;

    public ControleurRetourArticle(JPanel conteneur) {
        this.conteneurPrincipal = conteneur;

        this.clPrincipal = (CardLayout) conteneur.getLayout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
        clPrincipal.show(conteneurPrincipal, "P1");
    }
}
