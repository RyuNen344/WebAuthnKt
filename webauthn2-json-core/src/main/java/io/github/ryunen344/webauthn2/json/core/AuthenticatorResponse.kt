package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#iface-authenticatorresponse
 */
@Serializable
@JsonClass(generateAdapter = false)
sealed class AuthenticatorResponse {
    abstract val clientDataJSON: ArrayBuffer
}

/**
 * https://www.w3.org/TR/webauthn-2/#iface-authenticatorattestationresponse
 */
@Serializable
@JsonClass(generateAdapter = true)
class AuthenticatorAttestationResponse(
    @field:Json(name = "clientDataJSON")
    @SerialName("clientDataJSON")
    override val clientDataJSON: ArrayBuffer,

    @field:Json(name = "attestationObject")
    @SerialName("attestationObject")
    val attestationObject: ArrayBuffer,

    @field:Json(name = "transports")
    @SerialName("transports")
    val transports: List<AuthenticatorTransport>?,

    @field:Json(name = "authenticatorData")
    @SerialName("authenticatorData")
    val authenticatorData: ArrayBuffer?,

    @field:Json(name = "publicKey")
    @SerialName("publicKey")
    val publicKey: ArrayBuffer?,

    @field:Json(name = "publicKeyAlgorithm")
    @SerialName("publicKeyAlgorithm")
    val publicKeyAlgorithm: COSEAlgorithmIdentifier?,
) : AuthenticatorResponse() {
    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true

            other is AuthenticatorAttestationResponse -> {
                other.clientDataJSON == clientDataJSON &&
                    other.attestationObject == attestationObject &&
                    other.transports == transports &&
                    other.authenticatorData == authenticatorData &&
                    other.publicKey == publicKey &&
                    other.publicKeyAlgorithm == publicKeyAlgorithm
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = clientDataJSON.hashCode()
        result = 31 * result + attestationObject.hashCode()
        result = 31 * result + (transports?.hashCode() ?: 0)
        result = 31 * result + (authenticatorData?.hashCode() ?: 0)
        result = 31 * result + (publicKey?.hashCode() ?: 0)
        result = 31 * result + (publicKeyAlgorithm?.hashCode() ?: 0)
        return result
    }
}

/**
 * https://www.w3.org/TR/webauthn-2/#iface-authenticatorassertionresponse
 */
@Serializable
@JsonClass(generateAdapter = true)
class AuthenticatorAssertionResponse(
    @field:Json(name = "clientDataJSON")
    @SerialName("clientDataJSON")
    override val clientDataJSON: ArrayBuffer,

    @field:Json(name = "authenticatorData")
    @SerialName("authenticatorData")
    val authenticatorData: ArrayBuffer,

    @field:Json(name = "signature")
    @SerialName("signature")
    val signature: ArrayBuffer,

    @field:Json(name = "userHandle")
    @SerialName("userHandle")
    val userHandle: ArrayBuffer?
) : AuthenticatorResponse() {
    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true

            other is AuthenticatorAssertionResponse -> {
                other.clientDataJSON == clientDataJSON &&
                    other.authenticatorData == authenticatorData &&
                    other.signature == signature &&
                    other.userHandle == userHandle
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = clientDataJSON.hashCode()
        result = 31 * result + authenticatorData.hashCode()
        result = 31 * result + signature.hashCode()
        result = 31 * result + (userHandle?.hashCode() ?: 0)
        return result
    }
}
