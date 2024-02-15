package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.UserVerificationRequirementSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enum-userVerificationRequirement
 */
@Serializable(with = UserVerificationRequirementSerializer::class)
@JsonClass(generateAdapter = false)
enum class UserVerificationRequirement(val value: String) {
    Required("required"),
    Preferred("preferred"),
    Discouraged("discouraged"),

    @Deprecated("Don't use this, it is reserved for fallback purposes.")
    Unknown(""),
}
