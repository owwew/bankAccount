package kata.bankAccount

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/accounts")
class AccountController (val accountRepository: AccountRepository, val historyRepository: HistoryRepository){

    @GetMapping("/all")
    fun all(): MutableIterable<Account> = this.accountRepository.findAll()

    @GetMapping("/{name}")
    fun byName(@PathVariable(value = "name") name: String): List<Account>{
        val accountsByName = this.accountRepository.findByFullName(name)
        return accountsByName
    }

    @PostMapping("/withdrawal")
    fun withdrawal(@RequestBody withdrawalRequest: WithdrawalRequest){
        //Execute withdrawal
        val accountByName = this.accountRepository.findByFullName(withdrawalRequest.clientName).get(0)
        accountByName.withdrawal(withdrawalRequest.amount)
        this.accountRepository.save(accountByName)

        //Collect history
        val history = this.historyRepository.findByFullName(withdrawalRequest.clientName).get(0)
        history.collectHistory(withdrawalRequest.clientName,"withdrawal",withdrawalRequest.amount,historyRepository)
    }

    @PostMapping("/deposit")
    fun deposit(@RequestBody depositRequest: DepositRequest){
        //Execute deposit
        val accountByName = this.accountRepository.findByFullName(depositRequest.clientName).get(0)
        accountByName.deposit(depositRequest.amount)
        this.accountRepository.save(accountByName)

        //Collect history
        val history = this.historyRepository.findByFullName(depositRequest.clientName).get(0)
        history.collectHistory(depositRequest.clientName,"deposit",depositRequest.amount,historyRepository)
    }
}