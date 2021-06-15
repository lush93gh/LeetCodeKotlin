package geometry

class N1401MCircleAndRectangleOverlapping {
    fun Int.square(): Int {
        return this * this
    }

    fun squareDistance(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        return (x1 - x2).square() + (y1 - y2).square()
    }

    fun checkOverlap(radius: Int, x_center: Int, y_center: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        val rSquare = radius.square()
        val closestX = x_center.coerceIn(x1, x2)
        val closestY = y_center.coerceIn(y1, y2)

        return squareDistance(closestX, closestY, x_center, y_center) <= rSquare
    }
}