package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictdef-collectedclientdata
 */
@Serializable
@JsonClass(generateAdapter = true)
class CollectedClientData(
    @field:Json(name = "type")
    @SerialName("type")
    val type: DOMString,

    @field:Json(name = "challenge")
    @SerialName("challenge")
    val challenge: Base64URLString,

    @field:Json(name = "origin")
    @SerialName("origin")
    val origin: DOMString,

    @field:Json(name = "crossOrigin")
    @SerialName("crossOrigin")
    val crossOrigin: Boolean?,

    @field:Json(name = "tokenBinding")
    @SerialName("tokenBinding")
    val tokenBinding: TokenBinding?,
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true

            other is CollectedClientData -> {
                other.type == type &&
                    other.challenge == challenge &&
                    other.origin == origin &&
                    other.crossOrigin == crossOrigin &&
                    other.tokenBinding == tokenBinding
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + challenge.hashCode()
        result = 31 * result + origin.hashCode()
        result = 31 * result + (crossOrigin?.hashCode() ?: 0)
        result = 31 * result + (tokenBinding?.hashCode() ?: 0)
        return result
    }
}
