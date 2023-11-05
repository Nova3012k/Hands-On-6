public class LinearAlgebra {
    public static double[] solve(double[][] coefficients, double[] constants) {
        int n = constants.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double factor = coefficients[j][i] / coefficients[i][i];
                constants[j] -= factor * constants[i];
                for (int k = i; k < n; k++) {
                    coefficients[j][k] -= factor * coefficients[i][k];
                }
            }
        }

        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += coefficients[i][j] * solution[j];
            }
            solution[i] = (constants[i] - sum) / coefficients[i][i];
        }
        return solution;
    }
}
