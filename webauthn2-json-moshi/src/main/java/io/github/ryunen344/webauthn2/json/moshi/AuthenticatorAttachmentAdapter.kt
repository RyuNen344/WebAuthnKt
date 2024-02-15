package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachment

class AuthenticatorAttachmentAdapter {
    @ToJson
    fun toJson(value: AuthenticatorAttachment): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): AuthenticatorAttachment {
        return AuthenticatorAttachment.entries.find { it.value == value } ?: AuthenticatorAttachment.Unknown
    }
}
