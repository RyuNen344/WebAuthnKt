package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class UserVerificationRequirementSerializer : KSerializer<UserVerificationRequirement> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.UserVerificationRequirementSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): UserVerificationRequirement {
        val json = decoder.decodeString()
        return UserVerificationRequirement.entries.find { it.value == json }
            ?: UserVerificationRequirement.Unknown
    }

    override fun serialize(encoder: Encoder, value: UserVerificationRequirement) {
        encoder.encodeString(value.value)
    }
}
