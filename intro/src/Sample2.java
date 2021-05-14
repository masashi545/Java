// コンパイルすると2つのクラスファイルが作成される。

class Car {

    // フィールド
    // インスタンス変数：オブジェクトに関連づけられた変数。オブジェクトが作成されると値を代入できるもの。オブジェクトごとに別の値を格納できる。
    private int num; // クラス内でのみ参照できる。
    private double gas;
    // クラス変数：クラスに関連づけられた変数。クラア全体で扱うデータを格納しておく。各オブジェクトから共有される。
    private static int sum = 0; // クラス変数にはstaticをつける。

    // コンストラクタ
    // Carクラスが作られた時に、自動で行う処理を定義する。普通は、初期設定などを記述する。
    private Car() { // コンストラクタの名前はクラス名と同じでなければならない。
        num = 0;
        gas = 0.0;
        sum++;
        System.out.println("車を作成しました。");
    }

    public Car(int n, double g) { // コンストラクタのオーバーロード：同じ名前のコンストラクタを作れる。引数の型や個数は異ならないといけない。
        this(); // コンストラクタCar()を呼び出している。
        num = n;
        gas = g;
        System.out.println("ナンバーは" + num + "、ガソリン量は" + gas + "です。");
    }

    // メソッド
    // インスタンスメソッド：オブジェクトに関連づけられたメソッド。オブジェクトが作成されると呼び出せるもの。
    private void show() {
        System.out.println("車のナンバーは" + this.num + "です。"); // thisは自分自身を指す。
        System.out.println("ガソリン量は" + this.gas + "です。"); // thisはなくてもよい。
    }

    public void showCar() {
        System.out.println("これから車の情報を表示します。");
        show();
    }

    // クラスメソッド：そのクラスからオブジェクトを作成されていなくても呼び出せるメソッド。
    // オブジェクトに関連づけられていないため、thisは使えない。
    public static void showSum() {
        System.out.println("車は全部で" + sum + "台あります。");
    }
}

class Sample2 {
    public static void main(String[] args) { // mainメソッドもクラスメソッドのひとつ

        Car.showSum(); // クラスメソッドはクラス名で呼び出す。

        Car car1;
        car1 = new Car(1234, 20.5); // Carクラスのオブジェクトを作成。
        car1.showCar(); // インスタンスメソッドはオブジェクト名で呼び出す。

        Car.showSum();
    }
}