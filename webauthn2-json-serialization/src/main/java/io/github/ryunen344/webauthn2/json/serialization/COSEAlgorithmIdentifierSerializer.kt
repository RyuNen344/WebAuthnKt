package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.COSEAlgorithmIdentifier
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class COSEAlgorithmIdentifierSerializer : KSerializer<COSEAlgorithmIdentifier> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.AuthenticatorTransportSerializer",
            PrimitiveKind.INT
        )

    override fun deserialize(decoder: Decoder): COSEAlgorithmIdentifier {
        return COSEAlgorithmIdentifier(decoder.decodeInt())
    }

    override fun serialize(encoder: Encoder, value: COSEAlgorithmIdentifier) {
        encoder.encodeInt(value.value)
    }
}
