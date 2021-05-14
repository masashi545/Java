// 基本型の変数と、クラス型の変数の扱いの違いについて

class Car {

    private int num;
    private double gas;

    public Car() {
        num = 0;
        gas = 0.0;
        System.out.println("車を作成しました。");
    }

    public void setCar(int n, double g) {
        num = n;
        gas = g;
        System.out.println("ナンバーを" + num + "に、ガソリン量を" + g + "にしました。");
    }

    public void show() {
        System.out.print("車のナンバーは" + this.num + "です。");
        System.out.println("ガソリン量は" + this.gas + "です。");
    }
}

public class Sample3 {
    public static void main(String[] args) {

        // 基本型の変数の場合
        int a;
        int b;
        a = 1; // 変数aに1が格納される。
        b = a; // 変数ｂに（変数aの中の）1が格納される。
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = 2; // 変数aの値を変更する。
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        // 変数ｂの値は変更されない。
        // 2つの変数a,bは、異なる値をさしている。

        // クラス型の変数の場合
        Car car1;
        Car car2;
        car1 = new Car(); // 変数car1にオブジェクトが格納される。
        car1.setCar(1234, 20.5);

        car2 = car1; // 変数car2に（変数car2の中の）オブジェクトが格納される。

        System.out.print("変数car1がさす");
        car1.show();
        System.out.print("変数car2がさす");
        car2.show();
        // 当然同じ車が格納されている。

        System.out.println("変数car1がさす車に変更を加えます。");
        car1.setCar(5678, 30.5); // 変数car1に格納されているオブジェクトに変更を加える。
        System.out.print("変数car1がさす");
        car1.show();
        System.out.print("変数car2がさす");
        car2.show();
        // 変数car2の中のオブジェクトも変更されている。
        // 2つの変数car1,car2が、同じオブジェクトをさしている。

        car1 = null; // nullを代入すると、変数car1はオブジェクトをささなくなる。
        // car1.show(); // これは、コンパイルできない。
        System.out.print("変数car2がさす");
        car2.show(); // 変数car2は、まだオブジェクトをさしている。

        car2 = null; // 変数car2にもnullを代入すると、オブジェクトはどの変数からもさされていない状態になり、破棄される。
    }

}
