// インターフェースについて

interface iVehicle {
    // フィールド(デフォでpublic static final)

    // メソッド（デフォでabstract）
    void vshow();
}

interface iMaterial {
    void mshow();
}

class Car implements iVehicle, iMaterial { // インターフェースはいくつも実装できる。
    private int num;
    private double gas;
    private String material;

    public Car(int n, double g, String m) {
        num = n;
        gas = g;
        material = m;
        System.out.println("ナンバー" + num + "、ガソリン量" + gas + "の車を、" + material + "で作成しました。");
    }

    public void vshow() { // インターフェースにあるメソッドは必ず定義しなければならない。
        System.out.println("車のナンバーは" + num + "です。");
        System.out.println("ガソリン量は" + gas + "です。");
    }

    public void mshow() { // インターフェースにあるメソッドは必ず定義しなければならない。
        System.out.println("車の材質は" + material + "です。");
    }
}

class Plane implements iVehicle, iMaterial {
    private int flight;
    private String material;

    public Plane(int f, String m) {
        flight = f;
        material = m;
        System.out.println("便" + flight + "の飛行機を、" + material + "で作成しました。");
    }

    public void vshow() {
        System.out.println("飛行機の便は" + flight + "です。");
    }

    public void mshow() {
        System.out.println("飛行機の材質は" + material + "です。");
    }
}

class Sample6 {
    public static void main(String[] args) {
        Car car1 = new Car(1234, 20.5, "iron");
        car1.vshow();
        car1.mshow();

        Plane plane1 = new Plane(232, "carbon");
        plane1.vshow();
        plane1.mshow();
    }
}
