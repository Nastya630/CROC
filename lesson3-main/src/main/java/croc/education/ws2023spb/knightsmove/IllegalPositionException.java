package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если конь на некорректных позициях
 *
 * @author Ivanova Anastasiya
 */
public class IllegalPositionException extends RuntimeException{
    /**
     * Конструктор, создающий исключение с сообщением
     */
    public IllegalPositionException(){
        super("Задана неверная позиция.");
    }
}
