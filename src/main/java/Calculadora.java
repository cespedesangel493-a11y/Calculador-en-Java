import org.NewBoton;
import org.NewJTextfield;
import org.Operaciones;
import javax.swing.*;
import java.awt.*;

public class Calculadora {

    static double primerNumero;
    static double segundoNumero;
    static String signo;


    public static void main(String[] args) {

        Operaciones operacion = new Operaciones();

        JFrame ventana = new JFrame("Calculadora");
        JPanel botones = new JPanel();
        NewJTextfield texto = new NewJTextfield("");


        NewBoton boton1 = new NewBoton("1");
        NewBoton boton2 = new NewBoton("2");
        NewBoton boton3 = new NewBoton("3");
        NewBoton boton4 = new NewBoton("4");
        NewBoton boton5 = new NewBoton("5");
        NewBoton boton6 = new NewBoton("6");
        NewBoton boton7 = new NewBoton("7");
        NewBoton boton8 = new NewBoton("8");
        NewBoton boton9 = new NewBoton("9");
        NewBoton boton0 = new NewBoton("0");
        NewBoton botonplus = new NewBoton("+");
        NewBoton botonrest = new NewBoton("-");
        NewBoton botondivide = new NewBoton("/");
        NewBoton botonmultiply = new NewBoton("*");
        NewBoton botonequal = new NewBoton("=");
        NewBoton botonpoint = new NewBoton(".");
        NewBoton botonAC = new NewBoton("AC");
        NewBoton botonresidue = new NewBoton("%");
        NewBoton botonexponencial = new NewBoton("^2");
        NewBoton botonquitar = new NewBoton("<-");

        //----------------------------------------------Interfaz-----------------------------------------------------//

        ventana.getContentPane().setBackground(new Color(51,51,51));
        ((javax.swing.JComponent) ventana.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));


        //-----------------------------------Configuracion de caja de texto-------------------------------------------//

        ventana.add(texto, BorderLayout.NORTH);
        texto.setEditable(false);
        texto.setHorizontalAlignment(NewJTextfield.RIGHT);
        texto.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        //-------------------------------------Ajuste del panel de botones--------------------------------------------//

        botones.setLayout(new GridLayout(5, 4, 5, 5));
        botones.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        botones.setBackground(new Color(51, 51, 51));
        botones.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ventana.getContentPane().add(botones, BorderLayout.CENTER);

        //-------------------------------Ingreso de botones y su configuracion----------------------------------------//



        NewBoton[] botonesnum = {
                boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9
        };

