package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatus

class TokenBindingStatusAdapter {
    @ToJson
    fun toJson(value: TokenBindingStatus): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): TokenBindingStatus {
        return TokenBindingStatus.entries.find { it.value == value } ?: TokenBindingStatus.Unknown
    }
}
