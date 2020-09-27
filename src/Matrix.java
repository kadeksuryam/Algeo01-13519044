
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
    private double epsilon = 0.000001;
    boolean isFileExist = true;
    static Scanner input = new Scanner(System.in);
    //define the constructors 
   // construct empty matrix 
    public Matrix(){
        nRow = 0;
        nCol = 0;
        matrix = new double[1][1];
    }
    //construct matrix with size nRow and nCol
    public Matrix(int nRow, int nCol){
        this.nRow = nRow;
        this.nCol = nCol;
        matrix = new double[nRow][nCol];
        //inisialisasi 0 semua (?)
        for(int row=0;row<nRow;row++){
            for(int col=0;col<nCol;col++) matrix[row][col] = 0;
        }
    }
    //construct identity matrix with size nSize
    public Matrix(int nSize){
        this.nRow = nSize;
        this.nCol = nSize;
        this.matrix = new double[nSize][nSize];
        for(int i=0; i<nSize; i++){
            for(int j=0; j<nSize; j++){
                if(i==j){
                    this.matrix[i][j]=1;
                }else{
                    this.matrix[i][j]=0;
                }
            }
        }
    }

    public void readMatrixFromFile(String fileName){
        //try to find the desired file
        try{
             //use buffer to make input more efficient, instead plain filereader
            Scanner file = new Scanner(new BufferedReader(new FileReader("test/" + fileName + ".txt")));
            //use tmpFile to determine the number of row
            Scanner tmpFile = new Scanner(new BufferedReader(new FileReader("test/" + fileName + ".txt")));
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
             isFileExist = true;
       //      scFile.close();
        } catch(FileNotFoundException ex){
            //in case file is not found
            isFileExist = false;
            System.out.println("Nama file yang anda masukkan salah atau tidak ada file yang dimaksud di folder test!");
        }

    }
    public void readMatrixFromConsole(int nRow, int nCol){
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
    public void addRowToRow(int addingRow, int addedRow, double multiplier){
        int j;
        for(j=0; j<this.nCol; j++){
            this.matrix[addedRow][j] += (multiplier * this.matrix[addingRow][j]);
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
            if(-epsilon < this.matrix[cRow][cCol] && this.matrix[cRow][cCol] < epsilon){
                while(i<this.nRow && -epsilon < this.matrix[i][cCol] && this.matrix[i][cCol] < epsilon){
                    this.matrix[i][cCol] = 0;
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
                    this.swapRow(i, cRow);
                }
                //Maka sekarang kondisinya nilai this.matrix[n][m] taknol, sehingga dapat dioperasikan OBE
                for(i=cRow+1; i<this.nRow; i++){
                    double multiplier = -this.matrix[i][cCol]/this.matrix[cRow][cCol];
                    this.addRowToRow(cRow, i, multiplier);
                }
                cRow++;
            }
        }
        return swaps;
    }
    public void eliminasiGauss(){
        int swaps = this.toTopTriangular();
        int nonZeroIdx=0;
        for(int i=0; i<this.nRow; i++){
            while(nonZeroIdx<this.nCol && -epsilon < this.matrix[i][nonZeroIdx] && this.matrix[i][nonZeroIdx] < epsilon){
                this.matrix[i][nonZeroIdx] = 0;
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
        this.eliminasiGauss();
        int leadingOne=0;
        for(int i=0; i<this.nRow; i++){
            while(leadingOne<this.nCol && -epsilon < this.matrix[i][leadingOne] && this.matrix[i][leadingOne] < epsilon){
                this.matrix[i][leadingOne] = 0;
                leadingOne++;
            }
            if(leadingOne<this.nCol){
                for(int j=0; j<i; j++){
                    this.addRowToRow(i, j, -this.matrix[j][leadingOne]);
                }
            }
        }
    }

    /* Operation with more than one Matrix */
    public Matrix augmentRight(Matrix right){
        //Precondition: this.nRow == right.nRow
        Matrix result = new Matrix(this.nRow, this.nCol + right.nCol);
        for(int i=0; i<this.nRow; i++){
            for(int j=0; j<this.nCol; j++){
                result.matrix[i][j] = this.matrix[i][j];
            }
            for(int j=0; j<right.nCol; j++){
                result.matrix[i][this.nCol + j] = right.matrix[i][j];
            }
        }
        return result;
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
    
    public Boolean isEselon(){
        for (int row = 0; row < this.nRow; row++){
            for (int col = 0; col <= row; col++){
                if (row == col){
                    if (this.matrix[row][col] != 1){
                        return false;
                    }
                }else{
                    if (this.matrix[row][col] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public Boolean isIdentityMatrix(){
        for (int row = 0; row < this.nRow; row++){
            for (int col = 0; col < this.nCol; col++){
                if (row == col){
                    if (this.matrix[row][col] != 1){
                        return false;
                    }
                }else{
                    if (this.matrix[row][col] != 0 ){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    public Boolean isSquareMatrix(){
        return (this.nRow == this.nCol);
    }
    public Boolean isRowZero(){
        for(int i=0; i<this.nRow; i++){
            boolean ret = true;
            for(int j=0; j<this.nCol; j++){
                ret = ret && (-epsilon < this.matrix[i][j] && this.matrix[i][j] < epsilon);
            }
            if(ret){
                return true;
            }
        }
        return false;
    }
    public Boolean isColZero(){
        for(int j=0; j<this.nCol; j++){
            boolean ret = true;
            for(int i=0; i<this.nRow; i++){
                ret = ret && (-epsilon < this.matrix[i][j] && this.matrix[i][j] < epsilon);
            }
            if(ret){
                return true;
            }
        }
        return false;
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
        }else{ //Apabila bukan matrix persegi
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
    public Matrix inverseByAugment(){
        //Assumption Matrix is square, however put a condition just in case
        Matrix inverse = new Matrix(this.nCol, this.nRow);
        if(this.isSquareMatrix()){
            Matrix identity = new Matrix(this.nRow);
            Matrix augment = new Matrix();
            augment = this.augmentRight(identity);
            augment.eliminasiGaussJordan();
            boolean isIdentity = true;
            for(int i=0; i<this.nRow; i++){
                if(augment.matrix[i][i] != 1){
                    isIdentity = false;
                }
            }
            if(isIdentity){
                for(int i=0; i<this.nRow; i++){
                    for(int j=0; j<this.nCol; j++){
                        inverse.matrix[i][j] = augment.matrix[i][j+this.nCol];
                    }
                }
            }
        }
        return inverse;
    }

    public double interpolasi(Matrix persamaan, double xTaksiran){
        double yTaksiran=0.0;
        //selesaikan spl dengan eliminasi gauss-jordan
        persamaan.eliminasiGauss();
        for(int row=0;row<persamaan.nRow;row++){
            yTaksiran += persamaan.matrix[row][persamaan.nRow]*power(xTaksiran, row);
        }
        return yTaksiran;
    }
    public double power(double a, int b){
        double ans = 1.0;
        for(int i=0;i<b;i++){
            ans *= a;
        }
        return ans;
    }
    public Matrix takeLastColFromAug(){
        Matrix hasil = new Matrix(this.nRow, 1);
        for (int row = 0; row < this.nRow; row++){
            hasil.matrix[row][0] = this.matrix[row][this.nCol - 1];
        }
        return hasil;
    }
    public Matrix inverseSPL(){
        Matrix temp = new Matrix();
        //potong kolom terakhir dari matriks augmented
        temp = this.cutOneCol(this.nCol-1);
        Matrix inverse = new Matrix();
        //habis itu diinverse
        inverse = temp.inverseByCofactor();
        Matrix SPL = new Matrix();
        SPL = this.takeLastColFromAug();
        //lalu bisa dapet x1,x2,...,xn dari perkalian dot inverse dengan hasil spl
        Matrix hasil = new Matrix();
        hasil = inverse.dotProduct(SPL);
        return hasil;
    }
    private double methodCrammer(Matrix sol,int col){
        Matrix temp = new Matrix();
        temp.copyMatrix(this);
        temp.replaceOneCol(sol, col);
        return temp.determinantByReduction();
    }
    public  Matrix solusiCrammer(){
        //Fungsi menerima matriks augmented berukuran nx(n+1)
        //pisah dahulu matriksnya baru bisa dilakkukan metodecrammer
        //setelah dipisah matriks akan berukuran nxn dan nx1
        Matrix asli = new Matrix();
        asli = this.cutOneCol(this.nCol-1);
        Matrix kons = new Matrix();
        kons = this.takeLastColFromAug();
        double det = asli.determinantByReduction();
        Matrix solusi = new Matrix(asli.nRow,1);
        for (int i = 0; i < asli.nCol;i++){
            double hasil = (asli.methodCrammer(kons, i) / det);
            solusi.matrix[i][0] = hasil;
        }
        return solusi;
    }

    public Matrix regressionSPL(){
        //Turns out there is a clever way to get the SPL Matrix for Double Regression
        //using adding a column to the left, cuting rightmost column, 
        //and multiply it with the transposed modified version of itself
        Matrix augmentLeft = new Matrix(this.nRow, 1);
        for(int i=0; i<this.nRow; i++){
            augmentLeft.matrix[i][0] = 1;
        }
        //Adding a column of "1"s to the left for b0 coefficients
        augmentLeft = augmentLeft.augmentRight(this);
        Matrix delRight = augmentLeft.cutOneCol(this.nCol);
        delRight.transpose();
        //multiply delright to augment left to get SPL
        Matrix SPL = delRight.dotProduct(augmentLeft);
        return SPL;
    }
    
    //Output solusi SPL
    public void solutionFromGaussJordan(){
        //Mengoutputkan solusi dengan prekondisi Matrix sudah dilakukan eliminasi GaussJordan
        int i=0;
        boolean isFirstRowZero = false;
        int[] par = new int[this.nCol];
        for(int k=0; k<this.nCol; k++){
            par[k]=-1;
        }
        int k=0;
        while(i<this.nRow && !isFirstRowZero){
            while(k<this.nCol-1 && -epsilon < this.matrix[i][k] && this.matrix[i][k] < epsilon){
                k++;
            }
            par[k] = 0;
            if(k==this.nCol-1){
                isFirstRowZero = true;
            }else{
                i++;
            }
        }
        int curpar = 1;
        for(int j=0; j<this.nCol; j++){
            if(par[j] == -1){
                par[j] = curpar;
                curpar++;
            }
        }
        if(isFirstRowZero && (this.matrix[i][this.nCol-1] < -epsilon || epsilon < this.matrix[i][this.nCol-1])){
            System.out.println("Sistem ini tidak mempunyai solusi");
        }else{
            if(i==this.nCol-1){
                System.out.println("Sistem ini memiliki tepat 1 solusi");
                for(int j=0; j<this.nRow; j++){
                    System.out.println("x"+(j+1)+" = " + (this.matrix[j][this.nCol-1]));
                }
            }else{
                //i<this.nCol-1
                System.out.println("Sistem ini memiliki banyak solusi. Berikut solusi parametrik:");
                int curRow = 0;
                int curCol = 0;
                while(curCol<this.nCol-1){
                    while(par[curCol] != 0){
                        System.out.println("x" + (curCol+1) + " = a" + par[curCol]);
                        curCol++;
                    }
                    if(curCol<this.nCol-1){
                        System.out.print("x" + (curCol+1) + " = " + (this.matrix[curRow][this.nCol-1]));
                        for(int j=curCol+1; j<this.nCol-1; j++){
                            if(par[j] != 0){
                                System.out.print(" + (" + (-this.matrix[curRow][j]) + ")a" + (par[j]));
                            }
                        }
                        System.out.println();
                        curCol++;
                        curRow++;
                    }
                }
            }
        }
    }
    public void solutionSPLInvers(){
        //Prekondisi Matrix berukuran n x (n+1), kemudian dipisahkan bagian nxn dan 
        Matrix SPL = this.cutOneCol(this.nCol-1);
        Matrix constant = this.takeLastColFromAug();
        if(SPL.determinantByReduction() == 0){
            System.out.println("SPL ini solusinya tidak tunggal, karena determinannya 0");
        }else{
            Matrix inversSPL = SPL.inverseByAugment();
            System.out.println("Invers dari SPL ini ialah");
            inversSPL.printMatrix();
            System.out.println("Sehingga diperoleh solusi");
            Matrix result = inversSPL.dotProduct(constant);
            for(int i=0; i<result.nRow; i++){
                System.out.println("x" + (i+1) + " = " + result.matrix[i][0]);
            }
        }
    }

    // for debugging
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        Matrix tes = new Matrix();
        String fileName = sc.nextLine();
        tes.readMatrixFromFile(fileName);      
        sc.close();  
    }
}