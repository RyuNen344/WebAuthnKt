package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-credential-descriptor
 */
@Serializable
@JsonClass(generateAdapter = true)
class PublicKeyCredentialDescriptor(
    @field:Json(name = "type")
    @SerialName("type")
    val type: PublicKeyCredentialType,

    @field:Json(name = "id")
    @SerialName("id")
    val id: BufferSource,

    @field:Json(name = "transports")
    @SerialName("transports")
    val transports: List<AuthenticatorTransport>?
) {
    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true

            other is PublicKeyCredentialDescriptor -> {
                other.type == type &&
                    other.id == id &&
                    other.transports == transports
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + (transports?.hashCode() ?: 0)
        return result
    }
}
