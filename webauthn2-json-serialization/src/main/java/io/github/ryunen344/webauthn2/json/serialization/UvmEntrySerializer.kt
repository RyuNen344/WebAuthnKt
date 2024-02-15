package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.UvmEntry
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class UvmEntrySerializer : KSerializer<UvmEntry> {

    private val delegate = ListSerializer(ULong.serializer())

    override val descriptor: SerialDescriptor =
        SerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.UvmEntrySerializer",
            delegate.descriptor
        )

    override fun deserialize(decoder: Decoder): UvmEntry {
        return UvmEntry(decoder.decodeSerializableValue(delegate))
    }

    override fun serialize(encoder: Encoder, value: UvmEntry) {
        encoder.encodeSerializableValue(delegate, value.value)
    }
}
