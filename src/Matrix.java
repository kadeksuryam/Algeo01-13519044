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
    boolean isFileExist = true;
    static Scanner input = new Scanner(System.in);
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
            isFileExist = false;
            System.out.println("Nama file yang anda masukkan salah atau tidak ada file yang dimaksud di folder test!");
        }

    }
    public void readMatrixFromConsole(){
        System.out.print("Banyak baris masukan: ");
        int nRow = input.nextInt();
        System.out.print("Banyak kolom masukan: ");
        int nCol = input.nextInt();
        System.out.println("Matrix masukan:");
        this.matrix = new double[nRow][nCol];
        this.nRow = nRow;
        this.nCol = nCol;
        for(int i=0; i<nRow; i++){
            for(int j=0; j<nCol; j++){
                this.matrix[i][j] = input.nextDouble();
            }
        }
     //   input.close();
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
        this.nRow = origin.getNRow();   
        this.nCol = origin.getNCol();
        double[][] matrix = origin.getMatrix();
        this.matrix = new double[this.nRow][this.nCol];
        for(int row=0; row<this.nRow; row++){
            for(int col=0; col<this.nCol; col++){
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
    //-------Basic Matrix Self Transformation-------//
    public void swapRow(int row1, int row2){
        double temp;
        for(int i=0; i<this.nCol; i++){
            temp = this.matrix[row1][i];
            this.matrix[row1][i] = this.matrix[row2][i];
            this.matrix[row2][i] = temp;
        }
    }
    public void swapCol(int col1, int col2){
        double temp;
        for(int i=0; i<this.nRow; i++){
            temp = this.matrix[i][col1];
            this.matrix[i][col1] = this.matrix[i][col2];
            this.matrix[i][col2] = temp;
        }
    }
    public void replaceOneCol(Matrix rep, int col){
        //Assumption the matrix rep has only 1 column
        for(int i=0; i<this.nRow; i++){
            this.matrix[i][col] = rep.matrix[i][0];
        }
    }
    public Matrix cutOneRow(int row){
        Matrix result = new Matrix(this.nRow-1, this.nCol);
        for(int j=0; j<this.nCol; j++){
            for(int i=0; i<row; i++){
                result.matrix[i][j] = this.matrix[i][j];
            }
            for(int i=row+1; i<this.nRow; i++){
                result.matrix[i-1][j] = this.matrix[i][j];
            }
        }
        return result;
    }
    public Matrix cutOneCol(int col){
        Matrix result = new Matrix(this.nRow, this.nCol-1);
        for(int i=0; i<this.nRow; i++){
            for(int j=0; j<col; j++){
                result.matrix[i][j] = this.matrix[i][j];
            }
            for(int j=col+1; j<this.nCol; j++){
                result.matrix[i][j-1] = this.matrix[i][j];
            }
        }
        return result;
    }
    public void transpose(){
        double[][] result = new double[this.nCol][this.nRow];
        for(int i=0;i<this.nRow;i++){
            for(int j=0;j<this.nCol;j++){
                result[j][i] = this.matrix[i][j];
            }
        }
        int temp = this.nRow;
        this.nRow = this.nCol;
        this.nCol = temp;
        this.matrix = new double[this.nRow][this.nCol];
        for(int i=0;i<this.nRow;i++){
            for(int j=0;j<this.nCol;j++){
               this.matrix[i][j] = result[i][j];
            }
        }
    }
    public void rotate180(){
        double[][] result = new double[this.nRow][this.nCol];
        for(int i=0;i<this.nRow;i++){
            for(int j=0;j<this.nCol;j++){
                result[i][j] = this.matrix[this.nRow-1-i][this.nCol-1-j];
            }
        }
        for(int i=0;i<this.nRow;i++){
            for(int j=0;j<this.nCol;j++){
               this.matrix[i][j] = result[i][j];
            }
        }
    }
    //-------Complex Matrix Self Transformation-------//
    public int toTopTriangular(){
        //Mengubah matrix menjadi seperti bentuk eselon tereduksi namun bilangan taknol terdepan tiap baris tidak harus 1
        //Dengan hanya menggunakan operasi OBE swap dan row addition
        //Mengembalikan banyaknya swap yang dilakukan
        int cRow=0;
        int cCol=0;
        int swaps = 0;
        int i, j;
        while(cRow<this.nRow && cCol<this.nCol){
            i=cRow;
            if(this.matrix[cRow][cCol]==0){
                while(i<this.nRow && this.matrix[i][cCol]==0){
                    i++;
                }
            }
            if(i==this.nRow){
                //Semua bilangan pada baris lebih besar dari n pada kolom m bernilai 0
                cCol++;
            }else{
                //Tukar baris dengan nilai taknol tersebut dengan baris ke-n ini
                if(i!=cRow){
                    swaps++;
                    swapRow(i, cRow);
                }
                //Maka sekarang kondisinya nilai this.matrix[n][m] taknol, sehingga dapat dioperasikan OBE
                for(i=cRow+1; i<this.nRow; i++){
                    double multiplier = this.matrix[i][cCol]/this.matrix[cRow][cCol];
                    for(j=cCol; j<this.nCol; j++){
                        this.matrix[i][j] -= (multiplier * this.matrix[cRow][j]);
                    }
                }
                cRow++;
            }
        }
        return swaps;
    }
    public void eliminasiGauss(){
     //   int swaps = this.toTopTriangular();
        int nonZeroIdx=0;
        for(int i=0; i<this.nRow; i++){
            while(nonZeroIdx<this.nCol && this.matrix[i][nonZeroIdx]==0){
                nonZeroIdx++;
            }
            if(nonZeroIdx<this.nCol){
                for(int j=this.nCol-1; j>=nonZeroIdx; j--){
                    this.matrix[i][j] /= this.matrix[i][nonZeroIdx];
                }
            }
        }
    }
    public void eliminasiGaussJordan(){

    }

    public void multiplyThisMatrix(Matrix origin){
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
        return (this.nRow == this.nCol);
    }
    public Boolean isRowZero(){
        return true;
    }
    public Boolean isColZero(){
        return true;
    }


    public double determinantByReduction(){
        Matrix dummy = new Matrix();
        dummy.copyMatrix(this);
        if(dummy.isSquareMatrix()){
            int swaps = dummy.toTopTriangular();
            double result = 1;
            if(swaps%2==1){
                result = -1;
            }
            for(int i=0; i<dummy.nRow; i++){
                result *= dummy.matrix[i][i];
            }
            return result;
        }else{
            return 0;
        }
        
    }
    public double minorMatrix(int x, int y){
        Matrix temp = new Matrix();
        temp.copyMatrix(this);
        temp = temp.cutOneRow(x);
        temp = temp.cutOneCol(y);
        return temp.determinantByReduction();
    }

    public Matrix cofactorMatrix(){
        Matrix cfc = new Matrix(this.nRow, this.nCol);
        int sign;
        for (int row = 0; row < this.nRow; row++){
            for (int col=0; col < this.nCol; col++){
                sign = 1 - 2*((row+col) & 1);
                cfc.matrix[row][col] = sign * this.minorMatrix(row, col); 
            }
        }
        return cfc;
    }

    public double determinantByCofactor(){
        //Menggunakan perkalian dot pada baris pertama matriks dengan baris kofaktor
        Matrix temp = new Matrix();
        temp = this.cofactorMatrix();
        double hasil = 0;
        for (int col = 0; col < this.nCol; col++){
            hasil += temp.matrix[0][col] * this.matrix[0][col];
        }
        return hasil;
    }

    public Matrix adjoinMatrix(){
        Matrix temp = new Matrix();
        temp = this.cofactorMatrix();
        temp.transpose();
        return temp;
    }

    public Matrix conMultiplyMatrix(double k){
        Matrix temp = new Matrix();
        temp.copyMatrix(this);
        for (int row = 0; row < this.nRow; row++){
            for (int col =0; col < this.nCol; col++){
                temp.matrix[row][col] *= k;
            }
        }
        return temp;
    }

    public Matrix inverseByCofactor(){
        Matrix temp = new Matrix();
        temp = this.adjoinMatrix();
        double ratio = 1/(this.determinantByCofactor());
        temp = temp.conMultiplyMatrix(ratio);
        return temp;
    }


}