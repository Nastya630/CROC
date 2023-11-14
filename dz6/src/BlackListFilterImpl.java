import java.io.*;
import java.util.*;

/**
 * Класс, реализующий интерфейс BlackListFilter. Фильтрует комментарии.
 * @author Ivanova Anastasiya
 *
 */
public class BlackListFilterImpl implements BlackListFilter {
    ArrayList<String> comments = new ArrayList<>();
    HashSet<String> blackList=new HashSet<>();

    /**
     * Конструктор, который записывает прочитанные данные из файлов.
     * @param comm - поток, из которого мы читаем комментарии.
     * @param black - поток, из которого мы читаем запретные слова.
     */
    public BlackListFilterImpl(FileReader comm, FileReader black){
        Scanner s=new Scanner(comm);
        while(s.hasNextLine()){
            comments.add(s.nextLine());//Записываем комментарии в List comments.
        }
        s = new Scanner(black);
        while(s.hasNextLine()){
            Collections.addAll(blackList,s.nextLine().split(" "));//Записываем в set запрещённые слова.
        }
    }

    /**
     * Метод, фильтрующий комментарии и записывающий их в файл.
     * @param comments list of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        Iterator<String> it=comments.iterator();
        while (it.hasNext()){
            String str=it.next().toLowerCase();
            String[] comment =str.split("[\\p{P} \\t\\n\\r]");//Удаляем все лишние символы.
            for (String s : comment) {
                if (blackList.contains(s)) { //Проверяем есть слово среди запрещённых.
                    it.remove(); //Удаляем комментарий с запрещённым словом.
                    break;
                }
            }
        }
        try(FileWriter outputStream =new FileWriter("output.txt")){
            for (String str : comments){
                outputStream.write(str + '\n'); //Записываем оставшиеся комментарии в файл.

            }

        } catch (IOException e) {
            System.out.println("Файла не существует");
        }

    }
}
