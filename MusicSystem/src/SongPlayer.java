/**
 * Класс описывает проигрывающее устройство
 * @author Иванова Анастасия
 */
public class SongPlayer {

    private String playerDevice;
    private String storeNeeded;

    /**
     * Конструктор класса SongPlayer для универсального проигрывателя, устанавливает storeNeeded "Any"
     * @param playerDevice название устройства
     */
    public SongPlayer(String playerDevice){
        this.playerDevice=playerDevice;
        this.storeNeeded = "Any";
    }

    /**
     * Конструктор класса SongPlayer
     * @param playerDevice название устройства
     * @param storeNeeded строка с названием носителя, с которого можем воспроизвести песню
     */
    public SongPlayer(String playerDevice, String storeNeeded){
        this.playerDevice=playerDevice;
        this.storeNeeded = storeNeeded;
    }

    /**
     * Конструктор класса SongPlayer
     * @param playerDevice название устройства
     * @param storeNeeded объект SongStorage, носитель, с которого можем воспроизвести песню
     */
    public SongPlayer(String playerDevice, StoreDevice storeNeeded){
        this.playerDevice=playerDevice;
        this.storeNeeded = storeNeeded.getDeviceName();
    }

    /**
     * Метод, проверяет можем ли мы воспроизвести песню на данном устройстве
     * @param song Песня
     * @return true, если устройство совместимо с песней, иначе false.
     */
    public boolean isPlayable(Song song) {
        return storeNeeded.equalsIgnoreCase(song.getStorage());
    }

    /**
     * Метод вопсроизводящий песню, выводит данные, если может ее сыграть, иначе выводит ошибку
     * @param song песня, которую хотим сыграть
     */
    public void playSong(Song song){
        if(storeNeeded.equals("Any") || isPlayable(song)){
        System.out.println(song+"\nПроигрыватель: "+playerDevice+"\n");
        }
        else {
            System.out.println("Нельзя воспроизвести песню с этого носителя на этом проигрывателе, ожидаемый носитель:"+storeNeeded+"\n");
        }
    }
}
