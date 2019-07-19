/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.principal;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Domenica Cañizares
 */
public class Matriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("\n" + "Elija el valor de la matriz cuadratica");

            System.out.println("1. 100 X 100");
            System.out.println("2. 1000 X 1000");
            System.out.println("3. 2000 X 2000");
            System.out.println("4. 3000 X 3000");
            System.out.println("5. 4000 X 4000");
            System.out.println("6. 5000 X 5000");
            System.out.println("7. Otro valor");
            System.out.println("8. Salir");

            System.out.println("\n Elija una opcion");
            opcion = sn.nextInt();
            switch (opcion) {

                case 1:
                    long tiempoInicio,
                     tiempoFinal,
                     tiempoInicio1,
                     tiempoFinal1;
                    int num = 100;
                    System.out.println("tamaño" + num);

                    int mA[][] = new int[num][num];
                    int mB[][] = new int[num][num];
                    int mRes[][] = new int[num][num];

                    System.out.println(" ----- Matriz A ----- ");
                    for (int i = 0; i < mA.length; i++) {
                        for (int j = 0; j < mA.length; j++) {

                            mA[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mA[i][j]);

                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    System.out.println(" ----- Matriz B ----- ");
                    for (int i = 0; i < mB.length; i++) {
                        for (int j = 0; j < mB.length; j++) {

                            mB[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mB[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    tiempoInicio = System.currentTimeMillis();
                    System.out.println("Tiempo inicial " + tiempoInicio);

                    System.out.println(" ----- Respuesta sin hilos -----");

                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num; j++) {
                            mRes[i][j] = mA[i][j] + mB[i][j];
                            System.out.print("|" + mRes[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }

                    tiempoFinal = System.currentTimeMillis() - tiempoInicio;
                    System.out.println("Tiempo final " + tiempoFinal);
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
                        hilo[i] = new SumaMatriz(mA, mB, mRes, fila, siguiente);
                        hilo[i].start();
                        fila = siguiente;

                    }

                    //hilos acaben
                    for (int i = 0; i < nHilos; i++) {
                        try {
                            hilo[i].join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                    tiempoInicio1 = System.currentTimeMillis();
                    System.out.println("Tiempo inicial " + tiempoInicio1);
                    System.out.println("\n");

                    System.out.println("Resultado suma: \n");
                    for (int i = 0; i < mRes.length; i++) {
                        for (int j = 0; j < mRes.length; j++) {

                            System.out.print("|" + mRes[i][j]);

                        }
                        System.out.println("\n");
                    }

                    tiempoFinal1 = System.currentTimeMillis() - tiempoInicio1;

                    System.out.println("Tiempo inicial " + tiempoInicio1);

                    System.out.println("\n " + " ----- Tiempos de ejecucion -----");

                    System.out.println("Sin hilos: " + tiempoFinal + " milisegundos");
                    System.out.println("Con hilos: " + tiempoFinal1 + " milisegundos");

                    break;
//-----------------------------------------------------------------------------------------------------------------------
                case 2:

                    long tiempoInicio2,
                     tiempoFinal2,
                     tiempoInicio12,
                     tiempoFinal12;
                    int num1 = 1000;
                    System.out.println("tamaño" + num1);

                    int mA1[][] = new int[num1][num1];
                    int mB1[][] = new int[num1][num1];
                    int mRes1[][] = new int[num1][num1];

                    System.out.println(" ----- Matriz A ----- ");
                    for (int i = 0; i < mA1.length; i++) {
                        for (int j = 0; j < mA1.length; j++) {

                            mA1[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mA1[i][j]);

                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    System.out.println(" ----- Matriz B ----- ");
                    for (int i = 0; i < mB1.length; i++) {
                        for (int j = 0; j < mB1.length; j++) {

                            mB1[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mB1[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    tiempoInicio2 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio2 + " milisegundos");

                    System.out.println(" ----- Respuesta sin hilos -----");

                    for (int i = 0; i < num1; i++) {
                        for (int j = 0; j < num1; j++) {
                            mRes1[i][j] = mA1[i][j] + mB1[i][j];
                            System.out.print("|" + mRes1[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }

                    tiempoFinal2 = System.currentTimeMillis() - tiempoInicio2;
                    System.out.println("Tiempo final " + tiempoFinal2 + " milisegundos");

                    //hilos
                    System.out.println("Ingrese el numero de hilos");
                    int nHilos1 = sn.nextInt();

                    tiempoInicio12 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio12 + " milisegundos");

                    int repartir1 = num1 % nHilos1;

                    SumaMatriz[] hilo1 = new SumaMatriz[nHilos1];
                    int fila1 = 0;
                    int siguiente1 = 0;

                    for (int i = 0; i < nHilos1; i++) {

                        siguiente1 = fila1 + num1 / nHilos1;

                        if (i < repartir1) {
                            ++siguiente1;
                        }
                        hilo1[i] = new SumaMatriz(mA1, mB1, mRes1, fila1, siguiente1);
                        hilo1[i].start();
                        fila = siguiente1;

                    }

                    //hilos acaben
                    for (int i = 0; i < nHilos1; i++) {
                        try {
                            hilo1[i].join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("\n");

                    System.out.println("Resultado suma: \n");
                    for (int i = 0; i < mRes1.length; i++) {
                        for (int j = 0; j < mRes1.length; j++) {

                            System.out.print("|" + mRes1[i][j]);

                        }
                        System.out.println("\n");
                    }

                    tiempoFinal12 = System.currentTimeMillis() - tiempoInicio12;
                    System.out.println("tiempo final " + tiempoFinal12 + " milisegundos");

                    System.out.println("\n " + " ----- Tiempos de ejecucion -----");

                    System.out.println("Sin hilos: " + tiempoFinal2 + " milisegundos");
                    System.out.println("Con hilos: " + tiempoFinal12 + " milisegundos");
                    break;
//----------------------------------------------------------------------------------------------------------
                case 3:

                    long tiempoInicio3,
                     tiempoFinal3,
                     tiempoInicio13,
                     tiempoFinal13;
                    int num2 = 2000;
                    System.out.println("tamaño" + num2);

                    int mA2[][] = new int[num2][num2];
                    int mB2[][] = new int[num2][num2];
                    int mRes2[][] = new int[num2][num2];

                    System.out.println(" ----- Matriz A ----- ");
                    for (int i = 0; i < mA2.length; i++) {
                        for (int j = 0; j < mA2.length; j++) {

                            mA2[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mA2[i][j]);

                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    System.out.println(" ----- Matriz B ----- ");
                    for (int i = 0; i < mB2.length; i++) {
                        for (int j = 0; j < mB2.length; j++) {

                            mB2[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mB2[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    tiempoInicio3 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio3 + " milisegundos");

                    System.out.println(" ----- Respuesta sin hilos -----");

                    for (int i = 0; i < num2; i++) {
                        for (int j = 0; j < num2; j++) {
                            mRes2[i][j] = mA2[i][j] + mB2[i][j];
                            System.out.print("|" + mRes2[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }

                    tiempoFinal3 = System.currentTimeMillis() - tiempoInicio3;
                    System.out.println(tiempoFinal3 + " milisegundos");
                    System.out.println("\n");

                    //hilos
                    System.out.println("Ingrese el numero de hilos");
                    int nHilos2 = sn.nextInt();

                    tiempoInicio13 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio13 + " milisegundos");

                    int repartir2 = num2 % nHilos2;

                    SumaMatriz[] hilo2 = new SumaMatriz[nHilos2];
                    int fila2 = 0;
                    int siguiente2;

                    for (int i = 0; i < nHilos2; i++) {

                        siguiente2 = fila2 + num2 / nHilos2;

                        if (i < repartir2) {
                            ++siguiente2;
                        }
                        hilo2[i] = new SumaMatriz(mA2, mB2, mRes2, fila2, siguiente2);
                        hilo2[i].start();
                        fila2 = siguiente2;

                    }

                    //hilos acaben
                    for (int i = 0; i < nHilos2; i++) {
                        try {
                            hilo2[i].join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("\n");

                    System.out.println("Resultado suma: \n");
                    for (int i = 0; i < mRes2.length; i++) {
                        for (int j = 0; j < mRes2.length; j++) {

                            System.out.print("|" + mRes2[i][j]);

                        }
                        System.out.println("\n");
                    }

                    tiempoFinal13 = System.currentTimeMillis() - tiempoInicio13;
                    System.out.println("Tiempo finalizacion" + tiempoFinal13 + " milisegundos");

                    System.out.println("\n " + " ----- Tiempos de ejecucion -----");

                    System.out.println("Sin hilos: " + tiempoFinal3 + " milisegundos");
                    System.out.println("Con hilos: " + tiempoFinal13 + " milisegundos");
                    break;

                case 4:

                    long tiempoInicio4,
                     tiempoFinal4,
                     tiempoInicio14,
                     tiempoFinal14;
                    int num3 = 3000;
                    System.out.println("tamaño" + num3);

                    int mA3[][] = new int[num3][num3];
                    int mB3[][] = new int[num3][num3];
                    int mRes3[][] = new int[num3][num3];

                    System.out.println(" ----- Matriz A ----- ");
                    for (int i = 0; i < mA3.length; i++) {
                        for (int j = 0; j < mA3.length; j++) {

                            mA3[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mA3[i][j]);

                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    System.out.println(" ----- Matriz B ----- ");
                    for (int i = 0; i < mB3.length; i++) {
                        for (int j = 0; j < mB3.length; j++) {

                            mB3[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mB3[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    tiempoInicio4 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio4 + " milisegundos");

                    System.out.println(" ----- Respuesta sin hilos -----");

                    for (int i = 0; i < num3; i++) {
                        for (int j = 0; j < num3; j++) {
                            mRes3[i][j] = mA3[i][j] + mB3[i][j];
                            System.out.print("|" + mRes3[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }

                    tiempoFinal4 = System.currentTimeMillis() - tiempoInicio4;
                    System.out.println("Tiempo finalizacion" + tiempoFinal4 + " milisegundos");
                    System.out.println("\n");

                    //hilos
                    System.out.println("Ingrese el numero de hilos");
                    int nHilos3 = sn.nextInt();

                    tiempoInicio14 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio14 + " milisegundos");

                    int repartir3 = num3 % nHilos3;

                    SumaMatriz[] hilo3 = new SumaMatriz[nHilos3];
                    int fila3 = 0;
                    int siguiente3;

                    for (int i = 0; i < nHilos3; i++) {

                        siguiente3 = fila3 + num3 / nHilos3;

                        if (i < repartir3) {
                            ++siguiente3;
                        }
                        hilo3[i] = new SumaMatriz(mA3, mB3, mRes3, fila3, siguiente3);
                        hilo3[i].start();
                        fila = siguiente3;

                    }

                    //hilos acaben
                    for (int i = 0; i < nHilos3; i++) {
                        try {
                            hilo3[i].join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("\n");

                    System.out.println("Resultado suma: \n");
                    for (int i = 0; i < mRes3.length; i++) {
                        for (int j = 0; j < mRes3.length; j++) {

                            System.out.print("|" + mRes3[i][j]);

                        }
                        System.out.println("\n");
                    }

                    tiempoFinal14 = System.currentTimeMillis() - tiempoInicio14;
                    System.out.println("Tiempo finalizacion" + tiempoFinal14 + " milisegundos");

                    System.out.println("\n " + " ----- Tiempos de ejecucion -----");

                    System.out.println("Sin hilos: " + tiempoFinal4 + " milisegundos");
                    System.out.println("Con hilos: " + tiempoFinal14 + " milisegundos");
                    break;
//-----------------------------------------------------------------------------------------------------------------------
                case 5:

                    long tiempoInicio5,
                     tiempoFinal5,
                     tiempoInicio15,
                     tiempoFinal15;
                    int num4 = 4000;
                    System.out.println("tamaño" + num4);

                    int mA4[][] = new int[num4][num4];
                    int mB4[][] = new int[num4][num4];
                    int mRes4[][] = new int[num4][num4];

                    System.out.println(" ----- Matriz A ----- ");
                    for (int i = 0; i < mA4.length; i++) {
                        for (int j = 0; j < mA4.length; j++) {

                            mA4[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mA4[i][j]);

                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    System.out.println(" ----- Matriz B ----- ");
                    for (int i = 0; i < mB4.length; i++) {
                        for (int j = 0; j < mB4.length; j++) {

                            mB4[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mB4[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    tiempoInicio5 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio5 + " milisegundos");

                    System.out.println(" ----- Respuesta sin hilos -----");

                    for (int i = 0; i < num4; i++) {
                        for (int j = 0; j < num4; j++) {
                            mRes4[i][j] = mA4[i][j] + mB4[i][j];
                            System.out.print("|" + mRes4[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }

                    tiempoFinal5 = System.currentTimeMillis() - tiempoInicio5;
                    System.out.println("Tiempo finalizacion " + tiempoFinal5 + " milisegundos");
                    System.out.println("\n");

                    //hilos
                    System.out.println("Ingrese el numero de hilos");
                    int nHilos4 = sn.nextInt();

                    tiempoInicio15 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio15 + " milisegundos");

                    int repartir4 = num4 % nHilos4;

                    SumaMatriz[] hilo4 = new SumaMatriz[nHilos4];
                    int fila4 = 0;
                    int siguiente4;

                    for (int i = 0; i < nHilos4; i++) {

                        siguiente4 = fila4 + num4 / nHilos4;

                        if (i < repartir4) {
                            ++siguiente4;
                        }
                        hilo4[i] = new SumaMatriz(mA4, mB4, mRes4, fila4, siguiente4);
                        hilo4[i].start();
                        fila4 = siguiente4;

                    }

                    //hilos acaben
                    for (int i = 0; i < nHilos4; i++) {
                        try {
                            hilo4[i].join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("\n");

                    System.out.println("Resultado suma: \n");
                    for (int i = 0; i < mRes4.length; i++) {
                        for (int j = 0; j < mRes4.length; j++) {

                            System.out.print("|" + mRes4[i][j]);

                        }
                        System.out.println("\n");
                    }

                    tiempoFinal15 = System.currentTimeMillis() - tiempoInicio15;
                    System.out.println("Tiempo finalizacion " + tiempoFinal15 + " milisegundos");

                    System.out.println("\n " + " ----- Tiempos de ejecucion -----");

                    System.out.println("Sin hilos: " + tiempoFinal5 + " milisegundos");
                    System.out.println("Con hilos: " + tiempoFinal15 + " milisegundos");
                    break;
//-----------------------------------------------------------------------------------------------------------------------
                case 6:

                    long tiempoInicio6,
                     tiempoFinal6,
                     tiempoInicio16,
                     tiempoFinal16;
                    int num5 = 5000;
                    System.out.println("tamaño" + num5);

                    int mA5[][] = new int[num5][num5];
                    int mB5[][] = new int[num5][num5];
                    int mRes5[][] = new int[num5][num5];

                    System.out.println(" ----- Matriz A ----- ");
                    for (int i = 0; i < mA5.length; i++) {
                        for (int j = 0; j < mA5.length; j++) {

                            mA5[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mA5[i][j]);

                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    System.out.println(" ----- Matriz B ----- ");
                    for (int i = 0; i < mB5.length; i++) {
                        for (int j = 0; j < mB5.length; j++) {

                            mB5[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mB5[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    tiempoInicio6 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio6 + " milisegundos");

                    System.out.println(" ----- Respuesta sin hilos -----");

                    for (int i = 0; i < num5; i++) {
                        for (int j = 0; j < num5; j++) {
                            mRes5[i][j] = mA5[i][j] + mB5[i][j];
                            System.out.print("|" + mRes5[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }

                    tiempoFinal6 = System.currentTimeMillis() - tiempoInicio6;
                    System.out.println("Tiempo finalizacion " + tiempoFinal6 + " milisegundos");
                    System.out.println("\n");

                    //hilos
                    System.out.println("Ingrese el numero de hilos");
                    int nHilos5 = sn.nextInt();

                    tiempoInicio16 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio16 + " milisegundos");

                    int repartir5 = num5 % nHilos5;

                    SumaMatriz[] hilo5 = new SumaMatriz[nHilos5];
                    int fila5 = 0;
                    int siguiente5;

                    for (int i = 0; i < nHilos5; i++) {

                        siguiente5 = fila5 + num5 / nHilos5;

                        if (i < repartir5) {
                            ++siguiente5;
                        }
                        hilo5[i] = new SumaMatriz(mA5, mB5, mRes5, fila5, siguiente5);
                        hilo5[i].start();
                        fila = siguiente5;

                    }

                    //hilos acaben
                    for (int i = 0; i < nHilos5; i++) {
                        try {
                            hilo5[i].join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("\n");

                    System.out.println("Resultado suma: \n");
                    for (int i = 0; i < mRes5.length; i++) {
                        for (int j = 0; j < mRes5.length; j++) {

                            System.out.print("|" + mRes5[i][j]);

                        }
                        System.out.println("\n");
                    }

                    tiempoFinal16 = System.currentTimeMillis() - tiempoInicio16;
                    System.out.println("Tiempo finalizacion " + tiempoFinal16 + " milisegundos");

                    System.out.println("\n " + " ----- Tiempos de ejecucion -----");

                    System.out.println("Sin hilos: " + tiempoFinal6 + " milisegundos");
                    System.out.println("Con hilos: " + tiempoFinal16 + " milisegundos");
                    break;
//-----------------------------------------------------------------------------------------------------------------------
                case 7:

                    long tiempoInicio7,
                     tiempoFinal7,
                     tiempoInicio17,
                     tiempoFinal17;

                    System.out.println("Ingrese el valor de la matriz cuadrada \n");
                    int num6 = sn.nextInt();
                    System.out.println("tamaño" + num6);

                    int mA6[][] = new int[num6][num6];
                    int mB6[][] = new int[num6][num6];
                    int mRes6[][] = new int[num6][num6];

                    System.out.println(" ----- Matriz A ----- ");
                    for (int i = 0; i < mA6.length; i++) {
                        for (int j = 0; j < mA6.length; j++) {

                            mA6[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mA6[i][j]);

                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    System.out.println(" ----- Matriz B ----- ");
                    for (int i = 0; i < mB6.length; i++) {
                        for (int j = 0; j < mB6.length; j++) {

                            mB6[i][j] = (int) (Math.random() * 10);
                            System.out.print("|" + mB6[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }
                    System.out.println("\n");

                    tiempoInicio7 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio7 + " milisegundos");

                    System.out.println(" ----- Respuesta sin hilos -----");

                    for (int i = 0; i < num6; i++) {
                        for (int j = 0; j < num6; j++) {
                            mRes6[i][j] = mA6[i][j] + mB6[i][j];
                            System.out.print("|" + mRes6[i][j]);
                        }
                        System.out.println("|" + "\n");
                    }

                    tiempoFinal7 = System.currentTimeMillis() - tiempoInicio7;
                    System.out.println(tiempoFinal7 + " milisegundos");
                    System.out.println("\n");

                    //hilos
                    System.out.println("Ingrese el numero de hilos");
                    int nHilos6 = sn.nextInt();

                    tiempoInicio17 = System.currentTimeMillis();
                    System.out.println("Tiempo de inicio " + tiempoInicio17 + " milisegundos");

                    int repartir6 = num6 % nHilos6;

                    SumaMatriz[] hilo6 = new SumaMatriz[nHilos6];
                    int fila6 = 0;
                    int siguiente6;

                    for (int i = 0; i < nHilos6; i++) {

                        siguiente6 = fila6 + num6 / nHilos6;

                        if (i < repartir6) {
                            ++siguiente6;
                        }
                        hilo6[i] = new SumaMatriz(mA6, mB6, mRes6, fila6, siguiente6);
                        hilo6[i].start();
                        fila6 = siguiente6;

                    }

                    //hilos acaben
                    for (int i = 0; i < nHilos6; i++) {
                        try {
                            hilo6[i].join();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("\n");

                    System.out.println("Resultado suma: \n");
                    for (int i = 0; i < mRes6.length; i++) {
                        for (int j = 0; j < mRes6.length; j++) {

                            System.out.print("|" + mRes6[i][j]);

                        }
                        System.out.println("\n");
                    }

                    tiempoFinal17 = System.currentTimeMillis() - tiempoInicio17;
                    System.out.println("Tiempo finalizacion" + tiempoFinal17 + " milisegundos");

                    System.out.println("\n " + " ----- Tiempos de ejecucion -----");

                    System.out.println("Sin hilos: " + tiempoFinal7 + " milisegundos");
                    System.out.println("Con hilos: " + tiempoFinal17 + " milisegundos");
                    break;

//-----------------------------------------------------------------------------------------------------------------------                
                case 8:
                    salir = true;
                    break;
            }
        }

    }

}
