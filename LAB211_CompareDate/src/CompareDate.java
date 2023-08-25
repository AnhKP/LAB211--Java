
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class CompareDate{
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n ; i++){
            a[i] = sc.nextInt();
        }
        int s = 0;
        for(int i = 0; i < n; i++){
            s += a[i];
        }
        System.out.print(s);
    }
}
