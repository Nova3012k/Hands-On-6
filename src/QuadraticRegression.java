import java.util.ArrayList;

public class QuadraticRegression {
    private final ArrayList<Double> xValues;
    private final ArrayList<Double> yValues;
    private double a, b, c;

    public QuadraticRegression(ArrayList<Double> xValues, ArrayList<Double> yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
    }

    public void calculateCoefficients() {
        int n = xValues.size();

        // Construir la matriz de características X
        double[][] X = new double[n][3];
        for (int i = 0; i < n; i++) {
            double x = xValues.get(i);
            X[i][0] = 1;      // Para el término constante
            X[i][1] = x;
            X[i][2] = x * x;   // Cuadrado de x
        }

        // Construir el vector de valores de salida y
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = yValues.get(i);
        }

        // Calcular los coeficientes utilizando la fórmula B = (X^T X)^-1 X^T y
        double[][] XTransposed = transposeMatrix(X);
        double[][] XTransposedX = multiplyMatrices(XTransposed, X);
        double[][] inverseXTransposedX = MatrixInverter.invertMatrix(XTransposedX);
        double[] XTransposedY = multiplyMatrixWithVector(XTransposed, y);

        // Multiplicar (X^T X)^-1 por X^T y para obtener los coeficientes
        double[] coefficients = multiplyMatrixWithVector(inverseXTransposedX, XTransposedY);

        a = coefficients[2];
        b = coefficients[1];
        c = coefficients[0];
    }

    public double predict(double x) {
        return a * x * x + b * x + c;
    }

    public void printRegressionEquation() {
        System.out.println("Formula implementada: B=(X^T X)^-1 X^T y");
        System.out.println("Ecuación de Regresión Cuadrática: y = " + a + "x^2 + " + b + "x + " + c + "\n");
    }

    private double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transpose = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    private double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        double[][] result = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    private double[] multiplyMatrixWithVector(double[][] matrix, double[] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[] result = new double[rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }
}
