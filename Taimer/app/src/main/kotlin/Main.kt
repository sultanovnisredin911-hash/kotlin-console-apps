import java.util.*

fun main() {
        val scanner = Scanner(System.`in`)

        println("Секундомер. Нажмите Enter для запуска, затем Enter — для остановки.")
        scanner.nextLine() // Ожидаем нажатия Enter для старта

        val startTime = System.currentTimeMillis()
        println("Секундомер запущен... Нажмите Enter для остановки.")

        // Запускаем отдельный поток, чтобы проверять ввод
        var stopRequested = false
        Thread {
            scanner.nextLine()
            stopRequested = true
        }.start()

        // Основной цикл: отображаем время
        while (!stopRequested) {
            val elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000
            print("\r${formatTime(elapsedSeconds)}")
            Thread.sleep(100) // Обновляем каждые 100 мс (плавнее)
        }

        val totalSeconds = (System.currentTimeMillis() - startTime) / 1000
        println("\nСекундомер остановлен. Прошло: ${formatTime(totalSeconds)}")
    }

    fun formatTime(seconds: Long): String {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60
        return String.format("%02d:%02d:%02d", hours, minutes, secs)
    }
