package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreference
import io.github.ryunen344.webauthn2.json.moshi.annotation.UndefinedToNull
import io.github.ryunen344.webauthn2.json.serialization.PublicKeyCredentialCreationOptionsSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-makecredentialoptions
 */
@Serializable(with = PublicKeyCredentialCreationOptionsSerializer::class)
@UndefinedToNull
@JsonClass(generateAdapter = true)
class PublicKeyCredentialCreationOptions(
    @field:Json(name = "rp")
    @SerialName("rp")
    val rp: PublicKeyCredentialRpEntity,

    @field:Json(name = "user")
    @SerialName("user")
    val user: PublicKeyCredentialUserEntity,

    @field:Json(name = "challenge")
    @SerialName("challenge")
    val challenge: BufferSource,

    @field:Json(name = "pubKeyCredParams")
    @SerialName("pubKeyCredParams")
    val pubKeyCredParams: List<PublicKeyCredentialParameters>,

    @field:Json(name = "timeout")
    @SerialName("timeout")
    val timeout: ULong?,

    @field:Json(name = "excludeCredentials")
    @SerialName("excludeCredentials")
    val excludeCredentials: List<PublicKeyCredentialDescriptor>? = emptyList(),

    @field:Json(name = "authenticatorSelection")
    @SerialName("authenticatorSelection")
    val authenticatorSelection: AuthenticatorSelectionCriteria?,

    @field:Json(name = "attestation")
    @SerialName("attestation")
    val attestation: AttestationConveyancePreference? = AttestationConveyancePreference.None,

    @field:Json(name = "extensions")
    @SerialName("extensions")
    val extensions: AuthenticationExtensionsClientInputs?,
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true

            other is PublicKeyCredentialCreationOptions -> {
                other.rp == rp &&
                    other.user == user &&
                    other.challenge == challenge &&
                    other.pubKeyCredParams == pubKeyCredParams &&
                    other.timeout == timeout &&
                    other.excludeCredentials == excludeCredentials &&
                    other.authenticatorSelection == authenticatorSelection &&
                    other.attestation == attestation &&
                    other.extensions == extensions
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = rp.hashCode()
        result = 31 * result + user.hashCode()
        result = 31 * result + challenge.hashCode()
        result = 31 * result + pubKeyCredParams.hashCode()
        result = 31 * result + (timeout?.hashCode() ?: 0)
        result = 31 * result + (excludeCredentials?.hashCode() ?: 0)
        result = 31 * result + (authenticatorSelection?.hashCode() ?: 0)
        result = 31 * result + (attestation?.hashCode() ?: 0)
        result = 31 * result + (extensions?.hashCode() ?: 0)
        return result
    }
}
