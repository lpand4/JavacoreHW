public class MyArrayDataException extends MyArraySizeException{
    private int[] index;

    public MyArrayDataException(String message, int[] index) {
        super(message);
        this.index = index;
    }

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException() {
        super();
    }

    public int[] getIndex() {
        return index;
    }
}
