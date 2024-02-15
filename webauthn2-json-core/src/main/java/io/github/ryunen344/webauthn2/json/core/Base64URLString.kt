package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.Base64URLStringSerializer
import kotlinx.serialization.Serializable
import java.util.Base64

/**
 * https://w3c.github.io/webauthn/#typedefdef-base64urlstring
 */
@Serializable(with = Base64URLStringSerializer::class)
@JsonClass(generateAdapter = false)
class Base64URLString(val value: ByteArray) {
    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other is Base64URLString -> other.value.contentEquals(value)
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.contentHashCode()
    }

    companion object {
        @JvmStatic
        fun encode(value: Base64URLString): String {
            return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(value.value)
        }

        @JvmStatic
        fun decode(string: String): Base64URLString {
            return Base64URLString(Base64.getUrlDecoder().decode(string))
        }
    }
}
