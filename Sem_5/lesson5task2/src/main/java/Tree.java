import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Tree {
    public static void main(String[] args) {

        print(new File("."), "", true);
    }

    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└────");
            indent += "     ";
        } else {
            System.out.print("├────");
            indent += "│    ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();

        if (files == null)
            return;
        files = sortFiles(files);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, i == files.length - 1);
            }
            else {
                print(files[i], indent, i == files.length - 1);
            }
        }
    }

    // Сделал, чтобы сначала вывлдились файлы, затем директории
    private static File[] sortFiles(File[] files){
        File[] result = new File[files.length];
        int i = 0;
        while (i != result.length){
            for (int j = 0; j < files.length; j++) {
                if (files[j].isFile()){
                    result[i] = files[j];
                    i++;
                }
            }
            for (int j = 0; j < files.length; j++) {
                if (files[j].isDirectory()){
                    result[i] = files[j];
                    i++;
                }
            }
        }
        return result;
    }

}
