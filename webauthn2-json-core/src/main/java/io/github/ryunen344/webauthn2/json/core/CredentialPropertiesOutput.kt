package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictdef-credentialpropertiesoutput
 */
@Serializable
@JsonClass(generateAdapter = true)
class CredentialPropertiesOutput(
    @field:Json(name = "rk")
    @SerialName("rk")
    val rk: Boolean?,
) {
    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other is CredentialPropertiesOutput -> other.rk == rk
            else -> false
        }
    }

    override fun hashCode(): Int {
        return rk?.hashCode() ?: 0
    }
}
