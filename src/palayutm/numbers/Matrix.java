package palayutm.numbers;

public class Matrix {
    public static long mod = (long) 1e9 + 7;
    public long[][] a;
    public int rowCount;
    public int columnCount;

    public Matrix(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.a = new long[rowCount][columnCount];
    }

    public Matrix(long[][] data) {
        this.a = data.clone();
        this.rowCount = data.length;
        this.columnCount = data[0].length;
    }

    public static Matrix identityMatrix(int size) {
        Matrix result = new Matrix(size, size);
        for (int i = 0; i < size; i++)
            result.a[i][i] = 1;
        return result;
    }

    public Matrix add(Matrix m) {
        Matrix result = new Matrix(rowCount, columnCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                result.a[i][j] = (this.a[i][j] + m.a[i][j]) % mod;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix m) {
        Matrix result = new Matrix(rowCount, columnCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < m.columnCount; j++) {
                for (int k = 0; k < columnCount; k++) {
                    result.a[i][j] = (result.a[i][j] + this.a[i][k] * m.a[k][j]) % mod;
                }
            }
        }
        return result;
    }

    public Matrix pow(long n) {
        Matrix result = Matrix.identityMatrix(rowCount);
        Matrix t = new Matrix(a);
        while (n > 0) {
            if (n % 2 > 0) {
                result = result.multiply(t);
            }
            n >>= 1;
            t = t.multiply(t);
        }
        return result;
    }
}
