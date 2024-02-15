package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.enum.LargeBlobSupport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictdef-authenticationextensionslargeblobinputs
 */
@Serializable
@JsonClass(generateAdapter = true)
class AuthenticationExtensionsLargeBlobInputs(
    @field:Json(name = "support")
    @SerialName("support")
    val support: LargeBlobSupport?,

    @field:Json(name = "read")
    @SerialName("read")
    val read: Boolean?,

    @field:Json(name = "write")
    @SerialName("write")
    val write: BufferSource?
) {
    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true

            other is AuthenticationExtensionsLargeBlobInputs -> {
                other.support == support &&
                    other.read == read &&
                    other.write == write
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = support?.hashCode() ?: 0
        result = 31 * result + (read?.hashCode() ?: 0)
        result = 31 * result + (write?.hashCode() ?: 0)
        return result
    }
}
