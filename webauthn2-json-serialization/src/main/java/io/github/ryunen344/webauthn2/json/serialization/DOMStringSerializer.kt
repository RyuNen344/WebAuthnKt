package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.DOMString
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class DOMStringSerializer : KSerializer<DOMString> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.DOMStringSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): DOMString {
        return DOMString(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: DOMString) {
        encoder.encodeString(value.value)
    }
}
