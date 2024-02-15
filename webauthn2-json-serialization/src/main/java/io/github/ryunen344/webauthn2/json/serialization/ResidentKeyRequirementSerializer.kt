package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirement
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class ResidentKeyRequirementSerializer : KSerializer<ResidentKeyRequirement> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.ResidentKeyRequirementSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): ResidentKeyRequirement {
        val json = decoder.decodeString()
        return ResidentKeyRequirement.entries.find { it.value == json }
            ?: ResidentKeyRequirement.Unknown
    }

    override fun serialize(encoder: Encoder, value: ResidentKeyRequirement) {
        encoder.encodeString(value.value)
    }
}
