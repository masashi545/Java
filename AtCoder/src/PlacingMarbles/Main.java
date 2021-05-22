package PlacingMarbles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        int s = 0;
        for (int i = 0; i < 3; i++) {
            s += sc.nextInt();
        }
        System.out.println(s);
        sc.close();
    }
}
