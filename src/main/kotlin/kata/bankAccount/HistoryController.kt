package kata.bankAccount

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/history")
class HistoryController (val historyRepository: HistoryRepository) {
    @GetMapping("/{name}")
    fun history(@PathVariable(value = "name") name: String): List<History>{
        val historyByName = this.historyRepository.findByFullName(name)
        return historyByName
    }
}