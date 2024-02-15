package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class PublicKeyCredentialTypeSerializer : KSerializer<PublicKeyCredentialType> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.PublicKeyCredentialTypeSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): PublicKeyCredentialType {
        val json = decoder.decodeString()
        return PublicKeyCredentialType.entries.find { it.value == json }
            ?: PublicKeyCredentialType.Unknown
    }

    override fun serialize(encoder: Encoder, value: PublicKeyCredentialType) {
        encoder.encodeString(value.value)
    }
}
