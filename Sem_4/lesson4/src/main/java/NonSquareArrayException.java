import java.util.List;

public class NonSquareArrayException extends MyArraySizeException{
    private final List<Integer> indexRow;

    public NonSquareArrayException(String message, List<Integer> indexRow) {
        super(message);
        this.indexRow = indexRow;
    }

    public List<Integer> getIndexRow() {
        return indexRow;
    }
}
