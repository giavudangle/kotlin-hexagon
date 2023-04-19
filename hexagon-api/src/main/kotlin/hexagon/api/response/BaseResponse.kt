package hexagon.api.response

data class BaseResponse<T>(
  private val result: T?,
  private val code: String?,
  private val message: String?
) {

  val isSucceed: Boolean
    get() = SUCCEED_STATUS_CODE == code

  val isFailed: Boolean
    get() = FAILED_STATUS_CODE == code

  val data: T?
    get() = this.result

  companion object {
    const val SUCCEED_STATUS_CODE = "200"
    const val SUCCEED_STATUS_MESSAGE = "SUCCESS"
    const val FAILED_STATUS_CODE = "500"
    const val FAILED_STATUS_MESSAGE = "FAILED"

    fun <T> of(data: T, code: String, message: String): BaseResponse<T> {
      return BaseResponse(data, code, message)
    }

    fun <T> success(data: T): BaseResponse<T> {
      return BaseResponse(data, SUCCEED_STATUS_CODE, SUCCEED_STATUS_MESSAGE)
    }

    fun <T> fail(): BaseResponse<T> {
      return BaseResponse(null, FAILED_STATUS_CODE, FAILED_STATUS_MESSAGE)
    }

    fun <T> ok(): BaseResponse<T> {
      return BaseResponse(null, SUCCEED_STATUS_CODE, SUCCEED_STATUS_MESSAGE)
    }
  }
}
