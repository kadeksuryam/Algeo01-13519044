import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
        for(int row=0;row<nRow;row++){
            for(int col=0;col<nCol;col++) matrix[row][col] = 0;
        }
    }

    public void readMatrixFromFile(String fileName){
        //try to find the desired file
        try{
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
       //      scFile.close();
        } catch(FileNotFoundException ex){
            //in case file is not found
            System.out.println("Nama file yang anda masukkan salah atau tidak ada file yang dimaksud di folder test!");
        }

    }

    public void outputMatrixFromFile(String fileName){
        //try to find desired output file
        try{
            BufferedWriter fileWriter =  new BufferedWriter(new FileWriter("../test/"+ fileName + ".txt"));
            for(int row=0;row<this.nRow;row++){
                for(int col=0;col<this.nCol;col++){
                    if(col != this.nCol-1) fileWriter.write(String.valueOf(matrix[row][col])+ " ");
                    else fileWriter.write(String.valueOf(matrix[row][col]));
                }
                fileWriter.newLine();
            }
            fileWriter.flush();
            fileWriter.close();

        } catch(Exception ex){
            System.out.println("Error");
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
        for(int row=0;row<this.nRow;row++){
            for(int col=0;col<this.nCol;col++){
                if(col == this.nCol-1) System.out.println(matrix[row][col]);
                else System.out.print(matrix[row][col] + " ");
            }
        }
    }
    
    public void transpose(){
        int nRow = this.nCol;
        int nCol = this.nRow;
        double[][] tmpMatrix = new double[nRow][nCol];
        for(int row=0;row<nRow;row++){
            for(int col=0;col<nCol;col++){
                tmpMatrix[row][col] = this.matrix[col][row];
            }
        }
        this.matrix= new double[nRow][nCol];
        this.nRow = nRow;
        this.nCol = nCol;
        //copy tmpMatrix to class's matrix
        for(int row=0;row<nRow;row++){
            for(int col=0;col<nCol;col++){
                this.matrix[row][col] = tmpMatrix[row][col];
            }
        }
    }
    public void swapRow(int originRow, int destRow){

    }
    public void swapCol(int originCol, int destRow){

    }
    public Matrix dotProduct(Matrix origin){
        //dot product class's matrix with origin matrix (right side)
        //assume origin matrix has right dimension
        int nRow = this.nRow;
        int nCol = this.nCol;
        Matrix dotResult = new Matrix(nRow, origin.nCol);
        for(int row=0;row<nRow;row++){
            for(int col=0;col<dotResult.nCol;col++){
                for(int tmpCol=0;tmpCol<nCol;tmpCol++){
                    dotResult.matrix[row][col] += this.matrix[row][tmpCol]*origin.matrix[tmpCol][col];
                }
            }
        }
        return dotResult;
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