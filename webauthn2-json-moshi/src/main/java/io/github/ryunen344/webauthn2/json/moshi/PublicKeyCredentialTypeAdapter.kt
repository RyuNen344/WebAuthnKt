package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType

class PublicKeyCredentialTypeAdapter {
    @ToJson
    fun toJson(value: PublicKeyCredentialType): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): PublicKeyCredentialType {
        return PublicKeyCredentialType.entries.find { it.value == value } ?: PublicKeyCredentialType.Unknown
    }
}