        for (NewBoton boton : botonesnum) {

            boton.setBackground(new Color(204, 204, 204));



            boton.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseEntered(java.awt.event.MouseEvent evt) {

                    boton.setBackground(new Color(102, 102, 102));

                }

                public void mouseExited(java.awt.event.MouseEvent evt) {

                    boton.setBackground(new Color(204, 204, 204));

                }

            });

            boton.setBorderPainted(false);

        }

        NewBoton[] botonesaccion = {

                botonAC, botondivide,botonmultiply, botonequal, botonexponencial,botonpoint,botonplus,botonquitar,
                botonrest,botonresidue

        };

        for (NewBoton boton : botonesaccion) {

            boton.setBackground(new Color(102, 102, 102));
            boton.setBorderPainted(false);
            boton.setForeground(Color.white);

            boton.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseEntered(java.awt.event.MouseEvent evt) {

                    boton.setBackground(new Color(204, 204, 204));

                }

                public void mouseExited(java.awt.event.MouseEvent evt) {

                    boton.setBackground(new Color(102, 102, 102));

                }

            });


        }

        NewBoton[] allbottons = {

                boton0, boton1, boton2, boton3, boton4, boton5, boton6,
                boton7, boton8, boton9,
                botonAC, botondivide,botonmultiply,botonequal,botonexponencial,botonpoint,botonplus,botonresidue

        };

        for (NewBoton boton : allbottons) {

            boton.setFont(new Font("Segoe UI", Font.BOLD, 20));
            boton.repaint();
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            boton.setFocusable(false);

        }

        //Primera fila---------------------------------------------

        botones.add(botonAC);

        botonAC.addActionListener(e->{             //AC

            primerNumero = 0;
            segundoNumero= 0;
            texto.setText("");
            texto.ajustarTexto();

        });

        botones.add(botonexponencial);

        botonexponencial.addActionListener(e->{              //Exponencia

            signo = "^";
            primerNumero = Double.parseDouble(texto.getText());

            if(operacion.Operaciones(primerNumero,segundoNumero,signo) != (int) operacion.Operaciones(primerNumero,segundoNumero,signo)){

                texto.setText(String.valueOf(operacion.Operaciones(primerNumero,segundoNumero,signo)));

            }else{

                texto.setText(String.valueOf((int)operacion.Operaciones(primerNumero,segundoNumero,signo)));

            }
            texto.ajustarTexto();

        });

        botones.add(botonresidue);

        botonresidue.addActionListener(e->{        //Residuo

            signo = "%";
            primerNumero = Double.parseDouble(texto.getText());
            texto.setText("");
            texto.ajustarTexto();

        });

        botones.add(botondivide);                              //Division

        botondivide.addActionListener(e->{

            signo = "/";
            primerNumero = Double.parseDouble(texto.getText());
            texto.setText("");
            texto.ajustarTexto();

        });

        // Segunda fila---------------------------------------------

        botones.add(boton7);

        boton7.addActionListener(e->{
            texto.setText(texto.getText()+"7");
            texto.ajustarTexto();

        });

        botones.add(boton8);

        boton8.addActionListener(e->{
            texto.setText(texto.getText()+"8");
            texto.ajustarTexto();
        });

        botones.add(boton9);

        boton9.addActionListener(e->{
            texto.setText(texto.getText()+"9");
            texto.ajustarTexto();
        });

        botones.add(botonmultiply);

        botonmultiply.addActionListener(e->{        //Multiplicacion

            signo = "*";
            primerNumero = Double.parseDouble(texto.getText());
            texto.setText("");
            texto.ajustarTexto();

        });

        //Tercera fila----------------------------------------------

        botones.add(boton4);

        boton4.addActionListener(e->{
            texto.setText(texto.getText()+"4");
            texto.ajustarTexto();
        });

        //-------------------------------------------------

        botones.add(boton5);

        boton5.addActionListener(e->{
            texto.setText(texto.getText()+"5");
            texto.ajustarTexto();
        });

        //-------------------------------------------------

        botones.add(boton6);

        boton6.addActionListener(e->{
            texto.setText(texto.getText()+"6");
            texto.ajustarTexto();
        });

        //------------------------------------------------

        botones.add(botonrest);                                 //Resta

        botonrest.addActionListener(e->{

            signo = "-";
            primerNumero = Double.parseDouble(texto.getText());
            texto.setText("");
            texto.ajustarTexto();

        });

        //Cuarta fila--------------------------------------


        botones.add(boton1);

        boton1.addActionListener(e->{
            texto.setText(texto.getText()+"1");
            texto.ajustarTexto();

        });

        //-----------------------------------------------------

        botones.add(boton2);

        boton2.addActionListener(e->{
            texto.setText(texto.getText()+"2");
            texto.ajustarTexto();
        });

        //----------------------------------------------------

        botones.add(boton3);

        boton3.addActionListener(e->{
            texto.setText(texto.getText()+"3");
            texto.ajustarTexto();
        });

        //----------------------------------------------------

        botones.add(botonplus);                               //Suma

        botonplus.addActionListener(e->{

            signo = "+";
            primerNumero = Double.parseDouble(texto.getText());
            texto.setText("");
            texto.ajustarTexto();

        });

        //Quinta fila--------------------------------------------------

        botones.add(botonpoint);

        botonpoint.addActionListener(e->{
            texto.setText(texto.getText()+".");
            texto.ajustarTexto();
        });

        //-------------------------------------------------

        botones.add(boton0);

        boton0.addActionListener(e->{
            texto.setText(texto.getText()+"0");
            texto.ajustarTexto();
        });

        //-------------------------------------------------

        botones.add(botonquitar);

        botonquitar.addActionListener(e->{        // Quitar

            if(!texto.getText().isEmpty()) {

                texto.setText(texto.getText().substring(0, texto.getText().length() - 1));
            }

            texto.ajustarTexto();

        });

        //-------------------------------------------------

        botones.add(botonequal);                              //igual

        botonequal.addActionListener(e->{

            segundoNumero = Double.parseDouble(texto.getText());

            if(operacion.Operaciones(primerNumero,segundoNumero,signo) != (int) operacion.Operaciones(primerNumero,segundoNumero,signo)){

                texto.setText(String.valueOf(operacion.Operaciones(primerNumero,segundoNumero,signo)));

            }else{

                texto.setText(String.valueOf((int)operacion.Operaciones(primerNumero,segundoNumero,signo)));

            }

            primerNumero = 0;
            segundoNumero = 0;
            signo = null;

            texto.ajustarTexto();

        });

        // Se configura la ventana

        ventana.setSize(340,500);



        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);



    }

}
