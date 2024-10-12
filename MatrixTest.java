public class MatrixTest {
    public static void main(String[] args) {
        testMatrixConstructor();
        testMatrixAddition();
        testMatrixConstantAddition();
        testMatrixSubtraction();
        testMatrixConstantSubtraction();
        testMatrixMultiplication();
        testMatrixConstantMultiplication();
        testMatrixTranspose();
        testMatrixEquality();
        testMatrixRowAndColumnRetrieval();
        testMatrixValueSettingAndGetting();
        testMatrixPrint();
        testMatrixFlatten();
        System.out.println("All tests passed.");
    }

    private static void testMatrixConstructor() {
        // Test default constructor
        Matrix<Integer> matrix1 = new Matrix<>();
        assert matrix1.getArray() == null : "Default constructor should create an empty matrix.";

        // Test constructor with 2D array
        Integer[][] array = { { 1, 2 }, { 3, 4 } };
        Matrix<Integer> matrix2 = new Matrix<>(array);
        assert matrix2.rowCount() == 2 : "Matrix should have 2 rows.";
        assert matrix2.columnCount() == 2 : "Matrix should have 2 columns.";

        // Test constructor with 1D array
        Integer[] rowArray = { 5, 6 };
        Matrix<Integer> matrix3 = new Matrix<>(rowArray);
        assert matrix3.rowCount() == 1 : "Matrix should have 1 row after 1D array constructor.";
        assert matrix3.columnCount() == 2 : "Matrix should have 2 columns after 1D array constructor.";
    }

    private static void testMatrixConstantAddition() {
        Integer[][] array = { { 1, 2 }, { 3, 4 } };
        Integer constant = 5;
        Matrix<Integer> m = new Matrix<>(array);
        Matrix<Integer> result = m.add(constant);

        assert result.rowCount() == 2 : "Result should have 2 rows.";
        assert result.columnCount() == 2 : "Result should have 2 columns.";
        assert result.getValueAt(0, 0) == 6 : "Result [0][0] should be 6 (1 + 5).";
        assert result.getValueAt(1, 1) == 9 : "Result [1][1] should be 9 (4 + 5).";
    }

    private static void testMatrixConstantSubtraction() {
        Integer[][] array = { { 6, 7 }, { 8, 9 } };
        Integer constant = 3;
        Matrix<Integer> m = new Matrix<>(array);
        Matrix<Integer> result = m.subtract(constant);

        assert result.rowCount() == 2 : "Result should have 2 rows.";
        assert result.columnCount() == 2 : "Result should have 2 columns.";
        assert result.getValueAt(0, 0) == 3 : "Result [0][0] should be 3 (6 - 3).";
        assert result.getValueAt(1, 1) == 6 : "Result [1][1] should be 6 (9 - 3).";
    }

    private static void testMatrixConstantMultiplication() {
        Integer[][] array = { { 2, 3 }, { 4, 5 } };
        Integer constant = 2;
        Matrix<Integer> m = new Matrix<>(array);
        Matrix<Integer> result = m.multiply(constant);

        assert result.rowCount() == 2 : "Result should have 2 rows.";
        assert result.columnCount() == 2 : "Result should have 2 columns.";
        assert result.getValueAt(0, 0) == 4 : "Result [0][0] should be 4 (2 * 2).";
        assert result.getValueAt(1, 1) == 10 : "Result [1][1] should be 10 (5 * 2).";
    }

    private static void testMatrixAddition() {
        Integer[][] array1 = { { 1, 2 }, { 3, 4 } };
        Integer[][] array2 = { { 5, 6 }, { 7, 8 } };
        Matrix<Integer> m1 = new Matrix<>(array1);
        Matrix<Integer> m2 = new Matrix<>(array2);
        Matrix<Integer> result = Matrix.addition(m1, m2);

        assert result.rowCount() == 2 : "Result should have 2 rows.";
        assert result.columnCount() == 2 : "Result should have 2 columns.";
        assert result.getValueAt(0, 0) == 6 : "Result [0][0] should be 6.";
        assert result.getValueAt(1, 1) == 12 : "Result [1][1] should be 12.";
    }

    private static void testMatrixSubtraction() {
        Integer[][] array1 = { { 5, 6 }, { 7, 8 } };
        Integer[][] array2 = { { 1, 2 }, { 3, 4 } };
        Matrix<Integer> m1 = new Matrix<>(array1);
        Matrix<Integer> m2 = new Matrix<>(array2);
        Matrix<Integer> result = Matrix.subtraction(m1, m2);

        // Check row and column count
        assert result.rowCount() == 2 : "Result should have 2 rows.";
        assert result.columnCount() == 2 : "Result should have 2 columns.";

        // Check individual values
        assert result.getValueAt(0, 0) == 4 : "Result [0][0] should be 4.";
        assert result.getValueAt(0, 1) == 4 : "Result [0][1] should be 4.";
        assert result.getValueAt(1, 0) == 4 : "Result [1][0] should be 4.";
        assert result.getValueAt(1, 1) == 4 : "Result [1][1] should be 4.";
    }

    private static void testMatrixMultiplication() {
        Integer[][] array1 = { { 1, 2 }, { 3, 4 } };
        Integer[][] array2 = { { 5, 6 }, { 7, 8 } };
        Matrix<Integer> m1 = new Matrix<>(array1);
        Matrix<Integer> m2 = new Matrix<>(array2);
        Matrix<Integer> result = Matrix.multiplication(m1, m2);

        assert result.rowCount() == 2 : "Result should have 2 rows.";
        assert result.columnCount() == 2 : "Result should have 2 columns.";
        assert result.getValueAt(0, 0) == 19 : "Result [0][0] should be 19.";
        assert result.getValueAt(1, 0) == 43 : "Result [1][1] should be 43.";
    }

    private static void testMatrixTranspose() {
        Integer[][] array = { { 1, 2, 3 }, { 4, 5, 6 } };
        Matrix<Integer> m = new Matrix<>(array);
        Matrix<Integer> transposed = Matrix.transposition(m);

        assert transposed.rowCount() == 3 : "Transposed matrix should have 3 rows.";
        assert transposed.columnCount() == 2 : "Transposed matrix should have 2 columns.";
        assert transposed.getValueAt(0, 1) == 4 : "Transposed [0][1] should be 4.";
    }

    private static void testMatrixEquality() {
        Integer[][] array1 = { { 1, 2 }, { 3, 4 } };
        Integer[][] array2 = { { 1, 2 }, { 3, 4 } };
        Matrix<Integer> m1 = new Matrix<>(array1);
        Matrix<Integer> m2 = new Matrix<>(array2);

        assert m1.equals(m2) : "Matrices should be equal.";

        array2[0][0] = 10; // Modify one element
        Matrix<Integer> m3 = new Matrix<>(array2);
        assert !m1.equals(m3) : "Matrices should not be equal after modification.";
    }

    private static void testMatrixRowAndColumnRetrieval() {
        Integer[][] array = { { 1, 2, 3 }, { 4, 5, 6 } };
        Matrix<Integer> m = new Matrix<>(array);

        Integer[] row = m.getRow(1);
        assert row[0] == 4 : "Row retrieval failed: Expected 4.";
        assert row[1] == 5 : "Row retrieval failed: Expected 5.";

        Integer[] column = m.getColumn(2);
        assert column[0] == 3 : "Column retrieval failed: Expected 3.";
        assert column[1] == 6 : "Column retrieval failed: Expected 6.";
    }

    private static void testMatrixValueSettingAndGetting() {
        Integer[][] array = { { 1, 2 }, { 3, 4 } };
        Matrix<Integer> m = new Matrix<>(array);

        // Test setting a value
        m.setValueAt(0, 0, 10);
        assert m.getValueAt(0, 0) == 10 : "Value at [0][0] should be updated to 10.";

        // Test getting out of bounds
        try {
            m.getValueAt(2, 2);
            assert false : "Expected exception for out of bounds access.";
        } catch (Matrix.MatrixException e) {
            // Exception expected
        }
    }

    private static void testMatrixPrint() {
        Integer[][] array = { { 1, 2 }, { 3, 4 } };
        Matrix<Integer> m = new Matrix<>(array);
        m.print(); // This will print the matrix to console; assert cannot check console output
                   // directly.
    }

    private static void testMatrixFlatten() {
        Integer[][] array = { { 1, 2, 3 }, { 4, 5, 6 } };
        Matrix<Integer> m = new Matrix<>(array);
        Integer[] flattened = m.flatten();

        assert flattened.length == 6 : "Flattened array should have length 6.";
        assert flattened[0] == 1 : "Flattened array [0] should be 1.";
        assert flattened[5] == 6 : "Flattened array [5] should be 6.";
    }
}
