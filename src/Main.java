
public class Main{
    public static void main(String[] args){
        Matrix tes = new Matrix();
        tes.readMatrixFromConsole();
        double det = tes.determinantByReduction();
        System.out.println(det);
    }
}