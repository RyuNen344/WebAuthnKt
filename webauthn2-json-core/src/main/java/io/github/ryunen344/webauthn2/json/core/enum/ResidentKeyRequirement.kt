package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.ResidentKeyRequirementSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enumdef-residentkeyrequirement
 */
@Serializable(with = ResidentKeyRequirementSerializer::class)
@JsonClass(generateAdapter = false)
enum class ResidentKeyRequirement(val value: String) {
    Discouraged("discouraged"),
    Preferred("preferred"),
    Required("required"),

    @Deprecated("Don't use this, it is reserved for fallback purposes.")
    Unknown(""),
}
