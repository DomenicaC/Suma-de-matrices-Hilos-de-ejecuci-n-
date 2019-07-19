/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.principal;

/**
 *
 * @author Domenica Cañizares
 */
public class SumaMatriz extends Thread {

    private final int[][] matrizA;
    private final int[][] matrizB;
    private final int[][] matrizRes;
    private final int minFilas;
    private final int maxFilas;

    public SumaMatriz(int[][] matrizA, int[][] matrizB, int[][] matrizRes, int minFilas, int maxFilas) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.matrizRes = matrizRes;
        this.minFilas = minFilas;
        this.maxFilas = maxFilas;
    }

    @Override
    public void run() {
        for (int i = minFilas; i < maxFilas; ++i) {
            for (int j = 0; j < matrizRes[i].length; ++j) {
                matrizRes[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
    }

}
