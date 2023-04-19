package hexagon.infrastructure.port.controller

import hexagon.api.request.CreateAccountRequest
import hexagon.api.response.AccountResponse
import hexagon.api.response.BaseResponse
import hexagon.api.service.AccountService
import org.springframework.web.bind.annotation.*

@RestController
class AccountController(private val accountService: AccountService) {
  private object Constants {
    const val ROOT = "/account"
    const val FIND = "$ROOT/{id}"
  }

  @GetMapping(Constants.FIND)
  @ResponseBody
  fun find(@PathVariable id: Long): BaseResponse<AccountResponse> {
    val response: BaseResponse<AccountResponse> = accountService.findById(id)
    return response
  }

  @PostMapping(Constants.ROOT)
  @ResponseBody
  fun createAccount(@RequestBody request: CreateAccountRequest): BaseResponse<Boolean> {
    return accountService.create(request)
  }
}
