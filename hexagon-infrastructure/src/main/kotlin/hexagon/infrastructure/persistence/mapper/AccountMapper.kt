package hexagon.infrastructure.persistence.mapper

import hexagon.domain.entity.Account
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AccountMapper : BaseMapper<Account> {
  override fun findByIds(ids: List<Long>): List<Account>
  fun findByEmail(email: String): Account?
}

