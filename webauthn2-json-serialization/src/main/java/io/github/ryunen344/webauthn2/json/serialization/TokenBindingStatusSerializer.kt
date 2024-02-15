package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatus
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class TokenBindingStatusSerializer : KSerializer<TokenBindingStatus> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.TokenBindingStatusSerializer",
            PrimitiveKind.STRING
        )

    override fun deserialize(decoder: Decoder): TokenBindingStatus {
        val json = decoder.decodeString()
        return TokenBindingStatus.entries.find { it.value == json }
            ?: TokenBindingStatus.Unknown
    }

    override fun serialize(encoder: Encoder, value: TokenBindingStatus) {
        encoder.encodeString(value.value)
    }
}
