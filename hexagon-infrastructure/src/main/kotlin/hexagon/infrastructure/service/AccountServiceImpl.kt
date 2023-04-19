package hexagon.infrastructure.service

import hexagon.adapter.query.AccountInformationQuery
import hexagon.api.request.CreateAccountRequest
import hexagon.api.response.AccountResponse
import hexagon.api.response.BaseResponse
import hexagon.api.service.AccountService
import hexagon.domain.context.HexagonContext
import java.util.*
import lombok.RequiredArgsConstructor
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class AccountServiceImpl(
  private val queryGateway: QueryGateway,
  private val commandGateway: CommandGateway
) : AccountService {
  private val context: HexagonContext = HexagonContext.getHexagonContext()

  override fun findById(id: Long): BaseResponse<AccountResponse> {
    val account =
      queryGateway
        .query(AccountInformationQuery(id), hexagon.adapter.dto.AccountDTO::class.java)
        .get()

    return BaseResponse.success(
      AccountResponse(id = account.id, name = account.name, email = account.email)
    )
  }

  override fun create(request: CreateAccountRequest): BaseResponse<Boolean> {
    commandGateway.sendAndWait<Any>(
      hexagon.adapter.command.CreateAccountCommand(
        accountId = UUID.randomUUID(),
        email = request.email,
        password = request.password,
        name = request.name
      )
    )

    return BaseResponse.ok()
  }
}
