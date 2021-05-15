// スレッド間の同期について

class Company {
    private int sum;

    public synchronized void add(int a) { // synchoronized修飾子：あるスレッドがこのメソッドを処理している場合は、他のスレッドはこのメソッドを呼び出すことができない。終了するまで待つ。
        int tmp = sum;
        System.out.println("現在、合計額は" + tmp + "円です。");
        System.out.println(a + "円稼ぎました。");
        tmp = tmp + a;
        System.out.println("合計額を" + tmp + "円にします。");
        sum = tmp;
    }
}

class Driver extends Thread {
    private Company comp;

    public Driver(Company c) {
        comp = c;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            comp.add(50);
        }
    }
}

class Sample10 {
    public static void main(String[] args) {
        Company c1 = new Company();

        Driver drv1 = new Driver(c1);
        drv1.start();

        Driver drv2 = new Driver(c1);
        drv2.start();
    }
}
