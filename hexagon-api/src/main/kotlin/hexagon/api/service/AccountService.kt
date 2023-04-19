package hexagon.api.service

import hexagon.api.request.CreateAccountRequest
import hexagon.api.response.AccountResponse
import hexagon.api.response.BaseResponse

interface AccountService : BaseService {
  fun findById(id: Long): BaseResponse<AccountResponse>
  fun create(request: CreateAccountRequest): BaseResponse<Boolean>
}
