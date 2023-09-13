public class MyArraySizeException extends Exception {
    private int[] size;

    public MyArraySizeException(String message, int[] size) {
        this(message);
        this.size = size;
    }

    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException() {

    }

    public int[] getSize() {
        return size;
    }
}
