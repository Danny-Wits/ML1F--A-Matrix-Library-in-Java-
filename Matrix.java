import java.util.function.Consumer;

/**
 * Matrix Class representing a two-dimensional array with additional matrix
 * operations.
 * It is designed to perform various operations on matrices commonly used in
 * linear algebra.
 * 
 * @param <N> The type of Number (e.g., Integer, Float, Double) this matrix will
 *            store.
 * 
 * @author Danny-Wits
 */
@SuppressWarnings("unchecked")
class Matrix<N extends Number> {
    // !FIELDS
    // Wrapped 2D array representing the matrix.
    private N[][] array = null;

    // !GETTERS AND SETTERS
    /**
     * Gets the internal 2D array representing the matrix.
     * 
     * @return 2D array of type N[][]
     */
    public N[][] getArray() {
        return array;
    }

    /**
     * Returns the number of rows in the matrix.
     * 
     * @return The number of rows in the matrix.
     */
    public int rowCount() {
        return array.length;
    }

    /**
     * Returns the number of columns in the matrix.
     * 
     * @return The number of columns in the matrix.
     */
    public int columnCount() {
        return array[0].length;
    }

    /**
     * Retrieves the specified row from the matrix.
     * 
     * @param index The index of the row to retrieve.
     * @return The row as an array of type N[].
     * @throws MatrixException If the row index is out of bounds.
     */
    public N[] getRow(int index) {
        if (index < 0 || index >= rowCount()) {
            throw OutOfBoundOfMatrix;
        }

        var row = (N[]) new Number[columnCount()];
        for (int i = 0; i < row.length; i++) {
            row[i] = array[index][i];
        }
        return row;
    }

    /**
     * Retrieves the specified column from the matrix.
     * 
     * @param index The index of the column to retrieve.
     * @return The column as an array of type N[].
     * @throws MatrixException If the column index is out of bounds.
     */
    public N[] getColumn(int index) {
        if (index < 0 || index >= columnCount()) {
            throw OutOfBoundOfMatrix;
        }

        var column = (N[]) new Number[rowCount()];
        for (int i = 0; i < column.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }

    // !CONSTRUCTORS
    /**
     * Default constructor that creates an empty matrix.
     */
    public Matrix() {

    }

    /**
     * Constructs a matrix from a provided 2D array.
     * 
     * @param array A 2D array of type N[][].
     * @throws MatrixException If the provided array has invalid dimensions.
     */
    public Matrix(N[][] array) {
        if (!isValidLength(array)) {
            throw ZeroLengthException;
        }
        this.array = array;
    }

    /**
     * Constructs a matrix from a provided 1D array, interpreting it as a single row
     * matrix.
     * 
     * @param array A 1D array of type N[].
     * @throws MatrixException If the provided array has invalid dimensions.
     */
    public Matrix(N[] array) {
        this((N[][]) new Number[][] { array });
    }

    // !DISPLAY

    /**
     * Returns a string representation of the matrix, formatted as rows and columns.
     * 
     * @return A string representing the matrix.
     */
    @Override
    public String toString() {
        if (!isValidLength(array)) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (N[] row : array) {
            for (N number : row) {
                sb.append(number.toString() + " | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Prints the matrix to the console.
     * 
     * @return The matrix itself (for method chaining).
     * @throws MatrixException If the matrix has invalid dimensions.
     */
    public Matrix<N> print() {
        if (!isValidLength(array)) {
            throw ZeroLengthException;
        }

        System.out.println("-----------------------");
        System.out.print(this.toString());
        System.out.println("-----------------------");
        return this;
    }

    // ! Custom Matrix Exceptions

    /**
     * Custom exception for matrix-related errors.
     */
    static class MatrixException extends RuntimeException {
        MatrixException(String msg) {
            super(msg, new Throwable("Error in Matrix"), false, true);
        }
    }

    static MatrixException ZeroLengthException = new MatrixException("Empty Matrix");
    static MatrixException OutOfBoundOfMatrix = new MatrixException("Matrix index out of bounds");

    // !FUNCTIONALITY && HELPER FUNCTIONS
    /**
     * Applies the provided function to each element in the matrix.
     * 
     * @param F A consumer function that takes an element of type N and processes
     *          it.
     */
    public void forEach(Consumer<N> F) {
        for (N[] row : array) {
            for (N number : row) {
                F.accept(number);
            }
        }
    }

    /**
     * Validates if the provided array has valid dimensions for a matrix.
     * 
     * @param array A 2D array of type T[][].
     * @param <T>   The type of elements in the array (must extend Number).
     * @return True if the array has valid dimensions, false otherwise.
     */
    private static <T extends Number> boolean isValidLength(T[][] array) {
        if (array == null) {
            return false;
        }
        if (array.length <= 0) {
            return false;
        }
        if (array[0].length <= 0) {
            return false;
        }
        return true;
    }

    /**
     * Creates a matrix of the specified size filled with zeroes (for Float type).
     * 
     * @param rows    The number of rows in the matrix.
     * @param columns The number of columns in the matrix.
     * @return A matrix of size rows x columns filled with zeroes.
     * @throws MatrixException If the matrix size is invalid.
     */
    static Matrix<Float> getMatrixOfSize(int rows, int columns) {
        var array = new Float[rows][columns];
        if (!isValidLength(array)) {
            throw ZeroLengthException;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0F;
            }
        }

        return new Matrix<>(array);
    }
}
