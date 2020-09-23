import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);

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
            
                        }
                        case 2:{
                            determinanMenu();
                        }
                        case 3:{
            
                        }
                        case 4:{
            
                        }
                        case 5:{
            
                        }
                        case 6:{
                            System.exit(0);
                        }
                        default:{
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
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 6!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
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
                            determinanInputMenu(1);
                        }
                        case 2:{
                            determinanInputMenu(2);
                        }
                        default:{
                            mainMenu();
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
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 4!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
            }
        }
    }
    public static void determinanInputMenu(int metode){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU Determinan");
                System.out.println("1. Baca dari File");
                System.out.println("2. Baca dari Konsol");
                System.out.println("3. Balik ke Main Menu");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 3) throw new Exception();
                else{
                    Matrix input = new Matrix();
                    double hasilDeterminan = 0.0;
                    switch (selection){
                        case 1:{
                           System.out.println("Masukkan nama File (diakhiri .txt): ");
                           String fileName =  sc.nextLine();
                            input.readMatrixFromFile(fileName);
                            if(input.isFileExist){
                                if(metode == 1) hasilDeterminan = input.determinantByReduction();
                                else hasilDeterminan = input.determinantByCofactor();    
                            }
                            else determinanMenu();
                            determinanOutputMenu(hasilDeterminan);
                        }
                        case 2:{
                            input.readMatrixFromConsole();
                            if(metode == 1) hasilDeterminan =  input.determinantByReduction();
                            else hasilDeterminan = input.determinantByCofactor();    
                            determinanOutputMenu(hasilDeterminan);
                        }
                        case 3:{
                            mainMenu();
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
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 3!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
            }
        }
    }
    public static void determinanOutputMenu(double hasil){
        while(true){
            try{
                int selection;
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("MENU Determinan");
                System.out.println("1. Tulis hasil ke dalam File");
                System.out.println("2. Tulis hasil di Konsol");
                System.out.println("3. Balik ke Input Matriks");
                System.out.println("4. Balik ke Main Menu");
                System.out.println("============================");
                System.out.print("Masukkan pilihan anda: ");
                selection = sc.nextInt();
                if(selection < 1 || selection > 4) throw new Exception();
                else{
                    switch (selection){
                        case 1:{

                        }
                        case 2:{
                            System.out.println("Determinan matriks tersebut adalah " + hasil + "\n");
                            System.out.print("Tekan enter untuk melanjutkan...");
                            try{
                                System.in.read();
                            } catch(Exception exKey){}
                        }
                        case 4:{
                            mainMenu();
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
            }
            catch(Exception e){
                System.out.println("Masukan haruslah sebuah angka dari 1 sampai 4!");
                System.out.print("Tekan enter untuk melanjutkan...");
                try{
                    System.in.read();
                } catch(Exception exKey){}
            }
        }
    }
}