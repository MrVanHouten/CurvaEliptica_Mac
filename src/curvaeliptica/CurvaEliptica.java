/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curvaeliptica;

import java.util.ArrayList;
import java.util.List;
import lib.Calculo;

/**
 *
 * @author Arthur
 */
public class CurvaEliptica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int A = 22;
        int B = 15;
        int P = 47;
        int m;
        int x1 = 0;
        int y1 = 0;
        int x2;
        int y2;
        int x3;
        int y3;
        int inv;
        List<int[]> lista = new ArrayList<>();
        List<int[]> out = new ArrayList<>();

        System.out.println("Problema 1: Pontos da curva eliptica");
        for (int x = 0; x < P; x++) {
            for (int y = 0; y < P; y++) {
                if ((Math.pow(y, 2) % P) == (Math.pow(x, 3) + A * x + B) % P) {
                    lista.add(new int[]{x, y});
                    System.out.println(x + " " + y);
                }
            }
        }

        System.out.println("Problema 2: Curva a partir do ponto P(3,22)");
        for (int i = 0; i <= lista.size(); i++) {
            if (i == 0) {
                x1 = lista.get(0)[0];
                y1 = lista.get(0)[1];
                out.add(new int[]{x1, y1});
                System.out.println(x1 + " " + y1);
            } else if (i == 1) {
                m = ((3 * (int) (Math.pow(x1, 2) % P) + A) * Calculo.inversa(2 * y1, P)) % P;
                x2 = (P + (int) (Math.pow(m, 2) - 2 * x1) % P) % P;
                y2 = (P + (m * (x1 - x2) - y1) % P) % P;
                out.add(new int[]{x2, y2});
                System.out.println(x2 + " " + y2);
            } else if (i == lista.size()) {
                x3 = lista.get(0)[0];
                y3 = lista.get(0)[1];
                out.add(new int[]{x3, y3});
                System.out.println(x3 + " " + y3);
            } else {
                inv = Calculo.inversa((out.get(0)[0] - out.get(i - 1)[0]), P);
                m = (out.get(0)[1] - out.get(i - 1)[1]) * inv % P;
                x3 = (P + (int) (Math.pow(m, 2) - out.get(0)[0] - out.get(i - 1)[0]) % P) % P;
                y3 = (P + (m * (out.get(0)[0] - x3) - out.get(0)[1]) % P) % P;
                out.add(new int[]{x3, y3});
                System.out.println(x3 + " " + y3);
            }
        }
    }
}
