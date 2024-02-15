package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.AttestationConveyancePreferenceSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enum-attestation-convey
 */
@Serializable(with = AttestationConveyancePreferenceSerializer::class)
@JsonClass(generateAdapter = false)
enum class AttestationConveyancePreference(val value: String) {
    None("none"),
    Indirect("indirect"),
    Direct("direct"),
    Enterprise("enterprise"),

    @Deprecated("Don't use this, it is reserved for fallback purposes.")
    Unknown(""),
}
