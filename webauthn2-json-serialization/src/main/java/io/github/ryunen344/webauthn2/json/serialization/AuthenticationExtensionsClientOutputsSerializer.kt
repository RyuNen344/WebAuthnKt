package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobOutputs
import io.github.ryunen344.webauthn2.json.core.CredentialPropertiesOutput
import io.github.ryunen344.webauthn2.json.core.UvmEntries
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
import io.github.ryunen344.webauthn2.json.core.partial.appid
import io.github.ryunen344.webauthn2.json.core.partial.appidExclude
import io.github.ryunen344.webauthn2.json.core.partial.credProps
import io.github.ryunen344.webauthn2.json.core.partial.largeBlob
import io.github.ryunen344.webauthn2.json.core.partial.uvm
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonPrimitive

/**
 * serializer for [AuthenticationExtensionsClientOutputs]
 * serialize explicit object to object e.g) [appid], [appidExclude], [uvm], [credProps], [largeBlob]
 * serialize unknown object to [JsonPrimitive], [JsonArray], [JsonObject], [JsonElement]
 */
class AuthenticationExtensionsClientOutputsSerializer : KSerializer<AuthenticationExtensionsClientOutputs> {

    override val descriptor: SerialDescriptor =
        buildSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.AuthenticationExtensionsClientOutputsSerializer",
            StructureKind.MAP
        )

    override fun deserialize(decoder: Decoder): AuthenticationExtensionsClientOutputs {
        require(decoder is JsonDecoder)
        val json = decoder.decodeJsonElement() as JsonObject
        return AuthenticationExtensionsClientOutputs(
            buildMap {
                json[AuthenticationExtensionsClientOutputs.reserved[0]]?.jsonPrimitive?.boolean?.let {
                    put(AuthenticationExtensionsClientOutputs.reserved[0], it)
                }
                json[AuthenticationExtensionsClientOutputs.reserved[1]]?.jsonPrimitive?.boolean?.let {
                    put(AuthenticationExtensionsClientOutputs.reserved[1], it)
                }
                json[AuthenticationExtensionsClientOutputs.reserved[2]]?.let {
                    put(
                        AuthenticationExtensionsClientOutputs.reserved[2],
                        decoder.json.decodeFromJsonElement(UvmEntries.serializer(), it)
                    )
                }
                json[AuthenticationExtensionsClientOutputs.reserved[3]]?.let {
                    put(
                        AuthenticationExtensionsClientOutputs.reserved[3],
                        decoder.json.decodeFromJsonElement(CredentialPropertiesOutput.serializer(), it)
                    )
                }
                json[AuthenticationExtensionsClientOutputs.reserved[4]]?.let {
                    put(
                        AuthenticationExtensionsClientOutputs.reserved[4],
                        decoder.json.decodeFromJsonElement(AuthenticationExtensionsLargeBlobOutputs.serializer(), it)
                    )
                }
                putAll(
                    json.filterKeys { !AuthenticationExtensionsClientOutputs.reserved.contains(it) }
                        .mapNotNull { (key, value) -> value.extractedContent?.let { key to it } }
                        .associate { it }
                )
            }
        )
    }

    override fun serialize(encoder: Encoder, value: AuthenticationExtensionsClientOutputs) {
        require(encoder is JsonEncoder)
        encoder.encodeJsonElement(
            buildJsonObject {
                value.appid?.let { put(AuthenticationExtensionsClientOutputs.reserved[0], JsonPrimitive(it)) }
                value.appidExclude?.let { put(AuthenticationExtensionsClientOutputs.reserved[1], JsonPrimitive(it)) }
                value.uvm?.let {
                    put(
                        AuthenticationExtensionsClientOutputs.reserved[2],
                        encoder.json.encodeToJsonElement(it)
                    )
                }
                value.credProps?.let {
                    put(
                        AuthenticationExtensionsClientOutputs.reserved[3],
                        encoder.json.encodeToJsonElement(it)
                    )
                }
                value.largeBlob?.let {
                    put(
                        AuthenticationExtensionsClientOutputs.reserved[4],
                        encoder.json.encodeToJsonElement(it)
                    )
                }
                value.value.filterKeys { !AuthenticationExtensionsClientOutputs.reserved.contains(it) }
                    .forEach { (key, value) ->
                        put(key, value.jsonElement)
                    }
            }
        )
    }
}
