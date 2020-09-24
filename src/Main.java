import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Matrix tes = new Matrix();
        tes.readMatrixFromConsole();
        double det = tes.determinantByReduction();
        System.out.println(det);
        det = tes.determinantByCofactor();
        System.out.println(det);
        Matrix invers = new Matrix();
        invers = tes.inverseByCofactor();
        invers.printMatrix();
    }
}