/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author washington-pc
 */
public class Perceptron {

//    public int[][] amostra = new int[4][2];
//    public float amostra[][] = {{0,0,0},{0,1,1},{1,0,1},{1,1,1}};

//    public Perceptron() {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 2; j++) {
//                amostra[i][j] = (new Random().nextInt());
//            }
//        }
//    }

//    public void printAmostra() {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(amostra[i][j]+"|");
//            }
//            System.out.println(" ");
//        }
//        
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println(amostra[0][0]);
       Perceptron p = new Perceptron();
       Rdna r = new Rdna();
       
       float[] res = r.perceptron();
       if(res != null){
           for (int i = 0; i < 7; i++) {
               System.out.println(res[i]);
           }
       }
       
        System.out.println("fim");
//       p.printAmostra();
    }

}
