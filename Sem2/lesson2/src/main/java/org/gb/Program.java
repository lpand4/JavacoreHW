package org.gb;

import javax.lang.model.type.PrimitiveType;
import java.util.Random;
import java.util.Scanner;

public class Program {

    final private static int WIN_COUNT = 4;
    final private static char DOT_HUMAN = 'X'; // Фишка игрока - человек
    final private static char DOT_AI = '0'; // Фишка игрока - компьютер
    final private static char DOT_EMPTY = '*'; // Признак пустого поля
    final private static Scanner sc = new Scanner(System.in);
    final private static Random rnd = new Random();
    private static char[][] field; //Двумерный массив хранит текущее состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победа компьютера!"))
                    break;
            }
            System.out.println("Желаете сыгарть еще раз? Y - да N - нет");
            if (!sc.next().equalsIgnoreCase("Y"))
                break;
        }

    }

    /**
     * Инициализация объектов игры
     */
    private static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printField() {
        //Верхняя часть с цифрами
        System.out.print(" ");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? " " : i / 2 + 1);
        }
        System.out.println("");

        //Верхняя часть поля
        System.out.print(" ");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            if (i == 0){
                System.out.print("┌");
            }else if(i == fieldSizeX * 2){
                System.out.print("┐");
            }else {
                System.out.print((i % 2 == 0) ? "┬": "─" );
            }
        }

        // Тело поля
        System.out.println(" ");
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "│");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "│");
            }
            System.out.println();
            System.out.print(" ");
            if(i < fieldSizeY - 1){
                for (int j = 0; j < fieldSizeX * 2 + 1; j++) {
                    if (j == 0){
                        System.out.print("├");
                    }else if(j == fieldSizeX * 2){
                        System.out.print("┤");
                    }else {
                        System.out.print((j % 2 == 0) ? "┼": "─" );
                    }
                }
                System.out.println();
            }

        }
        //Нижняя часть поля
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            if (i == 0){
                System.out.print("└");
            }else if(i == fieldSizeX * 2){
                System.out.print("┘");
            }else {
                System.out.print((i % 2 == 0) ? "┴": "─" );
            }
        }
        System.out.println();
    }

    /**
     * Обработка хода игрока
     */
    private static void humanTurn() {
        int x, y;
        do {

            while (true){
                System.out.println("Введите координаты хода Y(от 1 до 3) >>> ");
                if(sc.hasNextInt()) {
                    x = sc.nextInt() - 1;
                    sc.nextLine();
                    break;
                }
                else
                {
                    System.out.println("Введено неверное значение!");
                    sc.nextLine();
                }
            }
            while (true){
                System.out.println("Введите координаты хода X(от 1 до 3) >>> ");
                if(sc.hasNextInt()) {
                    y = sc.nextInt() - 1;
                    sc.nextLine();
                    break;
                }
                else
                {
                    System.out.println("Введено неверное значение!");
                    sc.nextLine();
                }
            }
            System.out.println("Вы вышли за пределы поля или на чужую ячейку!");
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, является ли ячейка пустой
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка координат на валидность
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn() {
        int x, y;
        do {
            //System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = rnd.nextInt(fieldSizeX);
            y = rnd.nextInt(fieldSizeY);
        } while (!isCellEmpty(y, x));
        field[y][x] = DOT_AI;
    }

    /**
     * Состояние игры
     *
     * @param c фишка игрока
     * @param s победный слоган
     */
    private static boolean checkGameState(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkTie()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;

    }


    /**
     * Проверка нг победу
     *
     * @param c
     * @return
     */
    private static boolean checkWin(char c) {

        //Проверка по трем горизонталям
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
        //Проверка по трем вертикалям
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
        //Проверка по диагоналям
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    private static boolean checkTie() {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellEmpty(i, j)) return false;
            }
        }
        return true;
    }


}
