package kata.bankAccount

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HistoryRepository :CrudRepository<History,Long> {
    fun findByFullName(fullName: String): List<History>
}