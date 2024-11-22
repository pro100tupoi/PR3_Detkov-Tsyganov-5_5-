class Triangle(val a: Point, val b: Point, val c: Point) {

    fun area(): Double {
        return Math.abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0)
    }

    fun isPointInside(point: Point): Boolean {
        val areaABC = area()
        val areaPAB = Triangle(point, a, b).area()
        val areaPBC = Triangle(point, b, c).area()
        val areaPCA = Triangle(point, c, a).area()
        return Math.abs(areaABC - (areaPAB + areaPBC + areaPCA)) < 1e-10
    }
}
