package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.PublicKeyCredentialTypeSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enum-credentialType
 */
@Serializable(with = PublicKeyCredentialTypeSerializer::class)
@JsonClass(generateAdapter = false)
enum class PublicKeyCredentialType(val value: String) {
    PublicKey("public-key"),

    @Deprecated("Don't use this, it is reserved for fallback purposes.")
    Unknown(""),
}
