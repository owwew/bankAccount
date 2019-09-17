package kata.bankAccount


import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Account(var fullName: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var actualBalance: Int = 0 //this.balance
    var date = LocalDateTime.now()
    constructor(): this("")

    fun deposit(amount: Int){
        this.actualBalance += amount
        this.date = LocalDateTime.now()
    }

    fun withdrawal(amount: Int){
        if(this.actualBalance >= amount){
            this.actualBalance -= amount
            this.date = LocalDateTime.now()
        }
    }
}

