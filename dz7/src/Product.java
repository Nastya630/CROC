/**
 * Класс для создания продуктов
 *
 * @author Ivanova Anastasiya
 */
public class Product {
    private int id;
    private String name;

    /**
     *  Конструктор
     * @param id id продукта
     * @param name название продукта
     */
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Получение названия
     * @return название продукта
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
