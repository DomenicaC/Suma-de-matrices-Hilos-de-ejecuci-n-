/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.principal;

import java.util.Scanner;

/**
 *
 * @author Domenica Cañizares
 */
public class Matriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner sn = new Scanner(System.in);

        System.out.println("Ingrese el numero de la matriz cuadrada \n");
        int num = sn.nextInt();

        int mA[][] = new int[num][num];
        int mB[][] = new int[num][num];
        int mRes[][] = new int[num][num];

        System.out.println("Matriz A");
        for (int i = 0; i < mA.length; i++) {
            for (int j = 0; j < mA.length; j++) {

                mA[i][j] = (int) (Math.random() * 100);
                System.out.print("|" + mA[i][j]);

            }
        }
        System.out.println("\n");

        System.out.println("Matriz B");
        for (int i = 0; i < mB.length; i++) {
            for (int j = 0; j < mB.length; j++) {

                mB[i][j] = (int) (Math.random() * 100);
                System.out.print("|" + mB[i][j]);

            }
        }
        System.out.println("\n");

        //hilos
        System.out.println("Ingrese el numero de hilos");
        int nHilos = sn.nextInt();
        int repartir = num % nHilos;

        SumaMatriz[] hilo = new SumaMatriz[nHilos];
        int fila = 0;
        int siguiente;

        for (int i = 0; i < nHilos; i++) {

            siguiente = fila + num / nHilos;

            if (i < repartir) {
                ++siguiente;
            }
            hilo[i] = new SumaMatriz(mRes, mA, mB, fila, siguiente);
            hilo[i].start();
            fila = siguiente;

        }

        //hilos acaben
        for (int i = 0; i < nHilos; i++) {
            hilo[i].join();
        }
        System.out.println("");
        System.out.println("Resultado suma: \n");
        for (int i = 0; i < mRes.length; i++) {
            for (int j = 0; j < mRes.length; j++) {

                System.out.print("|" + mRes[i][j]);

            }

        }

    }

}
