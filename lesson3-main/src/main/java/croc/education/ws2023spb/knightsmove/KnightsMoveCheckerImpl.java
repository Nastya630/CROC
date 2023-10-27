package croc.education.ws2023spb.knightsmove;

/**
 * Класс, отвечающий за проверку возможности хода
 *
 * @author Ivanova Anastasiya
 */
public class KnightsMoveCheckerImpl implements KnightsMoveChecker{
    /**
     *
     * @param positions
     *            последовательность клеток на шахматной доске, которую надо обойти от предыдущей клетки к следующей
     * @throws IllegalMoveException
     *            если при перемещении шахматного коня из текущей клетки в следующую происходит с нарушением правил
     */
    @Override
    public void check(String[] positions) throws IllegalMoveException {
        if (positions.length>0) {
            ChessPositionImpl pos1 = new ChessPositionImpl(positions[0]);
            for (int i = 1; i < positions.length; i++) {
                ChessPositionImpl pos2 = new ChessPositionImpl(positions[i]);
                /*Проверяем по методу Вандермонда, что ход может быть совершён, если он невозможен, то кидаем исключение*/
                if (Math.abs(pos1.x() - pos2.x()) == 1 && Math.abs(pos1.y() - pos2.y()) == 2 || Math.abs(pos1.x() - pos2.x()) == 2 && Math.abs(pos1.y() - pos2.y()) == 1) {
                    pos1 = pos2;
                } else {
                    String sos = "конь так не ходит: " + pos1.toString() + " -> " + pos2.toString();
                    throw new IllegalMoveException(sos);
                }
            }
        }
    }
}
