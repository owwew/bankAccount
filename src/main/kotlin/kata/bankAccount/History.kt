package kata.bankAccount

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class History(var fullName: String, operationType: String, amount: Int, dateTime: LocalDateTime) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long = 0
    var operation = operationType
    var amount = amount
    var date = LocalDateTime.now()

    constructor():this("","",0, LocalDateTime.now())

    fun collectHistory(fullName: String,operation:String, amount: Int,historyRepository: HistoryRepository){
        val newHistory = History(fullName, operation,amount, LocalDateTime.now())
        historyRepository.save(newHistory)
    }
}