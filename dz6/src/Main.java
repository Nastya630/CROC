import java.io.FileReader;
import java.io.IOException;

/**
 * Программа, фильтрующая комментарии.
 * @author Ivanova Anastasiya
 *
 */
public class Main {
    /**
     * Основной метод
     * @param args - не используются
     */
    public static void main(String[] args) {
        try(FileReader comm = new FileReader("comments.txt"); FileReader black = new FileReader("blackList.txt")){
            BlackListFilterImpl x = new BlackListFilterImpl(comm, black); //Создание объекта класса BlackListFilterImpl
            x.filterComments(x.comments, x.blackList);//Вызов метода класса BlackListFilterImpl
        } catch (IOException e) {
            System.out.println("Файла не существует.");
        }
    }
}