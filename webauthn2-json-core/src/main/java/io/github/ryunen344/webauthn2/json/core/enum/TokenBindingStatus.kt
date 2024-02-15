package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.TokenBindingStatusSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enumdef-tokenbindingstatus
 */
@Serializable(with = TokenBindingStatusSerializer::class)
@JsonClass(generateAdapter = false)
enum class TokenBindingStatus(val value: String) {
    Present("present"),
    Supported("supported"),

    @Deprecated("Don't use this, it is reserved for fallback purposes.")
    Unknown(""),
}
