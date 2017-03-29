/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.Random;

/**
 *
 * @author washington-pc
 */
public class Rdna {

//    private final short t = 5;
    private float[] pesos;
    private float[] res;

    //tabelas logicas
    private float[][] amostras = {{0, 0, 0, 0}, {0, 0, 1, 1}, {0, 1, 0, 0}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}};
    private int linhas = 7;
    private int colunas = 3;
    private float taxaAprendizado = (float) 0.05;
    private float omega = (float) 0.5;

//    private float[][] amostras = {{0, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 1, 1}, {1, 1, 0, 0}, {1, 1, 1, 1}};
//    private int linhas = 8;
//    private int colunas = 3;
//    private float taxaAprendizado = (float) 0.05;
//    private float omega = (float) 0.5;
//    private float[][] amostras = {{0,0,0},{0,1,0},{1,0,0},{1,1,1}};
//    private int linhas = 4;
//    private int colunas = 2;,
//    private float taxaAprendizado = (float) 0.05;
//    private float omega = (float) 0.5;
    //ex: classificacao
//    private float[][] amostras = {{(float) 0.1, (float) 0.4, (float) 0.7, 1}, {(float) 0.5, (float) 0.7, (float) 0.1, 1},
//    {(float) 0.6, (float) 0.9, (float) 0.8, -1}, {(float) 0.3, (float) 0.7, (float) 0.2, -1}};
//    private int linhas = 4;
//    private int colunas = 3;
//    private float taxaAprendizado = (float) 0.05;
//    private float omega = (float) 0;
    public Rdna() {
        res = new float[linhas];
        for (int i = 0; i < linhas; i++) {
            res[i] = 0;
        }

        pesos = new float[colunas + 1];
        for (int i = 0; i <= colunas; i++) {
            pesos[i] = new Random().nextFloat() % 2;
        }
    }

    public float[] perceptron() {
        float erro;
        do {
            erro = 0;
            for (int i = 0; i < linhas; i++) {
                res[i] = 0;
                for (int j = 0; j < colunas; j++) {
                    // res[i] += pesos[j] * amostras[i][j];
                    res[i] += pesos[j] * amostras[i][j] + pesos[j] * amostras[i][j] * amostras[i][j];
                }
                res[i] += 0;
                //varifica se o valor calculado e maior que omega
                float sinal = sinal(res[i]);
                //verifica se existe erro
                if (amostras[i][colunas] - sinal != 0) {
                    erro = 1;
                    //reajustas os pesos
                    for (int j = 0; j < colunas; j++) {
                        pesos[j] = pesos[j] + amostras[i][j] * taxaAprendizado * (amostras[i][colunas] - sinal);
                    }
                    pesos[colunas] = pesos[colunas] + -1 * taxaAprendizado * (amostras[i][colunas] - sinal);
                }
                res[i] = sinal;
                for (int j = 0; j < 4; j++) {
                    System.out.print(" "+pesos[j]);
                }
                System.out.println("");
            }
        } while (erro != 0);

        for (int i = 0; i < 4; i++) {
            System.out.println(pesos[i]);
        }
        return res;
    }

    public float sinal(float calculado) {
        //tabelas logicas
        return (calculado > this.omega) ? 1 : 0;
        //classificacao 
//        return (calculado > this.omega) ? 1 : -1;
    }
}
