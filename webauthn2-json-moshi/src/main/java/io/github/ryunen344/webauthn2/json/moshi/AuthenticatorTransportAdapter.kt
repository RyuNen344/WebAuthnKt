package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport

class AuthenticatorTransportAdapter {
    @ToJson
    fun toJson(value: AuthenticatorTransport): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): AuthenticatorTransport {
        return AuthenticatorTransport.entries.find { it.value == value } ?: AuthenticatorTransport.Unknown
    }
}
