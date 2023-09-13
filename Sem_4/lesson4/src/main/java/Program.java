import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    /*
    1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
        подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

    3 В методе main() вызвать полученный метод, обработать возможные исключения
        MyArraySizeException и MyArrayDataException и вывести результат расчета.
     */
    private static final Random random = new Random();


    public static void main(String[] args) {
        // Создаем 10 тестовых массивов
        String[][][] testArrays = new String[10][][];
        for (int i = 0; i < testArrays.length; i++) {
            System.out.printf("\nТестовый массив номер %d\n", i + 1);
            testArrays[i] = generateArray();
            printArray(testArrays[i]);
        }
        // Начинаем тестить
        System.out.println("---------Начало тестов----------\n");

        for (int i = 0; i < testArrays.length; i++) {
            try {
                System.out.printf("Сумма элементов тестового массива #%d = %d\n", i + 1, sumOfArray(testArrays[i]));
            } catch (MyArrayDataException e) {
                System.out.printf("В ячейке (%d,%d) тестового массива найден символ типа не int\n", e.getIndex()[0], e.getIndex()[1]);
            } catch (NonSquareArrayException e) {
                System.out.printf("Массив является не квадратным в строчках %s\n", e.getIndexRow().toString());
            } catch (MyArraySizeException e) {
                System.out.printf("Размерность массива отличается от 4х4 и составляет %dx%d\n", e.getSize()[0], e.getSize()[1]);
            }
        }
    }

    /**
     * Сумма элементов двумерного массива
     * @param array Двумерный массив
     * @return Результат суммы
     * @throws MyArraySizeException неверный размер массива
     * @throws MyArrayDataException неверный символ в массиве
     */
    public static int sumOfArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            if (checkForSquare(array).size() != 0) {
                throw new NonSquareArrayException("Массив является не квадратным!", checkForSquare(array));
            } else {
                throw new MyArraySizeException("Массив должен быть размрностью 4х4", new int[]{array.length, array[0].length});
            }
        }
        if (checkForSquare(array).size() != 0) {
            throw new NonSquareArrayException("Массив является не квадратным!", checkForSquare(array));
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += parseInt(array[i][j]);
                } catch (MyArrayDataException e) {
                    throw new MyArrayDataException(e.getMessage(), new int[]{i, j});
                }
            }
        }
        return sum;
    }


    /**
     * Перевод строки в число
     * @param value Строка, которую нужно перевести
     * @return Значение числа
     * @throws MyArrayDataException Неверное значение в строке
     */
    private static int parseInt(String value) throws MyArrayDataException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Неверный символ!");
        }
    }

    /**
     * Проверка на квадратность двумерного массива
     * @param array двумерный массив
     * @return лист строк, отличающихся по размеру
     */
    private static List<Integer> checkForSquare(String[][] array) {
        List<Integer> nonSquareRows = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array.length) {
                nonSquareRows.add(i);
            }
        }
        return nonSquareRows;
    }

    /**
     * Генератор двумерных массивов, подходящих под задачу и сломанных
     * @return двумерный массив
     */
    private static String[][] generateArray() {
        String[][] resArray;
        if (random.nextInt(2) == 0) {
            resArray = new String[4][4];
        } else {
            resArray = new String[3][3];
        }
        for (int i = 0; i < resArray.length; i++) {
            for (int j = 0; j < resArray[i].length; j++) {
                if (random.nextInt(50) < 48) {
                    resArray[i][j] = String.valueOf(random.nextInt(6));
                } else {
                    resArray[i][j] = "ERR";
                }
            }
        }
        return resArray;
    }

    /**
     * Вывод двумерного массива на экран
     * @param array двумерный массив
     */
    private static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%s ", array[i][j]);
            }
            System.out.println();
        }
    }
}
