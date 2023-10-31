import java.io.*;
import java.util.*;

/**
 * @author Ivanova Anastasiya
 */
public class Main {
    /**
     *
     * @param args аргументы не используются
     */
    public static void main(String[] args){
        try(FileReader inputStream = new FileReader("input.txt"); FileWriter outputStream =new FileWriter("output.txt")) {
            HashMap<Character, Integer> map=Counter(inputStream); //Создаём HashMap, в который записываем символы и их количество в тексте
            map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(g-> { //сортируем в порядке убывания
                            try {
                                outputStream.write("'"+g.getKey()+ "'" +  "="+ g.getValue()+", ");//и записываем в файл output.txt
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }});
        }
        catch (IOException e){
            System.out.println("Файла не существует.");
        }
    }

    /**
     *
     * @param inputStream читаемый файл
     * @return HashMap с символами и их количеством
     * @throws IOException - если файла не существует
     */
    public static HashMap<Character, Integer> Counter(FileReader inputStream) throws IOException{
        HashMap<Character, Integer> map = new HashMap<>();
        int c;
        while ((c = inputStream.read()) != -1) {
            char key=(char)c;
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);//Увеличиваем значение для ключа
            }
            else if (key!='\n' && key!=' ' && key!='\r'){
                map.put(key, 1);//Добавляем новый символ
            }
        }
        return map;
    }
}