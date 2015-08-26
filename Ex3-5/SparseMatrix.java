/**
 * Created by pu on 2015/8/26/026.
 */
public class SparseMatrix {
    private final int row;
    private final int column;
    private LinearProbingHashST<Integer, Double>[] matrix;

    public SparseMatrix(double[] rows, int rowCount) {
        row = rowCount;
        column = rows.length / rowCount;
        matrix = new LinearProbingHashST[row];
        for (int i = 0; i < matrix.length; i++)
            matrix[i] = new LinearProbingHashST<>();
        for (int i = 0, j = 0; i < rows.length; i += column, j++)
            for (int k = 0; k < column; k++)
                if (rows[i + k] != 0)
                    matrix[j].put(k, rows[i + k]);
    }

    public SparseMatrix add(SparseMatrix a) {
        if (row != a.row || column != a.column) throw new IllegalArgumentException();
        double[] tmpMatrix = new double[row * column];
        for (int i = 0; i < matrix.length; i++) {
            for (Integer c : matrix[i].keys())
                tmpMatrix[i * column + c] += matrix[i].get(c);
            for (Integer c : a.matrix[i].keys())
                tmpMatrix[i * column + c] += a.matrix[i].get(c);
        }
        SparseMatrix tmp = new SparseMatrix(tmpMatrix, row);
        return tmp;
    }

    private double[] readLine(int i, SparseMatrix a) {
        double[] tmp = new double[a.row];
        for (int j = 0; j < a.row; j++) {
            if (!a.matrix[j].contains(i)) continue;
            tmp[j] = a.matrix[j].get(i);
        }
        return tmp;
    }

    public SparseMatrix multiply(SparseMatrix a) {
        if (column != a.row) throw new IllegalArgumentException();
        double[] array = new double[row * a.column];
        double sum = 0.0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < a.column; j++) {
                double[] tmp = readLine(j, a);
                for (Integer c : matrix[i].keys())
                    sum += tmp[c] * matrix[i].get(c);
                array[i * a.column + j] = sum;
                sum = 0.0;
            }
        }
        return new SparseMatrix(array, row);
    }

    public void show() {
        for (LinearProbingHashST<Integer, Double> i : matrix) {
            for (Integer c : i.keys())
                System.out.print(c + " " + i.get(c) + " ");
            System.out.println();
        }
    }
}
