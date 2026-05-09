

fun main() {
    val quiz = Quiz()
    quiz.printProgressBar()

    // Usando extensiones genéricas
    val question1 = Question("¿Cuál es el océano más grande?", "Pacífico", Difficulty.EASY)
    val question2 = Question("¿Cuántos planetas tiene el sistema solar?", "8", Difficulty.MEDIUM)
    val question3 = Question("¿Qué lenguaje usa Android moderno?", "Kotlin", Difficulty.HARD)

    question1.printQuestion()
    question2.printQuestion()
    question3.printQuestion()
}

enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

fun <T> Question<T>.printQuestion() {
    println("Pregunta: $questionText")
    println("Respuesta: $answer")
    println("Dificultad: $difficulty")
    println("---")
}

class Quiz {
    val question1 = Question("¿Cuál es el océano más grande?", "Pacífico", Difficulty.EASY)
    val question2 = Question("¿Cuántos planetas tiene el sistema solar?", 8, Difficulty.MEDIUM)
    val question3 = Question("¿Qué lenguaje usa Android moderno?", true, Difficulty.HARD)

    companion object {
        val questionCount = 3
    }

    fun printProgressBar() {
        repeat(Quiz.questionCount) { print("▓") }
        println()
        println("${Quiz.questionCount} preguntas en total")
    }
}