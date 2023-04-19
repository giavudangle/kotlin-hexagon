package hexagon.infrastructure.repository

import hexagon.domain.entity.Account
import hexagon.domain.repository.AccountRepository
import hexagon.infrastructure.persistence.mapper.AccountMapper
import lombok.Getter
import org.springframework.stereotype.Component

@Getter
@Component
open class AccountRepositoryImpl(override val mapper: AccountMapper) :
  BaseRepositoryImpl<Account, AccountMapper>(mapper), AccountRepository {
  override fun findByEmail(email: String): Account? {
    return mapper.findByEmail(email)
  }
}
