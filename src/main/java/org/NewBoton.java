package org;

import javax.swing.*;
import java.awt.*;

public class NewBoton extends JButton {

    public NewBoton(String texto) {

        super(texto);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);


    }

    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(

                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON

        );

        g2.setColor(getBackground());

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);

        super.paintComponent(g2);

    }

}
