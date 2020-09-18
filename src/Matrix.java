import java.io.File;

public class Matrix{
    /*define the static attributes */
    private int nRow, nCol;
    private double[][] matrix;

    /*define the constructor */
    public Matrix(){
        nRow = 0;
        nCol = 0;
        matrix = new double[1][1];
    }
    public Matrix(int nRow, int nCol){
        this.nRow = nRow;
        this.nCol = nCol;
        matrix = new double[nRow][nCol];
    }

    /*define the method */
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
    public void readMatrixFromConsole(){
    }
    public void readMatrixFromFile(){
    }
    public void printMatrix(){
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