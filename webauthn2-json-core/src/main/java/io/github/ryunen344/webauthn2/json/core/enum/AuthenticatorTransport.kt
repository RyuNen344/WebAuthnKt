package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.AuthenticatorTransportSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enum-transport
 */
@Serializable(with = AuthenticatorTransportSerializer::class)
@JsonClass(generateAdapter = false)
enum class AuthenticatorTransport(val value: String) {
    Usb("usb"),
    Nfc("nfc"),
    Ble("ble"),
    Internal("internal"),

    @Deprecated("Don't use this, it is reserved for fallback purposes.")
    Unknown(""),
}
