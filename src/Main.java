import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    public static Matrix input;
    public static double hasilDeterminan;
    public static int metode;
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
                            break;
                        }
                        case 2:{
                            determinanMenu();
                            break;
                        }
                        case 3:{
                            break;
                        }
                        case 4:{
                            break;
                        }
                        case 5:{
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
                            metode = 1;
                            inputMenu("Determinan");
                            break;
                        }
                        case 2:{
                            metode = 2;
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
    public static void inputMenu(String operasi){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("Menu " + operasi);
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
                           System.out.println("Masukkan nama File (diakhiri .txt): ");
                           String fileName =  sc.nextLine();
                            input.readMatrixFromFile(fileName);
                            switch(operasi){
                                case "SPL":{
                                    break;
                                }
                                case "Determinan":{
                                    if(input.isFileExist){
                                        if(metode == 1) hasilDeterminan = input.determinantByReduction();
                                        else hasilDeterminan = input.determinantByCofactor();    
                                    }
                                    else determinanMenu();
                                    outputMenu("Determinan");
                                }
                                case "Matriks Balikan":{
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    break;
                                }
                                case "Regresi Linier Berganda":{
                                    break;
                                }
                            }
                            break;
                        }
                        case 2:{
                            switch(operasi){
                                case "SPL":{
                                    break;
                                }
                                case "Determinan":{
                                    int nRow = sc.nextInt();
                                    int nCol = sc.nextInt();
                                    input.readMatrixFromConsole(nRow, nCol);
                                    if(metode == 1) hasilDeterminan =  input.determinantByReduction();
                                    else hasilDeterminan = input.determinantByCofactor();    
                                    outputMenu("Determinan");
                                    break;
                                }
                                case "Matriks Balikan":{
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    break;
                                }
                                case "Regresi Linier Berganda":{
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
    public static void outputMenu(String operasi){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU Determinan");
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
                            break;
                        }
                        case 2:{
                            switch (operasi){
                                case "SPL":{
                                    break;
                                }
                                case "Determinan":{
                                    System.out.println("Determinan matriks tersebut adalah " + hasilDeterminan + "\n");
                                    break;
                                }
                                case "Matriks Balikan":{
                                    break;
                                }
                                case "Interpolasi Polinom":{
                                    break;
                                }
                                case "Regresi Linier Berganda":{
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