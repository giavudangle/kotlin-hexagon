package hexagon.infrastructure.port.controller

import hexagon.api.request.CreateAccountRequest
import hexagon.api.response.AccountResponse
import hexagon.api.response.BaseResponse
import hexagon.api.service.AccountService
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
class AccountController(private val accountService: AccountService) {
  private val logger = Logger.getLogger(this.javaClass.name)

  private object Constants {
    const val ROOT = "/account"
    const val FIND = "$ROOT/{id}"
  }

  @GetMapping(Constants.FIND)
  @ResponseBody
  fun find(@PathVariable id: Long): BaseResponse<AccountResponse> {
    logger.info("Start to find inside AccountController")
    return accountService.findById(id)
  }

  @PostMapping(Constants.ROOT)
  @ResponseBody
  fun createAccount(@RequestBody request: CreateAccountRequest): BaseResponse<Boolean> {
    return accountService.create(request)
  }
}
