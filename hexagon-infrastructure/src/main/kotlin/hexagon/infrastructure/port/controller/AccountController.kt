package hexagon.infrastructure.port.controller

import hexagon.api.request.CreateAccountRequest
import hexagon.api.response.AccountResponse
import hexagon.api.response.BaseResponse
import hexagon.api.service.AccountService
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@Slf4j
class AccountController(private val accountService: AccountService) {
  private val logger = LoggerFactory.getLogger(this.javaClass.name)

  private object Constants {
    const val ROOT = "/account"
    const val FIND = "$ROOT/{id}"
  }

  @GetMapping(Constants.FIND)
  @ResponseBody
  fun find(@PathVariable id: Long): BaseResponse<AccountResponse> {
    logger.info("Start to find inside AccountController updated")
    return accountService.findById(id)
  }

  @PostMapping(Constants.ROOT)
  @ResponseBody
  fun createAccount(@RequestBody request: CreateAccountRequest): BaseResponse<Boolean> {
    return accountService.create(request)
  }
}
