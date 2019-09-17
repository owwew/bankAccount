package kata.bankAccount

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BankAccountApplication

fun main(args: Array<String>) {
	runApplication<BankAccountApplication>(*args)
}
