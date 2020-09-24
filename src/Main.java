import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Matrix tes = new Matrix();
        tes.readMatrixFromConsole();
        tes.eliminasiGauss();
        tes.printMatrix();
        tes.eliminasiGaussJordan();
        tes.printMatrix();
    }
}