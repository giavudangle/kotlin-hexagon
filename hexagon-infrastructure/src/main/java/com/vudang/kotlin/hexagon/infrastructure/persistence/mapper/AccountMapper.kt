package com.vudang.kotlin.hexagon.infrastructure.persistence.mapper

import com.vudang.kotlin.hexagon.domain.entity.Account
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AccountMapper : BaseMapper<Account> {
  override fun findByIds(ids: List<Long>): List<Account>
  fun findByEmail(email: String): Account?
}
