// 院試2020.A-8
// １変数整数係数多項式のデータ構造 

// リストのクラスライブラリ
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 入力のためのクラスライブラリ
import java.io.*;

class Poly {
    private List<Integer> co; // 整数係数のリスト

    public Poly() { // コンストラクタ１
        co = new ArrayList<Integer>();
    }

    public Poly(List<Integer> co) { // コンストラクタ２
        this.co = new ArrayList<Integer>(co);
    }

    public double culculation(double x) { // ｘを指定したときの値を返すメソッド
        double sum = 0;

        for (int i = 0; i < co.size(); i++) {
            sum = sum + co.get(i) * Math.pow(x, i);
        }

        return sum;
    }

    public Poly addpoly(Poly p1) { // ２つの多項式の和を返すメソッド (b)
        Poly p = new Poly();
        for (int i = 0; i < co.size() || i < p1.co.size(); i++) {
            int a = 0;
            if (i < co.size()) {
                a += co.get(i);
            }
            if (i < p1.co.size()) {
                a += p1.co.get(i);
            }
            p.co.add(a);
        }
        return p;
    }

    public Poly shiftpoly(int n) { // 多項式とx^nの積を返すメソッド（係数をnだけ繰り上げる）
        List<Integer> co_tmp = new ArrayList<Integer>(co);
        for (int i = 0; i < n; i++) {
            co_tmp.add(0, 0); // 係数リストの頭にnコ０を入れる
        }
        return new Poly(co_tmp);
    }

    public Poly mulpoly(int d) { // 多項式と定数の積を返すメソッド
        Poly p = new Poly();
        for (int a : co) { // coの要素を1つずつ取ってくる
            p.co.add(a * d);
        }
        return p;
    }

    public Poly mulpoly(Poly p1) { // ２つの多項式の積を返すメソッド (c)
        Poly p = new Poly();
        for (int i = 0; i < co.size(); i++) {
            Poly q = p1.mulpoly(co.get(i)); // 定数倍した多項式を生成
            p = p.addpoly(q.shiftpoly(i)); // その多項式をx^i倍して足す
        }
        return p;
    }

    public String toString() { // 出力形式
        String s = "";
        String delim = "";
        for (int a : co) {
            s += delim + a;
            delim = ", ";
        }
        return "(" + s + ")";
    }

}

class SampleA {

    public static List<Integer> stringToList(String str) { // Stringとして入力されたリストを、Integerのリストに変換するメソッド
        String[] l = str.split(",");
        List<Integer> l_tmp = new ArrayList<Integer>();
        for (String s : l) {
            l_tmp.add(Integer.valueOf(s.replaceAll("[^0-9]", ""))); // 数字以外を除去してString→Int変換
        }
        return l_tmp;
    }

    public static void main(String[] args) {
        Poly p1 = new Poly(Arrays.asList(-10, 4, 0, 5)); // (a)
        double sum = p1.culculation(1.0);
        System.out.println("When x = 1.0, 5x^3+4x-10 is... " + sum);

        try {
            System.out.print("Please write coefficient list of a polynomial. ");
            System.out.println("ex) When 5x^3+4x-10, write '-10, 4, 0, 5'.");
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String p2_co = br1.readLine();
            Poly p2 = new Poly(stringToList(p2_co));

            System.out.println("Please write coefficient list of another polynomial.");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            String p3_co = br2.readLine();
            Poly p3 = new Poly(stringToList(p3_co));

            System.out.println("The sum of two polynomials is " + p2.addpoly(p3));
            System.out.println("The product of two polynomials is " + p2.mulpoly(p3));

        } catch (IOException e) {
            System.out.println("入出力エラーです。");
        }

    }
}
