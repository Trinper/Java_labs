import java.util.Scanner;
import java.text.*;

class Taylor {
    private double num;
    private int k;
    public Taylor(){
        num = 0 ;
        k = 0;
    }
    public  Taylor(double num_, int k_){
        num = num_;
        k = k_;
    }

    public void setNum(double num_){
        this.num = num_;
    }

    public void setK(int k_) {
        this.k = k_;
    }

    public double getNum(){
        return num;
    }

    public int getK() {
        return k;
    }

    public double Counting(){
        double sum = getNum();
        double shag = getNum();
        double eps = Math.pow(10, -1 * (getK() + 1));
        int temp = 3;
        while (Math.abs(shag) > eps){
            //System.out.println(shag);
            shag = shag * (-1) * getNum() * getNum() * (temp - 2) / temp;
            temp += 2;
            sum += shag;
        }
        return sum;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();
        int k = scan.nextInt();
        Taylor taylor = new Taylor(x, k);

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k + 1);

        System.out.println("My arctan x: " + formatter.format(taylor.Counting()));
        System.out.println("Java arctan x: " + formatter.format(Math.atan(x)));
    }
}