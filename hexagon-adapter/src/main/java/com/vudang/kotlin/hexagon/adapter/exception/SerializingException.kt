package com.vudang.kotlin.hexagon.adapter.exception

class SerializingException : BaseAdapterException {
    constructor(message: String, code : String) : super(message, code)
    constructor(): super(MESSAGE, CODE)

    companion object {
        private const val CODE = "EX.005.SERIALIZING_EXCEPTION"
        private const val MESSAGE = "Errors occur when during serializing "
    }
}