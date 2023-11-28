import java.util.HashMap;

/**
 * Стартовый класс.
 *
 * @author Ivanova Anastasiya
 */
public class Main {
    /**
     * Стартовый метод
     * @param args стартовые аргументы
     */
    public static void main(String[] args) {
        HashMap<Integer, Product> products = new HashMap<>();
        HashMap<Integer, Salesman> salesmen = new HashMap<>();
        HashMap<Integer, Available> available = new HashMap<>();
        HashMap<Integer, Deal> deal = new HashMap<>();
        try {
            //Считыние XML файлов
            //ProductReader.read(products,"files/Products.xml");
            SalesmanReader.read(salesmen,"files/Salesmen.xml");
            //AvailableReader.read(available,"files/Available.xml");
            DealReader.read(deal,"files/Deals.xml");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        FirstTask.first(salesmen,deal);
        SecondTask.second(deal);
    }
}