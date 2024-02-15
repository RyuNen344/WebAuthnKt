package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachment
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirement
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import io.github.ryunen344.webauthn2.json.moshi.annotation.UndefinedToNull
import io.github.ryunen344.webauthn2.json.serialization.AuthenticatorSelectionCriteriaSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-authenticatorSelection
 */
@Serializable(with = AuthenticatorSelectionCriteriaSerializer::class)
@UndefinedToNull
@JsonClass(generateAdapter = true)
class AuthenticatorSelectionCriteria(
    @field:Json(name = "authenticatorAttachment")
    @SerialName("authenticatorAttachment")
    val authenticatorAttachment: AuthenticatorAttachment?,

    @field:Json(name = "residentKey")
    @SerialName("residentKey")
    val residentKey: ResidentKeyRequirement?,

    @field:Json(name = "requireResidentKey")
    @SerialName("requireResidentKey")
    val requireResidentKey: Boolean? = false,

    @field:Json(name = "userVerification")
    @SerialName("userVerification")
    val userVerification: UserVerificationRequirement? = UserVerificationRequirement.Preferred,
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true

            other is AuthenticatorSelectionCriteria -> {
                authenticatorAttachment == other.authenticatorAttachment &&
                    residentKey == other.residentKey &&
                    requireResidentKey == other.requireResidentKey &&
                    userVerification == other.userVerification
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = authenticatorAttachment?.hashCode() ?: 0
        result = 31 * result + (residentKey?.hashCode() ?: 0)
        result = 31 * result + (requireResidentKey?.hashCode() ?: 0)
        result = 31 * result + (userVerification?.hashCode() ?: 0)
        return result
    }
}
