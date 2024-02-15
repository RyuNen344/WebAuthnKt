package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.UvmEntrySerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#typedefdef-uvmentry
 */
@Serializable(with = UvmEntrySerializer::class)
@JsonClass(generateAdapter = false)
class UvmEntry(val value: List<ULong>) {

    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other is UvmEntry -> value == other.value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
