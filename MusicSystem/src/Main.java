import java.util.Scanner;
/**
 * Класс показывающий работу музыкальной системы с использованием классов StoreDevice, SongPlayer, Song
 * @author Иванова Анастасия
 */
public class Main {
    /**
     * Главный метод программы
     * @param args Массив аргументов командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Создаем носители
        StoreDevice flash = new StoreDevice("Flash");
        StoreDevice cd = new StoreDevice("CD");
        StoreDevice vinyl = new StoreDevice("Vinyl");

        //Создаем проигрыватели
        SongPlayer mp3 = new SongPlayer("mp3","flash");
        SongPlayer vinylPlayer = new SongPlayer("Виниловый проигрыватель",vinyl);
        SongPlayer universalPlayer = new SongPlayer("Универсальный проигрыватель");

        //Создаем песни
        Song[] songs = new Song[3];
        for (int i=0; i<3; i++){
            System.out.print("Введите исполнителя песни: ");
            String singer = scanner.nextLine();
            System.out.print("Введите название песни: ");
            String song = scanner.nextLine();
            System.out.print("Введите хранилище песни (CD, Vinyl, Flash): ");
            String storage = scanner.nextLine();
            songs[i] = new Song(singer,song,storage);
        }
        int player=1,number=1;
        //Пользователь может вводить номер проигрывателя и песни сколько хочет, может ввести 0 что-бы остановить
        while(number!=0){
            System.out.println("Если хотите закончить введите 0");
            System.out.print("На каком проигрывателе сыграть? 1-Универсальный 2-Виниловый 3-mp3: ");
            player=scanner.nextInt();
            if (player==0){
                break;
            }
            System.out.print("Какую песню из заданных сыграть? (От 1 до 3): ");
            number=scanner.nextInt();
            if(player==1 && number>0 && number<3){
                universalPlayer.playSong(songs[number-1]);
            }
            else if (player==2 && number>0 && number<3){
                vinylPlayer.playSong(songs[number-1]);
            }
            else if (player==3 && number>0 && number<3){
                mp3.playSong(songs[number-1]);
            }
            else if(number!=0){
                System.out.println("Неверный ввод");
            }
        }


    }
}