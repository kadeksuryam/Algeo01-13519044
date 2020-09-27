import java.util.InputMismatchException;
import java.util.Scanner;



public class Main{
    static Scanner sc = new Scanner(System.in);
    static Scanner file = new Scanner(System.in);
    public static Matrix input;
    public static double hasilDeterminan;
    public static int metodeDeterminan;
    public static int metodeSPL;
    public static int metodeInverse;
    public static double yTaksiran;
    public static void main(String[] args){
        mainMenu();
    }
    public static void mainMenu(){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU");
                System.out.println("1. Sistem Persamaan Linier");
                System.out.println("2. Determinan");
                System.out.println("3. Matriks balikan");
                System.out.println("4. Interpolasi Polinom");
                System.out.println("5. Regresi linier berganda");
                System.out.println("6. Keluar");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 6) throw new Exception();
                else{
                    switch(selection){
                        case 1:{
                            splMenu();
                            break;
                        }
                        case 2:{
                            determinanMenu();
                            break;
                        }
                        case 3:{
                            inverseOfMatrixMenu();
                            break;
                        }
                        case 4:{
                            //tidak perlu submenu, langsung ke metode input
                            break;
                        }
                        case 5:{
                            inputMenu("Regresi Linier Berganda");
                            break;
                        }
                        case 6:{
                            System.exit(0);
                            break;
                        }
                    }
                    mainMenu();
                }
            }
            catch(InputMismatchException e){
                sc.next();
                System.out.println("Masukan haruslah sebuah angka!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                mainMenu();
                return;
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 6!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                mainMenu();
                return;
            }
        }

    }
    //submenu SPL
    public static void splMenu(){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU Sistem Persamaan Linier");
                System.out.println("1. Metode eliminasi Gauss");
                System.out.println("2. Metode eliminasi Gauss-Jordan");
                System.out.println("3. Metode matriks balikan");
                System.out.println("4. Kaidah Cramer");
                System.out.println("5. Balik ke Main Menu");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 5) throw new Exception();
                else{
                    switch (selection){
                        case 1:{
                            metodeSPL = 1;
                            inputMenu("SPL");
                            break;
                        }
                        case 2:{
                            metodeSPL = 2;
                            inputMenu("SPL");
                            break;
                        }
                        case 3:{
                            metodeSPL = 3;
                            inputMenu("SPL");
                            break;
                        }
                        case 4:{
                            metodeSPL = 4;
                            inputMenu("SPL");
                            break;
                        }
                        case 5:{
                            mainMenu();
                            break;
                        }
                    }
                }
            }
            catch(InputMismatchException e){
                sc.next();
                System.out.println("Masukan haruslah sebuah angka!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                determinanMenu();
                return;
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 5!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                determinanMenu();
                return;
            }
            return;
        }
    }

    //submenu determinan
    public static void determinanMenu(){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU Determinan");
                System.out.println("1. Determinan Metode Reduksi");
                System.out.println("2. Determinan Metode Kofaktor");
                System.out.println("3. Balik ke Main Menu");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 3)  throw new Exception();
                else{
                    switch (selection){
                        case 1:{
                            metodeDeterminan = 1;
                            inputMenu("Determinan");
                            break;
                        }
                        case 2:{
                            metodeDeterminan = 2;
                            inputMenu("Determinan");
                            break;
                        }
                        default:{
                            mainMenu();
                            break;
                        }
                    }
                }
            }
            catch(InputMismatchException e){
                sc.next();
                System.out.println("Masukan haruslah sebuah angka!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                determinanMenu();
                return;
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 4!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                determinanMenu();
                return;
            }
            return;
        }
    }
    
    //submenu matriks balikan
    public static void inverseOfMatrixMenu(){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU matriks inverse");
                System.out.println("1. Matriks inverse dengan metode OBE");
                System.out.println("2. Matriks inverse dengan metode adjoin");
                System.out.println("3. Balik ke Main Menu");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 3) throw new Exception();
                else{
                    switch (selection){
                        case 1:{
                            metodeInverse = 1;
                            inputMenu("Matriks Balikan");
                            break;
                        }
                        case 2:{
                            metodeInverse = 2;
                            inputMenu("Matriks Balikan");
                            break;
                        }
                        default:{
                            mainMenu();
                            break;
                        }
                    }
                }
            }
            catch(InputMismatchException e){
                sc.next();
                System.out.println("Masukan haruslah sebuah angka!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                determinanMenu();
                return;
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 3!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                determinanMenu();
                return;
            }
            return;
        }
    }

    //interpolasi dan regresi tidak perlu submenu

    
    //metode input dan output
    public static void inputMenu(String operasi){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("Menu metode masukan " + operasi);
                System.out.println("1. Baca dari File");
                System.out.println("2. Baca dari Konsol");
                System.out.println("3. Balik ke Main Menu");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 3) throw new Exception();
                else{
                    input = new Matrix();
                    hasilDeterminan = 0.0;
                    switch (selection){
                        case 1:{
                           System.out.println("Masukkan nama File (tanpa .txt di belakang): ");
                           String fileName =  file.nextLine();
                            switch(operasi){
                                case "SPL":{
                                     //masukan dari file berupa matriks augmented
                                     input.readMatrixFromFile(fileName);
                                     if(!input.isFileExist){
                                         inputMenu(operasi);
                                         return;
                                     }
                                    outputMenu("SPL");
                                    break;
                                }
                                case "Determinan":{
                                    //masukan berupa matriks yang dipisahkan spasi
                                    input.readMatrixFromFile(fileName);
                                    if(!input.isFileExist){
                                        inputMenu(operasi);
                                        return;
                                    }
                                    if(metodeDeterminan == 1) hasilDeterminan = input.determinantByReduction();
                                    else hasilDeterminan = input.determinantByCofactor();    
                                    outputMenu("Determinan");
                                    break;
                                }
                                case "Matriks Balikan":{
                                    //sama seperti determinan
                                    input.readMatrixFromFile(fileName);
                                    if(!input.isFileExist){
                                        inputMenu(operasi);
                                        return;
                                    }
                                    if(metodeInverse == 1) input = input.inverseByAugment();
                                    else if(metodeInverse == 2) input = input.inverseByCofactor();
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //masukan berupa titik" yang dipisahkan oleh baris
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    //titik" dinyatakan setiap baris
                                    break;
                                }
                            }
                            break;
                        }
                        case 2:{
                            switch(operasi){
                                case "SPL":{
                                    // Masukan dari keyboard berupa m n, koefisien a_i_j dan b_i
                                    //input
                                    int nRow, nCol;
                                    nRow = sc.nextInt();
                                    nCol = sc.nextInt();
                                    input.readMatrixFromConsole(nRow, nCol);
                                    //proses
                                    
                                    //output
                                    outputMenu("SPL");
                                    break;
                                }
                                case "Determinan":{
                                    //  Masukan dari keyboard berupa n, koefisien a_i_j, setiap elemen
                                    // dipisahkan oleh spasi

                                    //input
                                    int nRow;
                                    nRow = sc.nextInt();
                                    //matriks persegi
                                    input.readMatrixFromConsole(nRow, nRow);

                                    //proses
                                    if(metodeDeterminan == 1) hasilDeterminan =  input.determinantByReduction();
                                    else hasilDeterminan = input.determinantByCofactor();    

                                    //output
                                    outputMenu("Determinan");
                                    break;
                                }
                                case "Matriks Balikan":{
                                    //sama seperti determinan
                                    
                                    //input
                                    int nRow;
                                    nRow = sc.nextInt();
                                    //matriks persegi
                                    input.readMatrixFromConsole(nRow, nRow);

                                    //proses
                                    if(metodeInverse == 1) input = input.inverseByAugment();
                                    else if(metodeInverse == 2) input = input.inverseByCofactor();

                                    //output
                                    outputMenu("Matriks Balikan");
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //Masukan dari keyboard berupa n, (x0, y0), (x1, y1) ..(xn, yn)
                                    int banyakTitik;
                                    //input
                                    banyakTitik = sc.nextInt();
                                    //build an augmented matrix
                                    Matrix interpolasiMatrix = new Matrix(banyakTitik, banyakTitik+1);
                                    for(int i=0;i<banyakTitik;i++){
                                        double x,y;
                                        x = sc.nextInt();
                                        y = sc.nextInt();
                                        int j;
                                        for(j=0;j<banyakTitik;j++){
                                            interpolasiMatrix.getMatrix()[i][j] = x*power(x, j);
                                        }
                                        interpolasiMatrix.getMatrix()[i][j] = y;
                                    }
                                    //input nilai yang ingin ditaksir
                                    double xTaksiran = sc.nextDouble();
                                    //proses
                                    yTaksiran = interpolasiMatrix.interpolasi(interpolasiMatrix, xTaksiran);
                                    //output
                                    outputMenu("Interpolasi Polinom");
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    //masukan dari keyboard berupa n, x1i, x2i .. xni, nilai yi
                                    //dan nilai xk yang akan ditaksir nilainya
                                    //input
                                    int m, n;
                                    System.out.print("Masukkan n (banyak peubah x per sampel): ");
                                    n = sc.nextInt();
                                    System.out.print("Masukkan m (banyak sampel): ");
                                    m = sc.nextInt();
                                    //Masukkan m baris data berisi n peubah x dan nilai y pada masing-masing baris
                                    Matrix dataRegresi = new Matrix(m, n+1);
                                    dataRegresi.readMatrixFromConsole(m, n+1);
                                    //Masukkan sebaris n peubah  yang ingin ditaksir y nya
                                    System.out.print("Masukkan x1 sampai xn yang akan ditaksir y-nya: ");
                                    Matrix dataTaksir = new Matrix(1, n);
                                    dataTaksir.readMatrixFromConsole(1,n);
                                    //proses
                                    //Gabungkan dengan 1 di kiri x1 sebagai koefisien B0
                                    Matrix augmentLeft = new Matrix(1);
                                    Matrix augmented = augmentLeft.augmentRight(dataTaksir);
                                    //Buat SPLnya
                                    Matrix SPLRegresi = dataRegresi.regressionSPL();
                                    //Matrix hasil berbentuk matrix (n+1)x1 yang berupa nilai B0 hingga Bn
                                    Matrix hasil = SPLRegresi.solusiCrammer();
                                    //y taksir adalah B0 + B1*x1 + ... + Bn*xn sehingga dapat diperoleh dengan mengalikan matrix
                                    Matrix yTaksir = augmented.dotProduct(hasil);
                                    yTaksiran = yTaksir.getMatrix()[0][0];
                                    //ouput
                                    outputMenu("Regresi Linier Berganda");
                                    break;
                                }
                            }
                            break;
                        }
                        case 3:{
                            mainMenu();
                            break;
                        }
                    }
                    
                }
            }
            catch(InputMismatchException e){
                sc.next();
                System.out.println("Masukan haruslah sebuah angka!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                inputMenu(operasi);
                return;
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 3!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                inputMenu(operasi);
                return;
            }
            return;
        }
    }
    public static double power(double a, int b){
        double ans = 1.0;
        for(int i=0;i<b;i++){
            ans *= a;
        }
        return ans;
    }
    public static void outputMenu(String operasi){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU metode keluaran " + operasi);
                System.out.println("1. Tulis hasil ke dalam file");
                System.out.println("2. Tulis hasil di konsol");
                System.out.println("3. Balik ke menu input/sebelumnya");
                System.out.println("4. Balik ke main menu");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 4) throw new Exception();
                else{
                    switch (selection){
                        case 1:{
                            //output ke file
                             switch (operasi){
                                case "SPL":{
                                    System.out.println("Masukkan nama file (tanpa .txt): ");
                                    String fileName = sc.nextLine();
                                    input.outputMatrixFromFile(fileName);
                                    break;
                                }
                                case "Determinan":{
                                    //perlu prosedur float ke file
                                    break;
                                }
                                case "Matriks Balikan":{
                                    System.out.println("Masukkan nama file (tanpa .txt): ");
                                    String fileName = sc.nextLine();
                                    input.outputMatrixFromFile(fileName);
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //perlu float ke file
                                    //luaran berupa persamaan dan nilai taksiran
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    //perlu float ke file
                                    //luaran berupa persamaan dan nilai taksiran
                                    break;
                                }
                            }                           
                            break;
                        }
                        case 2:{
                            //output ke konsol
                            switch (operasi){
                                case "SPL":{
                                    //dalam persamaan parameter atau konstanta atau tidak ada solusi
                                    int nRow = input.getNRow();
                                    int nCol = input.getNCol();
                                    if(metodeSPL == 1){
                                        input.eliminasiGauss();
                                        boolean solusiBanyak = (nCol-1 > nRow);
                                        boolean tidakAdaSolusi = true;
                                        for(int row=0;row<nCol-1 && row < nRow;row++){
                                            if(input.getMatrix()[row][row] == 0.0) solusiBanyak = true;
                                            else if(input.getMatrix()[row][row] == 1.0){
                                                if(input.getMatrix()[row][nCol-1] == 0.0){
                                                    for(int col=row+1;col<nCol-2;col++){
                                                        if(input.getMatrix()[row][col] != 0.0) tidakAdaSolusi = false;
                                                    }
                                                }
                                                else tidakAdaSolusi = false;
                                            }
                                        }
                                        if(solusiBanyak){
                                            System.out.println("Solusi ada banyak!");
                                            System.out.println("Berikut solusinya dalam persamaan parametrik");
                                            input.eliminasiGaussJordan();

                                            double[] valVar = new double[nCol+1];
                                            boolean[] isParametric = new boolean[nCol+1];
                                            for(int col=0;col<nCol;col++){ isParametric[col] = false; valVar[col] = input.getMatrix()[nRow-1][nCol-1];}
                                            for(int col=0;col<nCol-1;col++){
                                                boolean parametric = true;
                                                for(int row=0;row<nRow;row++){
                                                    if(input.getMatrix()[row][col] == 1.0) parametric=false;
                                                }
                                                if(parametric){
                                                    System.out.println("x" + (col+1) + " = semua bilangan real");
                                                    isParametric[col] = parametric;
                                                }
                                            }
                                            for(int row=nRow-1;row>=0;row--){
                                               // boolean isFoundOne = false;
                                                double valLast = input.getMatrix()[row][nCol-1];
                                                for(int col=0;col<nCol;col++){
                                                    if(input.getMatrix()[row][col] == 1.0){
                                                     //   isFoundOne = true;
                                                        boolean isFirstFound = false;
                                                        System.out.print("x" + (col+1) + " = ");
                                                        for(int tmpCol=col+1;tmpCol<nCol;tmpCol++){
                                                            double valTmp = input.getMatrix()[row][tmpCol];
                                                            if(input.getMatrix()[row][tmpCol] != 0.0){
                                                                if(isParametric[tmpCol]) isParametric[col] = true;
                                                                if(!isParametric[tmpCol]) valVar[nCol-1] -= valVar[tmpCol]*valTmp;
                                                            }
                                                            if(tmpCol == nCol-1 && isParametric[col]){
                                                                if(valLast != 0.0){ System.out.println(" + " + valLast);}
                                                                else System.out.println("");
                                                            }
                                                            if(isParametric[col] && tmpCol != nCol-1 && valTmp != 0.0){   
                                                                if(!isFirstFound){
                                                                    if(valTmp == 1.0) System.out.print("x" + (tmpCol+1));
                                                                    else System.out.print(-1*valTmp + "x" + (tmpCol+1));
                                                                    isFirstFound = true;
                                                                }
                                                                else{
                                                                    if(valTmp == 1.0) System.out.print(" + " + "x" + (tmpCol+1));
                                                                    else System.out.print(" + " + -1*valTmp + "x" + (tmpCol+1)); 
                                                                }
                                                            }
                                                        }
                                                        if(!isParametric[col]) System.out.println(valLast);
                                                        col = nCol;
                                                    }
                                                }
                                            }
                                        }
                                        else if(tidakAdaSolusi){
                                            System.out.println("SPL tersebut tidak memiliki solusi");
                                        }
                                        else{
                                            System.out.println("SPL tersebut memiliki satu solusi unik yaitu: ");
                                        }
                                        input.printMatrix();
                                    }
                                    else if(metodeSPL == 2){
                                        input.eliminasiGaussJordan();
                                        System.out.println("Berikut matrix setelah dilakukan eliminasi Gauss Jordan");
                                        input.printMatrix();
                                        input.solutionFromGaussJordan();
                                    }
                                    break;
                                }
                                case "Determinan":{
                                    //output sesuai persoalan masing"
                                    System.out.println("Determinan matriks tersebut adalah " + hasilDeterminan + "\n");
                                    break;
                                }
                                case "Matriks Balikan":{
                                    //output sesuai persoalan masing"
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //persamaan polinom dan taksiran
                                    System.out.println("Nilai taksiran dari titik tersebut adalah " + yTaksiran + "\n");
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    System.out.println("Nilai taksiran y dari n buah peubah tersebut adalah " + yTaksiran + "\n");
                                    break;
                                }
                            }
                            System.out.print("Tekan enter untuk melanjutkan...");
                            try{
                                System.in.read();
                            } catch(Exception exKey){}
                            break;
                        }
                        case 3:{
                            inputMenu(operasi);
                            break;
                        }
                        case 4:{
                            mainMenu();
                            break;
                        }
                    }
                    return;
                }
            }
            catch(InputMismatchException e){
                sc.next();
                System.out.println("Masukan haruslah sebuah angka!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                outputMenu(operasi);
                return;
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 4!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
                outputMenu(operasi);
                return;
            }
        }
    }

}