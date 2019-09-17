package kata.bankAccount

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CrudRepository<Account,Long> {
    fun findByFullName(fullName: String): List<Account>
}


