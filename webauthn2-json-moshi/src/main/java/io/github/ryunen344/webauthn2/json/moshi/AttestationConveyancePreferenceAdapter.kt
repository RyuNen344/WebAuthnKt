package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreference

class AttestationConveyancePreferenceAdapter {
    @ToJson
    fun toJson(value: AttestationConveyancePreference): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): AttestationConveyancePreference {
        return AttestationConveyancePreference.entries.find { it.value == value }
            ?: AttestationConveyancePreference.Unknown
    }
}
