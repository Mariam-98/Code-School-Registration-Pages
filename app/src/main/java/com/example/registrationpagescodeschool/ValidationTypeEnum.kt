package com.example.registrationpagescodeschool

enum class ValidationTypeEnum(val value: Int) {
    EMAIL(0),
    PHONE(1),
    NAME(2),
    CONFIRM_PASSWORD(3);

    companion object {
        private val map = values().associateBy(ValidationTypeEnum::value)
        fun from(value: Int) = map[value]
    }
}