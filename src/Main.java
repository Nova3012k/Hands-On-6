import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // DataSet valores proporcionados
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();
        xValues.add(-3.0);
        yValues.add(7.5);
        xValues.add(-2.0);
        yValues.add(3.0);
        xValues.add(-1.0);
        yValues.add(0.5);
        xValues.add(0.0);
        yValues.add(1.0);
        xValues.add(1.0);
        yValues.add(3.0);
        xValues.add(2.0);
        yValues.add(6.0);
        xValues.add(3.0);
        yValues.add(14.0);

        QuadraticRegression regression = new QuadraticRegression(xValues, yValues);
        regression.calculateCoefficients();
        regression.printRegressionEquation();

        // Predicciones
        double predictedValue1 = regression.predict(5.5);
        double predictedValue2 = regression.predict(8.5);

        System.out.println("PREDICCIONES EN FUNCION A VALORES CONOCIDOS Y DESCONOCIDOS DE LA VARIABLE EXOGENA:");

        System.out.println("Predicción para x: " + predictedValue1);
        System.out.println("Predicción para y: " + predictedValue2);
    }
}
