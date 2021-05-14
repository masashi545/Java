// クラスの継承について

// final修飾子について
// ＊クラスにつけると、サブクラスを作れなくなる。
// ＊メソッドにつけると、サブクラスでオーバーライドできなくなる。
// ＊フィールドにつけると、値を変更できなくなる。

class Car { // 拡張もとのクラス＝スーパークラス

    protected int num; // 他のクラスからは見えないが、サブクラスや同じパッケージ内のクラスからは見える。
    protected double gas;

    public Car() {
        num = 0;
        gas = 0.0;
        System.out.println("車を作成しました。");
    }

    public Car(int n, double g) {
        num = n;
        gas = g;
        System.out.println("ナンバー" + num + "、ガソリン量" + gas + "の車を作成しました。");
    }

    public void setCar(int n, double g) {
        num = n;
        gas = g;
        System.out.println("ナンバーを" + num + "に、ガソリン量を" + g + "にしました。");
    }

    public void show() {
        System.out.println("車のナンバーは" + this.num + "です。");
        System.out.println("ガソリン量は" + this.gas + "です。");
    }

    public String toString() { // 全てのクラスの大元にObjectクラスというスーパークラスがある。ObjectクラスのtoStringメソッドをオーバーライドしている。
        String str = "ナンバー:" + this.num + " ガソリン量:" + this.gas;
        return str;
    }
}

class RacingCar extends Car { // クラスCarを拡張したクラス。サブクラス。
    private int course;

    public RacingCar() { // コンストラクタ
        super(); // スーパークラスのコンストラクタを呼び出す。省略可。
        course = 0;
        System.out.println("レーシングカーを作成しました。");
    }

    public RacingCar(int n, double g, int c) {
        super(n, g); // スーパークラスのどのコンストラクタを呼び出すか指定。デフォは引数なしのコンストラクタ。
        course = c;
        System.out.println("コース番号" + course + "のレーシングカーを作成しました。");
    }

    public void setCourse(int c) {
        course = c;
        System.out.println("コース番号を" + course + "にしました。");
    }

    public void show() { // オーバーライド：スーパークラスにあるメソッドと同じ名前のメソッドを定義できる。
        System.out.println("レーシングカーのナンバーは" + this.num + "です。"); // スーパークラスのprotected変数が参照できる。
        System.out.println("ガソリン量は" + this.gas + "です。");
        // super.show(); // スーパークラスのメソッドを呼び出すこともできる。
        System.out.println("コース番号は" + this.course + "です。");
    }

    public String toString() { // さらにオーバーライド
        String str = "ナンバー:" + this.num + " ガソリン量:" + this.gas + " コース番号:" + this.course;
        return str;
    }
}

public class Sample4 {
    public static void main(String[] args) {
        Car car1 = new Car(1234, 20.5);
        car1.show(); // スーパークラスCarのメソッドshowが呼び出される。
        System.out.println(car1); // System.out.println(car1.toString());と同義

        RacingCar car2 = new RacingCar(5678, 30.5, 1);
        // Car car2 = new RacingCar(5678, 30.5, 1); //
        // スーパークラスの変数にサブクラスのオブジェクトを格納することができる。しかしこの場合、サブクラスで新しく宣言したメソッドは使えない。オーバーライドしたメソッドは使える。
        car2.show(); // サブクラスRacingCarのメソッドshowが呼び出される。→変数のクラスではなく、格納されているオブジェクトのクラスに基づいてメソッドが呼び出される。
        System.out.println(car2);

        car2.setCourse(2);
    }
}