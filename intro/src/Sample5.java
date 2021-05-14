// 抽象クラスについて

abstract class Vehicle {
    protected int speed;

    public void setSpeed(int s) {
        speed = s;
        System.out.println("速度を" + speed + "にしました。");
    }

    // 抽象メソッド：抽象クラスには必ずある。宣言だけでメソッドの処理は定義しない。
    abstract void show();
}

class Car extends Vehicle {
    private int num;
    private double gas;

    public Car(int n, double g) {
        num = n;
        gas = g;
        System.out.println("ナンバー" + num + "、ガソリン量" + gas + "の車を作成しました。");
    }

    public void show() { // 抽象クラスを必ずオーバーライドしなくてはならない。
        System.out.println("車のナンバーは" + num + "です。");
        System.out.println("ガソリン量は" + gas + "です。");
        System.out.println("速度は" + speed + "です。");
    }
}

class Plane extends Vehicle {
    private int flight;

    public Plane(int f) {
        flight = f;
        System.out.println("便" + flight + "の飛行機を作成しました。");
    }

    public void show() { // 抽象クラスを必ずオーバーライドしなくてはならない。
        System.out.println("飛行機の便は" + flight + "です。");
        System.out.println("速度は" + speed + "です。");
    }
}

class Sample5 {
    public static void main(String[] args) {
        Vehicle[] vc;
        vc = new Vehicle[2];

        vc[0] = new Car(1234, 20.5);
        vc[0].setSpeed(60);

        vc[1] = new Plane(232);
        vc[1].setSpeed(500);

        for (int i = 0; i < vc.length; i++) {
            vc[i].show();

            if (vc[i] instanceof Car) { // instanceof演算子：オブジェクトのクラスを調べる。
                System.out.println((i + 1) + "番目のオブジェクトはCarクラスです。");
            } else if (vc[i] instanceof Plane) {
                System.out.println((i + 1) + "番目のオブジェクトはPlaneクラスです。");
            } else {
                System.out.println((i + 1) + "番目のオブジェクトはCarクラスでもPlaneクラスでもありません。");
            }
        }

    }
}
