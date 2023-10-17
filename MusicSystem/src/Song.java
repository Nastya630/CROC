/**
 * Класс описывает песни
 * @author Иванова Анастасия
 */
public class Song {
    private String singer;
    private String song;
    private String storage;

    /**
     * Конструтор класса Song
     * @param singer имя певца
     * @param song название песни
     * @param storage устройство-носитель
     */
    public Song(String singer, String song, String storage){
        this.singer=singer;
        this.song=song;
        this.storage=storage;
    }

    /**
     * Метод для получения имени певца
     * @return имя певца
     */
    public String getSinger() {
        return singer;
    }

    /**
     * Метод для получения названия песни
     * @return название песни
     */
    public String getSong() {
        return song;
    }

    /**
     * Метод для получения носителя
     * @return носитель
     */
    public String getStorage() {
        return storage;
    }

    /**
     * Метод для преобразования объекта к строке для вывода
     * @return строку содержащую имя певца, название песни и носитель
     */
    public String toString() {
        return "Певец: "+singer+"\nНазвание песни: "+song+"\nНоситель песни: "+storage;
    }
}
