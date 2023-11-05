import java.util.ArrayList;

public class DiscreteMathematics {
    public static double sum(ArrayList<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    public static double sumOfSquares(ArrayList<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += value * value;
        }
        return sum;
    }

    public static double sumOfCubed(ArrayList<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += Math.pow(value, 3);
        }
        return sum;
    }

    public static double sumOfQuarted(ArrayList<Double> values) {
        double sum = 0;
        for (double value : values) {
            sum += Math.pow(value, 4);
        }
        return sum;
    }

    public static double sumOfProducts(ArrayList<Double> values1, ArrayList<Double> values2) {
        double sum = 0;
        for (int i = 0; i < values1.size(); i++) {
            sum += values1.get(i) * values2.get(i);
        }
        return sum;
    }

    public static ArrayList<Double> multiply(ArrayList<Double> values1, ArrayList<Double> values2) {
        ArrayList<Double> result = new ArrayList<>();
        for (int i = 0; i < values1.size(); i++) {
            result.add(values1.get(i) * values2.get(i));
        }
        return result;
    }
}
