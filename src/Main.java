import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main{
    public static Scanner sc = new Scanner(System.in);
    public static Scanner file = new Scanner(System.in);
    public static Scanner fileInput = new Scanner(System.in);
    public static Matrix input;
    public static Matrix sample; //Digunakan saat regresi
    public static double hasilDeterminan;
    public static int metodeDeterminan;
    public static int metodeSPL;
    public static int metodeInverse;
    public static double yTaksiran;
    public static Matrix interpolasiMatrix;
    public static FileWriter fileWriter;
    public static PrintWriter printWriter;
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
                            inputMenu("Interpolasi Polinom");
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
                                    if(metodeInverse == 1) input.inverseByAugment();
                                    else if(metodeInverse == 2) input.inverseByCofactor();
                                    outputMenu("Matriks Balikan");
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //masukan berupa titik" yang dipisahkan oleh baris
                                    try{
                                        fileInput = new Scanner(new BufferedReader(new FileReader("../test/" + fileName + ".txt")));
                                        int banyakTitik = 0;
                                        while(fileInput.hasNextLine()) {
                                            banyakTitik++;
                                            fileInput.nextLine();
                                        }
                                        fileInput.close();
                                        fileInput = new Scanner(new BufferedReader(new FileReader("../test/" + fileName + ".txt")));
    
                                        //create augmented matrix
                                        interpolasiMatrix = new Matrix(banyakTitik-1, banyakTitik);
                                
                                        for (int i=0;i<banyakTitik-1; i++) {
                                            int j;
                                            String[] line = fileInput.nextLine().trim().split(" ");
                                            double x = Double.parseDouble(line[0]);
                                            double y = Double.parseDouble(line[1]);
                                            for(j=0;j<banyakTitik-1;j++){
                                                interpolasiMatrix.getMatrix()[i][j] = power(x, j);
                                            }
                                            interpolasiMatrix.getMatrix()[i][j] = y;
                                        }
                                        
                                         String[] line = fileInput.nextLine().trim().split(" ");
                                         double xTaksiran = Double.parseDouble(line[0]);
                                         yTaksiran = interpolasiMatrix.interpolasi(interpolasiMatrix, xTaksiran);
                                         outputMenu("Interpolasi Polinom");
                                    }
                                    catch(FileNotFoundException ex){
                                        //in case file is not found
                                        System.out.println("Nama file yang anda masukkan salah atau tidak ada file yang dimaksud di folder test!");
                                    }
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    //masukan dari file berupa matriks augmented
                                    input.readMatrixFromFile(fileName);
                                    if(!input.isFileExist){
                                        inputMenu(operasi);
                                        return;
                                    }
                                    System.out.print("Masukkan x1 sampai xn yang akan ditaksir y-nya (dalam bentuk file txt matrix 1 x (banyak x)):");
                                    fileName =  file.nextLine();
                                    sample = new Matrix();
                                    sample.readMatrixFromFile(fileName);
                                    
                                    if(!sample.isFileExist){
                                        inputMenu(operasi);
                                        return;
                                    }
                                    outputMenu("Regresi Linier Berganda");  
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
                                    System.out.print("Masukkan ukuran matriks persegi (nxn): ");
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
                                    System.out.print("Masukkan ukuran matriks persegi (nxn): ");
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
                                    System.out.print("Masukkan banyaknya titik: ");
                                    banyakTitik = sc.nextInt();
                                    //build an augmented matrix
                                    interpolasiMatrix = new Matrix(banyakTitik, banyakTitik+1);
                                    System.out.println("Masukkan titik-titik tersebut, (x,y) dipisahkan oleh spasi");
                                    for(int i=0;i<banyakTitik;i++){
                                        double x,y;
                                        System.out.print("x" + (i+1) + " y" + (i+1) + " = ");
                                        x = sc.nextInt();
                                        y = sc.nextInt();
                                        int j;
                                        for(j=0;j<banyakTitik;j++){
                                            interpolasiMatrix.getMatrix()[i][j] = power(x, j);
                                        }
                                        interpolasiMatrix.getMatrix()[i][j] = y;
                                    }
                                    //input nilai yang ingin ditaksir
                                 //   interpolasiMatrix.printMatrix();
                                    System.out.print("Masukkan nilai yang ingin ditaksir: ");
                                    double xTaksiran = sc.nextDouble();
                                    //proses
                                    yTaksiran = interpolasiMatrix.interpolasi(interpolasiMatrix, xTaksiran);
                                  //  interpolasiMatrix.printMatrix();
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
                                    input.readMatrixFromConsole(m, n+1);
                                    //Masukkan sebaris n peubah  yang ingin ditaksir y nya
                                    sample = new Matrix(1, n);
                                    System.out.println("Masukkan x1 sampai xn yang akan ditaksir y-nya (dalam bentuk matrix 1xn):");
                                    sample.readMatrixFromConsole(1,n);
                                    //proses
                                    
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
                            System.out.print("Masukkan nama file (tanpa .txt): ");
                            String fileName = file.nextLine();
                             switch (operasi){
                                case "SPL":{
                                    
                                    if(metodeSPL == 1){
                                        input.solutionFromGaussJordanFile(fileName, false);
                                    }
                                    else if(metodeSPL == 2){
                                        input.solutionFromGaussJordanFile(fileName, true);
                                    }
                                    else if(metodeSPL == 3){
                                        input.solutionSPLInversFile(fileName);
                                    }
                                    else if(metodeSPL == 4){
                                        input.solutionCrammerFile(fileName);
                                    }
                                    break;
                                }
                                case "Determinan":{
                                    //perlu prosedur float ke file
                                    fileWriter = new FileWriter("../test/" + fileName + ".txt");
                                    BufferedWriter bufferWriter =  new BufferedWriter(fileWriter);
                                    bufferWriter.write("Determinan dari matriks tersebut: ");
                                    bufferWriter.write(String.valueOf(hasilDeterminan));
                                    bufferWriter.newLine();
                                    bufferWriter.flush();
                                    break;
                                }
                                case "Matriks Balikan":{
                                    fileWriter = new FileWriter("../test/" + fileName + ".txt");
                                    BufferedWriter bufferWriter =  new BufferedWriter(fileWriter);
                                    if(!input.isIdentityAfterInverse) bufferWriter.write("Matriks tersebut tidak memiliki inverse!");
                                    else{
                                        bufferWriter.write("Matriks tersebut memiliki inverse! Berikut matriks inversenya");
                                        bufferWriter.newLine();
                                        input.outputMatrixFromFile(fileName);
                                    }
                                    bufferWriter.newLine();
                                    bufferWriter.flush();
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //perlu float ke file
                                    //luaran berupa persamaan dan nilai taksiran
                                    fileWriter = new FileWriter("../test/"+ fileName + ".txt");
                                    printWriter = new PrintWriter(fileWriter);
                                    printWriter.print("Polinomial yang terbentuk: ");
                                    boolean isPrevProcessed = false;
                                    for(int row=0;row<interpolasiMatrix.getNRow();row++){
                                        double tmpVal = interpolasiMatrix.getMatrix()[row][interpolasiMatrix.getNRow()];
                                        if(row > 0 && tmpVal != 0.0){
                                            if(isPrevProcessed) printWriter.print(" + ");
                                            if(tmpVal != 1.0){
                                                if(row > 1) printWriter.print("(" + tmpVal + ")x^" + row);
                                                else printWriter.print("(" + tmpVal + ")x");
                                                isPrevProcessed = true;
                                            }
                                            else{ printWriter.print("x"); isPrevProcessed = false;}
                                        }
                                        else{
                                            if(tmpVal > 0){
                                                printWriter.print(tmpVal);    
                                                isPrevProcessed = true;
                                            }
                                            else isPrevProcessed = false;
                                        }
                                    }
                                    
                                    printWriter.println("\nNilai taksiran di titik tersebut adalah " + yTaksiran + "\n");
                                    fileWriter.flush();
                                    fileWriter.close();
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    //luaran berupa persamaan dan nilai taksiran
                                    input.solutionFromRegressionFile(sample, fileName);
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

                                    if(metodeSPL == 1){
                                        input.eliminasiGauss();
                                        System.out.println("Berikut matrix setelah dilakukan eliminasi Gauss");
                                        input.printMatrix();
                                        input.eliminasiGaussJordan();
                                        input.solutionFromGaussJordan();
                                    }
                                    else if(metodeSPL == 2){
                                        input.eliminasiGaussJordan();
                                        System.out.println("Berikut matrix setelah dilakukan eliminasi Gauss Jordan");
                                        input.printMatrix();
                                        input.solutionFromGaussJordan();
                                    }
                                    else if(metodeSPL == 3){
                                        input.solutionSPLInvers();
                                    }
                                    else if(metodeSPL == 4){
                                        if(input.cutOneCol(input.getNCol()-1).determinantByReduction() == 0){
                                            System.out.println("SPL ini solusinya tidak tunggal, karena determinannya 0");
                                        }else{
                                            Matrix result = input.solusiCrammer();
                                            for(int i=0; i<result.getNRow(); i++){
                                                System.out.println("x" + (i+1) + " = " + result.getMatrix()[i][0]);
                                            }
                                        }
                                    }
                                    break;
                                }
                                case "Determinan":{
                                    //output sesuai persoalan masing"
                                    System.out.println("Determinan matriks tersebut adalah " + hasilDeterminan + "\n");
                                    break;
                                }
                                case "Matriks Balikan":{
                                    if(!input.isIdentityAfterInverse) System.out.println("Matriks tersebut tidak memiliki inverse!");
                                    else{
                                        System.out.println("Matriks tersebut memiliki inverse! Berikut matriksnya");
                                        input.printMatrix();
                                    }
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //persamaan polinom dan taksiran
                                   // interpolasiMatrix.printMatrix();
                                    System.out.print("Polinomial yang terbentuk: ");
                                    boolean isPrevProcessed = false;
                                    for(int row=0;row<interpolasiMatrix.getNRow();row++){
                                        double tmpVal = interpolasiMatrix.getMatrix()[row][interpolasiMatrix.getNRow()];
                                        if(row > 0 && tmpVal != 0.0){
                                            if(isPrevProcessed) System.out.print(" + ");
                                            if(tmpVal != 1.0){
                                                if(row > 1) System.out.print("(" + tmpVal + ")x^" + row);
                                                else System.out.print("(" + tmpVal + ")x");
                                                isPrevProcessed = true;
                                            }
                                            else{ System.out.print("x"); isPrevProcessed = false;}
                                        }
                                        else{
                                            if(tmpVal > 0){
                                                System.out.print(tmpVal);    
                                                isPrevProcessed = true;
                                            }
                                            else isPrevProcessed = false;
                                        }
                                    }
                                    System.out.println("\nNilai taksiran di titik tersebut adalah " + yTaksiran + "\n");
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    input.solutionFromRegression(sample);
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