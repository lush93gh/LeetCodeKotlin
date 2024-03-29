package mathAndLogicPuzzles.geometry

class RectangleOverlap {
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        return !(rec1[1] >= rec2[3] || rec2[1] >= rec1[3]
                || rec1[2] <= rec2[0] || rec2[2] <= rec1[0])
    }
}