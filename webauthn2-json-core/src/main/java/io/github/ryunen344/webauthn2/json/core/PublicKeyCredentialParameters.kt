package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import io.github.ryunen344.webauthn2.json.moshi.annotation.UndefinedToNull
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-credential-params
 */
@Serializable
@UndefinedToNull
@JsonClass(generateAdapter = true)
class PublicKeyCredentialParameters(
    @field:Json(name = "type")
    @SerialName("type")
    val type: PublicKeyCredentialType = PublicKeyCredentialType.PublicKey,

    @field:Json(name = "alg")
    @SerialName("alg")
    val alg: COSEAlgorithmIdentifier,
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true

            other is PublicKeyCredentialParameters -> {
                other.type == type &&
                    other.alg == alg
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + alg.hashCode()
        return result
    }
}
