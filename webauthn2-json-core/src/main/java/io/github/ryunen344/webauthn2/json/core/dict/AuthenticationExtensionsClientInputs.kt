package io.github.ryunen344.webauthn2.json.core.dict

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.AuthenticationExtensionsClientInputsSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#iface-authentication-extensions-client-inputs
 */
@Serializable(with = AuthenticationExtensionsClientInputsSerializer::class)
@JsonClass(generateAdapter = false)
class AuthenticationExtensionsClientInputs(val value: Map<String, Any>) {

    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other is AuthenticationExtensionsClientInputs -> other.value == value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        val reserved = listOf("appid", "appidExclude", "uvm", "credProps", "largeBlob")
    }
}
