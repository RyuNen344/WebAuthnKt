package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.UvmEntries
import io.github.ryunen344.webauthn2.json.core.UvmEntry
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class UvmEntriesSerializer : KSerializer<UvmEntries> {

    private val delegate = ListSerializer(UvmEntry.serializer())

    override val descriptor: SerialDescriptor =
        SerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.UvmEntriesSerializer",
            delegate.descriptor
        )

    override fun deserialize(decoder: Decoder): UvmEntries {
        return UvmEntries(decoder.decodeSerializableValue(delegate))
    }

    override fun serialize(encoder: Encoder, value: UvmEntries) {
        encoder.encodeSerializableValue(delegate, value.value)
    }
}
