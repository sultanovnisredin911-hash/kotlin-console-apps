fun main() {
    while (true) {
        println("Salam Введи первое число!")
        val input1 = readLine()
        if (input1 == null || input1.isEmpty()) {
            println("Error is empty")
            return
        }


        val num1 = try {
            input1.toInt()
        } catch (e: NumberFormatException) {
            println("Ошибка: $input1 не является числом!")
            return
        }
        println("Введите второе число!")
        val input2 = readLine()
        if (input2 == null || input2.isEmpty()) {
            println("Ошибка пустой ввод")
            return
        }
        val num2 = try {
            input2.toInt()
        } catch (e: NumberFormatException) {
            println("Ошибка $input2 не является числом")
            return
        }
        println("Введите операцию(+,-,*,/)")
        val operation = readLine()?.trim()

        if (operation == null || operation.isEmpty()) {
            println("Ошибка не введена операция")
            return
        }

        val result = when (operation) {
            "+"-> num1 + num2
            "-"->num1 - num2
            "*"->num2 * num2
            "/"-> {
                if (num2 == 0){
                    println("Ошибка:деление на ноль!")
                    return
                }
                num1/num2
            }

            else -> {
                println("Ошибка:неподдерживаемые операции $operation,Используйте(+,-,*,/ ):")
                return
            }
        }
        println("Result:$result")
    }
}