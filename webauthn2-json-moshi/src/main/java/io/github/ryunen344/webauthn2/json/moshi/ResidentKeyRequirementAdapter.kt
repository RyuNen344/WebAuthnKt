package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirement

class ResidentKeyRequirementAdapter {
    @ToJson
    fun toJson(value: ResidentKeyRequirement): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ResidentKeyRequirement {
        return ResidentKeyRequirement.entries.find { it.value == value } ?: ResidentKeyRequirement.Unknown
    }
}
