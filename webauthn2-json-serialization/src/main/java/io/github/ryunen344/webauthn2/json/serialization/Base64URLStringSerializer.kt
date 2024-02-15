package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.Base64URLString
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class Base64URLStringSerializer : KSerializer<Base64URLString> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.Base64URLStringSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): Base64URLString {
        return Base64URLString.decode(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: Base64URLString) {
        encoder.encodeString(Base64URLString.encode(value))
    }
}
