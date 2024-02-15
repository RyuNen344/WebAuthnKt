package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.LargeBlobSupport
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class LargeBlobSupportSerializer : KSerializer<LargeBlobSupport> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.LargeBlobSupportSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): LargeBlobSupport {
        val json = decoder.decodeString()
        return LargeBlobSupport.entries.first { it.value == json }
    }

    override fun serialize(encoder: Encoder, value: LargeBlobSupport) {
        encoder.encodeString(value.value)
    }
}
