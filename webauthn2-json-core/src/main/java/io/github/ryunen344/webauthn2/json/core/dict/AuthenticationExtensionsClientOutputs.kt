package io.github.ryunen344.webauthn2.json.core.dict

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.AuthenticationExtensionsClientOutputsSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#iface-authentication-extensions-client-outputs
 */
@Serializable(with = AuthenticationExtensionsClientOutputsSerializer::class)
@JsonClass(generateAdapter = false)
class AuthenticationExtensionsClientOutputs(val value: Map<String, Any>) {

    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other is AuthenticationExtensionsClientOutputs -> other.value == value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        /**
         * reserved keys
         */
        val reserved: List<String> = listOf("appid", "appidExclude", "uvm", "credProps", "largeBlob")
    }
}
