import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;


import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {

    // 1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup
    public static void main(String[] args) throws IOException {
        createBackupDir(new File("."));
    }


    /**
     * Создает папку бэкап и копирует туда все
     * @param dir Источник бэкапа
     * @throws IOException
     */
    private static void createBackupDir(File dir) throws IOException {
        File[] savedDir = dir.listFiles();
        File backupDir = new File(dir.getPath() +"/backup");
        if(!backupDir.exists()){
            backupDir.mkdir();
        }else {
            deleteDir(backupDir);
            backupDir.mkdir();
        }
        for (File file:savedDir){
            if(!file.getName().equals(backupDir.getName())){
                Files.copy(file.toPath(),
                        new File(backupDir.getPath() + "/" + file.getName()).toPath(),
                        REPLACE_EXISTING);
                if(file.isDirectory()){
                    createBackupDir(file.toPath().toFile(), new File(backupDir.getPath() + "/" + file.getName()));
                }
            }
        }
    }

    /**
     * Удаляет директорию и все что в ней находится
     * @param directory Директория для удаления
     * @throws IOException
     */
    public static void deleteDir(File directory) throws IOException {
        Files.walk(directory.toPath())
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    /**
     * Перегрузка бэкапа для внутренних папок изначальной директории
     * @param sourceDir Откуда копирует
     * @param backupDir Куда копирует
     * @throws IOException
     */
    private static void createBackupDir(File sourceDir, File backupDir) throws IOException {
        File[] savedDir = sourceDir.listFiles();
        if(!backupDir.exists()){
            backupDir.mkdir();
        }
        for (File file:savedDir){
            Files.copy(file.toPath(),
                    new File(backupDir.getPath() + "/" + file.getName()).toPath(),
                    REPLACE_EXISTING);
            if(file.isDirectory()){
                createBackupDir(file.toPath().toFile(), new File(backupDir.getPath() + "/" + file.getName()));
            }
        }

    }
}
