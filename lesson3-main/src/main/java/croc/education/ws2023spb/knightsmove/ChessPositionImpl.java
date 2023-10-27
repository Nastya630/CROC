package croc.education.ws2023spb.knightsmove;

/**
 * Класс, создающий объект с позицией фигуры. Реализует интерфейс ChessPosition.
 *
 * @author Ivanova Anastasiya
 */
public class ChessPositionImpl implements ChessPosition{
    String pos;
    private int posX, posY;

    /**
     * Конструктор, преобразующий координаты из строки в числовые значения
     * @param position
     */
    public ChessPositionImpl(String position){
        posX=position.charAt(0)-97;
        posY=position.charAt(1)-49;
        pos=position;
    }

    /**
     *
     * @return позиция по горизонтали
     */
    @Override
    public int x() {
        return posX;
    }

    /**
     *
     * @return позиция по вертикали
     */
    @Override
    public int y() {
        return posY;
    }

    /**
     *
     * @return строка с позицией, в соответствии с шахматными правилами
     */
    @Override
    public String toString() {
        return pos;
    }
}
