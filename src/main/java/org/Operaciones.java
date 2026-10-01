package org;

import javax.swing.*;

public class Operaciones {

    public double Operaciones (double primerNumero,double segundoNumero,String signo) {

        switch(signo){

            case "+":

                return primerNumero + segundoNumero;

            case "-":

                return primerNumero - segundoNumero;

            case "*":

                return primerNumero * segundoNumero;

            case  "/":

                return primerNumero / segundoNumero;

            case "%":

                return primerNumero % segundoNumero;

            case  "^":
                return primerNumero*primerNumero;
        }

        return 0;

    }

}
