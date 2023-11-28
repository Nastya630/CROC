import java.util.HashMap;
/**
 * Класс для выполнения пераого задания
 *
 * @author Ivanova Anastasiya
 */
public class FirstTask {
    /**
     * Метод для выполнения пераого задания
     * @param salesmen данные о продавцах
     * @param deal данные о сделках
     */
    public static void first(HashMap<Integer, Salesman> salesmen, HashMap<Integer, Deal> deal) {
        HashMap<Salesman, Integer> topSalesmen = new HashMap<>();
        salesmen.forEach((key, value) -> {
            topSalesmen.put(value,0); //Считываем всех продавцов
        });
        deal.forEach((key, value) -> {
            if(topSalesmen.containsKey(salesmen.get(value.getIdSalesman()))){
                topSalesmen.replace(salesmen.get(value.getIdSalesman()), topSalesmen.get(salesmen.get(value.getIdSalesman()))+ value.getQuantity());
            }
        });
        try {//Записываем результат
            XMLWriter.PrintFirst(topSalesmen);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
