package com.vudang.kotlin.hexagon.api.response

class GenericResponse() : BaseResponse() {
  var successCode = 0
  var successMessage = "SUCCESS"

  companion object {
    fun ok(): GenericResponse {
      return GenericResponse()
    }
  }
}
