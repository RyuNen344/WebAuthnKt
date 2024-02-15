package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class AuthenticatorTransportSerializer : KSerializer<AuthenticatorTransport> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.AuthenticatorTransportSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): AuthenticatorTransport {
        val json = decoder.decodeString()
        return AuthenticatorTransport.entries.find { it.value == json }
            ?: AuthenticatorTransport.Unknown
    }

    override fun serialize(encoder: Encoder, value: AuthenticatorTransport) {
        encoder.encodeString(value.value)
    }
}
