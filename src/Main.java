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
                            //tidak perlu submenu, langsung ke metode input
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
                if(selection < 1 || selection > 3) throw new Exception();
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
                            input.readMatrixFromFile(fileName);
                            switch(operasi){
                                case "SPL":{
                                     //masukan dari file berupa matriks augmented
                                    outputMenu("SPL");
                                    break;
                                }
                                case "Determinan":{
                                    //masukan berupa matriks yang dipisahkan spasi
                                    if(input.isFileExist){
                                        if(metodeDeterminan == 1) hasilDeterminan = input.determinantByReduction();
                                        else hasilDeterminan = input.determinantByCofactor();    
                                    }
                                    else determinanMenu();
                                    outputMenu("Determinan");
                                    break;
                                }
                                case "Matriks Balikan":{
                                    //sama seperti determinan
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
                                    if(metodeSPL == 1){
                                        input.eliminasiGauss();
                                        int idxLastRow = input.getNRow()-1;
                                        int idxLastCol = input.getNCol()-1;
                                        boolean solusiBanyak = (input.getMatrix()[idxLastRow][idxLastCol] == 0 && input.getMatrix()[idxLastRow][idxLastCol-1] == 0);
                                        boolean tidakAdaSolusi = (input.getMatrix()[idxLastRow][idxLastCol] != 0 && input.getMatrix()[idxLastRow][idxLastCol-1] == 0);
                                        if(solusiBanyak){
                                            System.out.println("Solusi ada banyak!");
                                            System.out.println("Berikut solusinya dalam persamaan parametrik");
                                            Matrix cekInputVal = new Matrix(input.getNCol()-1, input.getNRow()-1);
                                            for(int row=0;row<input.getNRow();row++){
                                                int cntNotZero = 0, tmpCol=0;
                                                for(int col=0;col<input.getNCol()-1;col++){
                                                    cekInputVal.getMatrix()[row][col] = 0;
                                                    if(input.getMatrix()[row][col] != 0) {cntNotZero++; tmpCol = col;}
                                                }
                                                if(cntNotZero == 1){
                                                    cekInputVal.getMatrix()[row][tmpCol]= input.getMatrix()[row][input.getNRow()-1];
                                                }
                                            }
                                            //not yet
                                            for(int row=0;row<input.getNRow();row++){
                                                double constEq = input.getMatrix()[row][input.getNCol()-1];
                                                System.out.print("x" + row+1 + " = ");
                                                for(int col=0;col<input.getNCol()-1;col++){
                                                    if(input.getMatrix()[row][col] != 0){
                                                        if(cekInputVal.getMatrix()[row][col] != 0){
                                                            constEq -= cekInputVal.getMatrix()[row][col];
                                                        }
                                                    }
                                                 //   else System.out.print(input+ "x" + col+1 )
                                                }
                                               }
                                            
                                        }
                                        else if(tidakAdaSolusi){
                                            System.out.println("SPL tersebut tidak memiliki solusi");
                                        }
                                        else{
                                            System.out.println("SPL tersebut memiliki satu solusi unik yaitu: ");
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
                                    //output sesuai persoalan masing"
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    //persamaan polinom dan taksiran
                                    System.out.println("Nilai taksiran dari titik tersebut adalah " + yTaksiran + "\n");
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    //persamaan polinom dan taksiran
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