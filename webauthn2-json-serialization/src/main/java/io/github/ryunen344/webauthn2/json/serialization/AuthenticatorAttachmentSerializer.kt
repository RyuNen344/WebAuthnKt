package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachment
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class AuthenticatorAttachmentSerializer : KSerializer<AuthenticatorAttachment> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.AuthenticatorAttachmentSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): AuthenticatorAttachment {
        val json = decoder.decodeString()
        return AuthenticatorAttachment.entries.find { it.value == json }
            ?: AuthenticatorAttachment.Unknown
    }

    override fun serialize(encoder: Encoder, value: AuthenticatorAttachment) {
        encoder.encodeString(value.value)
    }
}
