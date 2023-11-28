import java.time.LocalDate;
import java.util.HashMap;

/**
 * Класс для выполнения второго задания
 *
 * @author Ivanova Anastasiya
 */
public class SecondTask {
    /**
     * метод для выполнения второго задания
     * @param deal все сделки
     */
    public static void second(HashMap<Integer, Deal> deal) {
        HashMap<LocalDate, Integer> topDate = new HashMap<>();
        deal.forEach((key, value) -> {
            topDate.put(value.getDate(),0); //Считываем все даты
        });
        deal.forEach((key, value) -> {
            if(topDate.containsKey(value.getDate())){
                topDate.replace(value.getDate(), topDate.get(value.getDate())+ value.getQuantity());
            }
        });
        try {//Записываем результат
            XMLWriter.PrintSecond(topDate);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
