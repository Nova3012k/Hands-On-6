public class MatrixInverter {

    public static double[][] invertMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // Crear una matriz aumentada [matrix | Identidad]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1 : 0;
            }
        }

        // Aplicar eliminación gaussiana para convertir la mitad izquierda en la identidad
        for (int i = 0; i < n; i++) {
            // Pivote para la fila i
            double pivot = augmentedMatrix[i][i];

            // Dividir la fila i por el pivote para hacer el elemento diagonal igual a 1
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            // Hacer 0 en otras filas excepto para el elemento diagonal
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        // Extraer la mitad derecha de la matriz aumentada como la matriz inversa
        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverseMatrix;
    }
}
