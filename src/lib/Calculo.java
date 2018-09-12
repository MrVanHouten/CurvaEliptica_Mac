/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author Arthur
 */
public class Calculo {

    public static int inversa(int in, int p) {
        int out = 0;
        int i = 1;
        double r = (i * p + 1) % in;

        while (r != 0) {
            i++;
            r = (i * p + 1) % in;       // Verifica quando o resto será zero
            if (i > 1000) {             // Caso loop infinito
                i = -1;
                break;
            }
        }
        out = ((i * p + 1) / in) % 47;  // Atribui o valor da saida
        if (i < 0) {
            out = 0;
        }

        return out;
    }
}
