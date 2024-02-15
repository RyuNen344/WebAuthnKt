package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.DOMStringSerializer
import kotlinx.serialization.Serializable

/**
 * https://webidl.spec.whatwg.org/#idl-DOMString
 */
@Serializable(with = DOMStringSerializer::class)
@JsonClass(generateAdapter = false)
class DOMString(val value: String) : Comparable<DOMString> {

    override fun compareTo(other: DOMString): Int {
        return value.compareTo(other.value)
    }

    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other is DOMString -> value == other.value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
