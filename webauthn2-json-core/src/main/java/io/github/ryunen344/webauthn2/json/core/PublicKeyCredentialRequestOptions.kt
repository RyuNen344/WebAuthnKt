package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import io.github.ryunen344.webauthn2.json.moshi.annotation.UndefinedToNull
import io.github.ryunen344.webauthn2.json.serialization.PublicKeyCredentialRequestOptionsSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-assertion-options
 */
@Serializable(with = PublicKeyCredentialRequestOptionsSerializer::class)
@UndefinedToNull
@JsonClass(generateAdapter = true)
class PublicKeyCredentialRequestOptions(
    @field:Json(name = "challenge")
    @SerialName("challenge")
    val challenge: BufferSource,

    @field:Json(name = "timeout")
    @SerialName("timeout")
    val timeout: ULong?,

    @field:Json(name = "rpId")
    @SerialName("rpId")
    val rpId: DOMString?,

    @field:Json(name = "allowCredentials")
    @SerialName("allowCredentials")
    val allowCredentials: List<PublicKeyCredentialDescriptor>? = emptyList(),

    @field:Json(name = "userVerification")
    @SerialName("userVerification")
    val userVerification: UserVerificationRequirement? = UserVerificationRequirement.Preferred,

    @field:Json(name = "extensions")
    @SerialName("extensions")
    val extensions: AuthenticationExtensionsClientInputs?
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true

            other is PublicKeyCredentialRequestOptions -> {
                other.challenge == challenge &&
                    other.timeout == timeout &&
                    other.rpId == rpId &&
                    other.allowCredentials == allowCredentials &&
                    other.userVerification == userVerification &&
                    other.extensions == extensions
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = challenge.hashCode()
        result = 31 * result + (timeout?.hashCode() ?: 0)
        result = 31 * result + (rpId?.hashCode() ?: 0)
        result = 31 * result + (allowCredentials?.hashCode() ?: 0)
        result = 31 * result + (userVerification?.hashCode() ?: 0)
        result = 31 * result + (extensions?.hashCode() ?: 0)
        return result
    }
}
