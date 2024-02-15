package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.DOMString

class DOMStringAdapter {
    @ToJson
    fun toJson(value: DOMString): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): DOMString {
        return DOMString(value)
    }
}
