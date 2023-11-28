/**
 * Класс для создания товаров в наличии
 *
 * @author Ivanova Anastasiya
 */
public class Available {
    private int idSeller;
    private int idProduct;
    private int cost;
    private int quantity;

    /**
     * Конструктор
     * @param idSeller id продавца
     * @param idProduct id продукт
     * @param cost цена товара
     * @param quantity количество товара
     */
    public Available(int idSeller, int idProduct, int cost, int quantity) {
        this.idSeller = idSeller;
        this.idProduct = idProduct;
        this.cost = cost;
        this.quantity = quantity;
    }

    /**
     * Получение id продукта
     * @return id продукта
     */
    public int getIdProduct() {
        return idProduct;
    }
    /**
     * Получение количества продукта
     * @return количества продукта
     */
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Available{" +
                "idSeller=" + idSeller +
                ", idProduct=" + idProduct +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
