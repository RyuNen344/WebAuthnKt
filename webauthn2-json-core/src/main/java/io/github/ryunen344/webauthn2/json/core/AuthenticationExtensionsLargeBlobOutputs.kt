package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictdef-authenticationextensionslargebloboutputs
 */
@Serializable
@JsonClass(generateAdapter = true)
class AuthenticationExtensionsLargeBlobOutputs(
    @field:Json(name = "supported")
    @SerialName("supported")
    val supported: Boolean?,

    @field:Json(name = "blob")
    @SerialName("blob")
    val blob: ArrayBuffer?,

    @field:Json(name = "written")
    @SerialName("written")
    val written: Boolean?
) {
    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true

            other is AuthenticationExtensionsLargeBlobOutputs -> {
                other.supported == supported &&
                    other.blob == blob &&
                    other.written == written
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = supported?.hashCode() ?: 0
        result = 31 * result + (blob?.hashCode() ?: 0)
        result = 31 * result + (written?.hashCode() ?: 0)
        return result
    }
}
