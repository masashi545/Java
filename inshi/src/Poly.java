public class Poly {
    private int[] co;

    public Poly() {
        co = new int[4];
        co[0] = -10;
        co[1] = 4;
        co[2] = 0;
        co[3] = 5;
    }

    public double culculation(double x) {
        double sum = 0;

        for (int i = 0; i < 4; i++) {
            sum = sum + co[i] * Math.pow(x, i);
        }

        return sum;
    }
}
