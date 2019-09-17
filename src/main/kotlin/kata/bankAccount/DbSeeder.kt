package kata.bankAccount

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DbSeeder(val accountRepository: AccountRepository,val historyRepository: HistoryRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        this.accountRepository.deleteAll()
        this.historyRepository.deleteAll()

        val user1 = "Aminekasmi"
        val user2 = "Claire DELFORGE"

        val accountUser1 = Account(user1)
        val accountUser2 = Account(user2)
        this.accountRepository.save(accountUser1)
        this.accountRepository.save(accountUser2)

        val historyUser1 = History(user1, "New Account",0,LocalDateTime.now())
        val historyUser2 = History(user2, "New Account",0,LocalDateTime.now())
        this.historyRepository.save(historyUser1)
        this.historyRepository.save(historyUser2)

        println("----  ******* Database has benn initialized ! ******* --------")
    }
}