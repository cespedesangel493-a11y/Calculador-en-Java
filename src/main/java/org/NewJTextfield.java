package org;

import javax.swing.*;
import java.awt.*;

public class NewJTextfield extends JTextField {

    public NewJTextfield(String text) {

        super(text);

        setForeground(new Color(255, 255, 255));
        setBackground(new Color(102, 102, 102));
        setBorder(null);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        setFont(new Font("Segoe UI", Font.BOLD, 40));


    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(

                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON

        );

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        g2.setColor(new Color(255, 255, 255));

        super.paintComponent(g2);

    }

    public void ajustarTexto (){

        String texto = getText();
        int tamañomax = 60;
        Font fuente = new Font("Angelito", Font.BOLD, tamañomax);
        FontMetrics fm = getFontMetrics(fuente);

        IO.println("Ancho: " + getWidth());

        while (fm.stringWidth(texto) > getWidth() -20 && tamañomax > 10) {

            tamañomax--;

            fuente = new Font("Angelito", Font.BOLD, tamañomax);
            fm = getFontMetrics(fuente);

        }

        setFont(fuente);

    }

}
