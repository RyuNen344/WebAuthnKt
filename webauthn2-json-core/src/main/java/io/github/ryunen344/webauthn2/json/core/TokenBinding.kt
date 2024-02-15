package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictdef-tokenbinding
 */
@Serializable
@JsonClass(generateAdapter = true)
class TokenBinding(
    @field:Json(name = "status")
    @SerialName("status")
    val status: TokenBindingStatus,

    @field:Json(name = "id")
    @SerialName("id")
    val id: DOMString?
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other is TokenBinding -> other.status == status && other.id == id
            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }
}
