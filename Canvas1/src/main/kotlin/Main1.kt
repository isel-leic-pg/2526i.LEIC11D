import pt.isel.canvas.*

fun main() {
    print("Begin ")
    onStart {
        val arena = Canvas(300, 200, CYAN)
        print("Start ")
    }
    onFinish { }
    print("End ")
}
