import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Matrix{
    //define the static attributes 
    private int nRow, nCol;
    private double[][] matrix;

    //define the constructors 
   // construct empty matrix 
    public Matrix(){
        nRow = 0;
        nCol = 0;
        matrix = new double[1][1];
    }
    //contsruct matrix with size nRow and nCol
    public Matrix(int nRow, int nCol){
        this.nRow = nRow;
        this.nCol = nCol;
        matrix = new double[nRow][nCol];
        //inisialisasi 0 semua (?)
    }

    public void readMatrixFromFile(){
        //try to find the desired file
        try{
            Scanner scFileName = new Scanner(System.in);
            System.out.println("Masukkan nama file: ");
            String fileName = scFileName.nextLine();
             //use buffer to make input more efficient, instead plain filereader
            Scanner file = new Scanner(new BufferedReader(new FileReader("../test/"+ fileName)));
            //use tmpFile to determine the number of row
            Scanner tmpFile = new Scanner(new BufferedReader(new FileReader("../test/"+ fileName)));
            while(tmpFile.hasNextLine()){
                if(this.nRow == 0){
                    this.nCol = (tmpFile.nextLine().trim().split(" ")).length;
                }
                else tmpFile.nextLine();
                this.nRow++;
            }
        /*
          for debugging    
            System.out.println(this.nRow);
            System.out.println(this.nCol);
        */    

            //reconstruct the matrix
            this.matrix = new double[nRow][nCol];

            while(file.hasNextLine()) {
                for (int i=0; i<(this.nRow); i++) {
                   String[] line = file.nextLine().trim().split(" ");
                   for (int j=0; j<line.length; j++) {
                      this.matrix[i][j] = Double.parseDouble(line[j]);
                   }
                }
             }
             
             //close the scanner
             scFileName.close();
             file.close();
             tmpFile.close();      
        } catch(FileNotFoundException ex){
            //in case file is not found
            System.out.println("Nama file yang anda masukkan salah atau tidak ada file yang dimaksud di folder test!\n");
        }
    }


    //define the methods
    //selectors 
    public int getNRow(){
        return this.nRow;
    }
    public int getNCol(){
        return this.nCol;
    }
    public double[][] getMatrix(){
        return this.matrix;
    }

    public void setNRow(int nRow){
        this.nRow = nRow;
    } 
    public void setNCol(int nCol){
        this.nCol = nCol;
    }
    public void copyMatrix(Matrix origin){
        int nRow = origin.getNCol();
        int nCol = origin.getNCol();
        double[][] matrix = origin.getMatrix();
        for(int row=0;row<nRow;row++){
            for(int col=0;col<nCol;col++){
                this.matrix[row][col] = matrix[row][col];
            }
        }
    }
    public void printMatrix(){
        for(int i=0;i<this.nRow;i++){
            for(int j=0;j<this.nCol;j++){
                if(j == this.nCol-1) System.out.println(matrix[i][j]);
                else System.out.print(matrix[i][j] + " ");
            }
        }
    }
    
    public void transpose(){
    }
    public void swapRow(){
    }
    public void swapCol(){
    }
    public void multiplyThisMatrix(Matrix origin){
    }
    public static Matrix createIdentityMatrix(int rowCol){
        Matrix identity = new Matrix(rowCol, rowCol);
        return identity;
    }
    public Boolean isEselon(){
        return true;
    }
    public Boolean isIdentityMatrix(){
        return true;
    }
    public Boolean isSquareMatrix(){
        return true;
    }
    public Boolean isRowZero(){
        return true;
    }
    public Boolean isColZero(){
        return true;
    }
}