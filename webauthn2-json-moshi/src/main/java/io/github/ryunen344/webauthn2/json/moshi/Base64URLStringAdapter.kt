package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.Base64URLString

class Base64URLStringAdapter {
    @ToJson
    fun toJson(value: Base64URLString): String {
        return Base64URLString.encode(value)
    }

    @FromJson
    fun fromJson(value: String): Base64URLString {
        return Base64URLString.decode(value)
    }
}
