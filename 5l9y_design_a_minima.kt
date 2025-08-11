import java.io.File

fun main() {
    val analyzer = CLIAnalyzer()
    val fileContent = """
        fun add(a: Int, b: Int): Int {
            return a + b
        }
    """.trimIndent()

    val file = File("test.kt")
    file.writeText(fileContent)

    analyzer.analyze(file)

    file.delete()
}

class CLIAnalyzer {
    fun analyze(file: File) {
        val lines = file.readLines()
        val lineCount = lines.size
        val charCount = lines.sumOf { it.length }
        val methodCount = lines.filter { it.contains("fun ") }.size

        println("File Analysis Results:")
        println("File Name: ${file.name}")
        println("Line Count: $lineCount")
        println("Character Count: $charCount")
        println("Method Count: $methodCount")
    }
}