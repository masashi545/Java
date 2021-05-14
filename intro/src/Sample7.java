// 例外処理について

// 例外の種類
// Throwable -|- Error
//            |- Exception -|- IOEceptionなど
//                          |- RuntimeException -//- ArrayIndexOutOfBoundsExceptionなど

class CarException extends Exception { // 例外を投げるクラスExceptionを拡張して、例外(を投げる)クラスをつくる。
}

class Car {

    private int num;
    private double gas;

    public Car() {
        num = 0;
        gas = 0.0;
        System.out.println("車を作成しました。");
    }

    public void setCar(int n, double g) throws CarException { // 例外を投げる可能性があるメソッドであることを宣言する。
        if (g < 0) {
            CarException e = new CarException(); // 例外オブジェクトを作成。
            throw e; // 例外を投げる。
        } else {
            num = n;
            gas = g;
            System.out.println("ナンバーを" + num + "に、ガソリン量を" + g + "にしました。");
        }
    }

    public void show() {
        System.out.println("車のナンバーは" + this.num + "です。");
        System.out.println("ガソリン量は" + this.gas + "です。");
    }

}

class Sample7 {
    public static void main(String[] args) {
        int[] test;
        test = new int[5];

        try {
            for (int i = 0; i < 6; i++) {
                test[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("配列の要素をこえています。");
            System.out.println("「" + e + "」という例外が発生しました。");
        } catch (Exception e) {
            System.out.println("「" + e + "」という例外が発生しました。");
        } finally {
            System.out.println("最後に必ずこの処理をします。");
        }

        Car car1 = new Car();

        try {
            car1.setCar(1234, -10.0);
        } catch (CarException e) {
            System.out.println("例外" + e + "が送出されました。");
        }
        car1.show(); // 例外が発生するので、値はコンストラクタで初期化されたまま。
    }
}
