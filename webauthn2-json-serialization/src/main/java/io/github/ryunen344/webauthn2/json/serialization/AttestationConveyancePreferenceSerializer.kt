package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreference
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class AttestationConveyancePreferenceSerializer : KSerializer<AttestationConveyancePreference> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.AttestationConveyancePreferenceSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): AttestationConveyancePreference {
        val json = decoder.decodeString()
        return AttestationConveyancePreference.entries.find { it.value == json }
            ?: AttestationConveyancePreference.Unknown
    }

    override fun serialize(encoder: Encoder, value: AttestationConveyancePreference) {
        encoder.encodeString(value.value)
    }
}
