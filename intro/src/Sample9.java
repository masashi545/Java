// スレッドについて

// スレッドの作成方法
// 1.Threadクラスを拡張したクラスを作成する。
// 2.Runnableインターフェースを実装したクラスを作成する。←他のクラスを継承している場合、これ以上クラスを継承できないから。

class Car extends Thread { // java.langライブラリ（デフォでインポートされている）のクラスThreadのサブクラスを作成。
    // class Car implements Ruunable {
    // Runnableインターフェースを実装する。→同じように必ずrun()メソッドを定義する。

    private String name;

    public Car(String nm) {
        name = nm;
    }

    public void run() { // Threadクラスのサブクラスには必ずrun()メソッドを定義（オーバーライド）する。別のスレッドで行う処理を定義。
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000); // 1000ms(1s)一時停止する。sleepメソッドを使う場合は例外処理をすべき。
                System.out.println(name + "の処理をしています。");
            } catch (InterruptedException e) { // sleep()メソッドから投げられる可能性のある例外。
            }
        }
    }
}

class Sample9 {
    public static void main(String[] args) {

        Car car1 = new Car("1号車");
        car1.start(); // 新しいスレッドが起動して、run()メソッドが処理される。
        // Runnableインターフェースを実装するやり方の場合
        // Thread th1 = new Thread(car1); // Threadクラスのオブジェクトを作成する。
        // th1.start(); // そのオブジェクトで新しいスレッドを起動する。

        Car car2 = new Car("2号車");
        car2.start(); // さらに新しいスレッドが起動して、run()メソッドが処理される。

        try {
            car1.join(); // オブジェクトcar1に関連づけられたスレッドが終了するのを待つ。
        } catch (InterruptedException e) { // join()メソッドから投げられる可能性のある例外。
        }

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500); // main()メソッドが動いているスレッドが、一時停止する。
                System.out.println("main()の処理をしています。");
            } catch (InterruptedException e) {
            }
        }

    }
}
