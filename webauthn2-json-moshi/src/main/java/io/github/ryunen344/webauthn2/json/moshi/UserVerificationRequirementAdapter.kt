package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement

class UserVerificationRequirementAdapter {
    @ToJson
    fun toJson(value: UserVerificationRequirement): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): UserVerificationRequirement {
        return UserVerificationRequirement.entries.find { it.value == value } ?: UserVerificationRequirement.Unknown
    }
}
