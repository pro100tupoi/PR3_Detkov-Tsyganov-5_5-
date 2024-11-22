import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод координат треугольника
    val trianglePoints = mutableListOf<Point>()
    for (i in 1..3) {
        while (true) {
            try {
                println("Введите координаты вершины $i (формат: x y):")
                val input = scanner.nextLine().trim().split(" ")
                if (input.size != 2) throw IllegalArgumentException("Неверный формат ввода.")

                val x = input[0].toDouble()
                val y = input[1].toDouble()
                trianglePoints.add(Point(x, y))
                break
            } catch (e: NumberFormatException) {
                println("Ошибка: введите числовые значения для координат.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    val triangle = Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2])

    // Ввод координат точки
    var testPoint: Point? = null
    while (testPoint == null) {
        try {
            println("Введите координаты точки для проверки (формат: x y):")
            val input = scanner.nextLine().trim().split(" ")
            if (input.size != 2) throw IllegalArgumentException("Неверный формат ввода.")

            val x = input[0].toDouble()
            val y = input[1].toDouble()
            testPoint = Point(x, y)
        } catch (e: NumberFormatException) {
            println("Ошибка: введите числовые значения для координат.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    // Проверка, находится ли точка внутри треугольника
    val isInside = triangle.isPointInside(testPoint)
    if (isInside) {
        println("Точка $testPoint находится внутри треугольника.")
    } else {
        println("Точка $testPoint находится вне треугольника.")
    }
}
