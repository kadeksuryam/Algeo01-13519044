import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        /* testing matriks multiplication */
        Matrix tes1 = new Matrix();
        Matrix tes2 = new Matrix();
        Matrix tes3 = new Matrix();
        Scanner scFile = new Scanner(System.in);
        System.out.print("Masukkan nama file input: ");
        String fileName = scFile.nextLine();
        tes1.readMatrixFromFile(fileName);
        System.out.print("Masukkan nama file input: ");
        fileName = scFile.nextLine();
        tes2.readMatrixFromFile(fileName);
        System.out.println(tes1.getNRow() + " " + tes1.getNCol());
        System.out.println(tes2.getNRow() + " " + tes2.getNCol());
        tes3 = tes1.dotProduct(tes2);
        System.out.print("Masukkan nama file output: ");
        fileName = scFile.nextLine();
        tes3.outputMatrixFromFile(fileName);
        scFile.close();
        System.out.println(tes3.getNRow() + " " + tes3.getNCol());
        
    }
    
}