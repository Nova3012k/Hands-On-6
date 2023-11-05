import java.util.ArrayList;

public class DataSet {
    private final ArrayList<Double> xValues;
    private final ArrayList<Double> yValues;

    public DataSet() {
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
    }

    public void addDataPoint(double x, double y) {
        xValues.add(x);
        yValues.add(y);
    }

    public ArrayList<Double> getXValues() {
        return xValues;
    }

    public ArrayList<Double> getYValues() {
        return yValues;
    }
}
