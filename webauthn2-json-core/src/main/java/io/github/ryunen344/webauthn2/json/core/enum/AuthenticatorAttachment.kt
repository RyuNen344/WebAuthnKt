package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.AuthenticatorAttachmentSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enum-attachment
 */
@Serializable(with = AuthenticatorAttachmentSerializer::class)
@JsonClass(generateAdapter = false)
enum class AuthenticatorAttachment(val value: String) {
    Platform("platform"),
    CrossPlatform("cross-platform"),

    @Deprecated("Don't use this, it is reserved for fallback purposes.")
    Unknown(""),
}
