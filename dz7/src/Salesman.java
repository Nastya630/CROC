/**
 * Класс для создания продавцов
 *
 * @author Ivanova Anastasiya
 */
public class Salesman {
    private int id;
    private String name;
    private String lastName;
    /**
     * Конструктор
     * @param id id продавца
     * @param name Имя продавца
     * @param lastName Фамиилия продавца
     */
    public Salesman(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    /**
     * Получение id продавца
     * @return id продавца
     */
    public int getId() {
        return id;
    }
    /**
     * Получение имени продавца
     * @return имя продавца
     */
    public String getName() {
        return name;
    }
    /**
     * Получение фаимилии продавца
     * @return фамилия продавца
     */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}