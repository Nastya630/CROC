package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends Exception {
    /**
     * Конструктор с сообщением
     * @param sos - строка с сообщением об ошибке
     */
    public IllegalMoveException(String sos){
        super(sos);
    }
}
