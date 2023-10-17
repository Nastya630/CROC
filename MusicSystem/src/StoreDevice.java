/**
 * Класс описывает носители
 * @author Иванова Анастасия
 */
public class StoreDevice {
    String deviceName;

    /**
     * Конструктор класса StoreDevice
     * @param deviceName название носителя
     */
    public StoreDevice(String deviceName){
        this.deviceName=deviceName;
    }

    /**
     * Метод для получения названия устройства носителя
     * @return название носителя
     */
    public String getDeviceName() {
        return deviceName;
    }
}
