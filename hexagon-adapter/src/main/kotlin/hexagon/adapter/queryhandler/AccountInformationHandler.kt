package hexagon.adapter.queryhandler

import hexagon.adapter.dto.AccountDTO
import hexagon.adapter.query.AccountInformationQuery
import hexagon.domain.exception.EntityNotFoundException
import hexagon.domain.repository.AccountRepository
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component

@Component
class AccountInformationHandler(private val accountRepository: AccountRepository) {

  @QueryHandler
  fun handle(query: AccountInformationQuery): AccountDTO {
    val account = accountRepository.find(query.id) ?: throw EntityNotFoundException()
    return AccountDTO(id = account.id, name = account.name, email = account.email)
  }
}
