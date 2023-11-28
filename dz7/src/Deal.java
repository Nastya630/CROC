import java.time.LocalDate;

/**
 * Класс для создания сделок
 *
 * @author Ivanova Anastasiya
 */
public class Deal {
    private int idSale;
    private int idSeller;
    private int idProduct;
    private int quantity;
    private LocalDate date;

    /**
     * Конструктор
     * @param idSale id продажи
     * @param idSeller id продавца
     * @param idProduct id продукта
     * @param quantity количсетво проданного продукта
     * @param date дата продажи
     */
    public Deal(int idSale, int idSeller, int idProduct, int quantity, LocalDate date) {
        this.idSale = idSale;
        this.idSeller = idSeller;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     * Получение количсетва проданного продукта
     * @return количсетво проданного продукта
     */
    public int getQuantity() {
        return quantity;
    }

    public int getIdSalesman() {
        return idSeller;
    }

    /**
     * Получение даты продажи
     * @return дата продажи
     */
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", idSeller=" + idSeller +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
