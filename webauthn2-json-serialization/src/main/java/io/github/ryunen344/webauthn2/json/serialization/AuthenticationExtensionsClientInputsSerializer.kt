package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobInputs
import io.github.ryunen344.webauthn2.json.core.DOMString
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
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
 * serializer for [AuthenticationExtensionsClientInputs]
 * serialize explicit object to object e.g) [appid], [appidExclude], [uvm], [credProps], [largeBlob]
 * serialize unknown object to Primitives, [JsonElement], [JsonObject]
 */
class AuthenticationExtensionsClientInputsSerializer : KSerializer<AuthenticationExtensionsClientInputs> {

    override val descriptor: SerialDescriptor =
        buildSerialDescriptor(
            "io.github.ryunen344.webauthn2.json.serialization.AuthenticationExtensionsClientInputsSerializer",
            StructureKind.MAP
        )

    override fun deserialize(decoder: Decoder): AuthenticationExtensionsClientInputs {
        require(decoder is JsonDecoder)
        val json = decoder.decodeJsonElement() as JsonObject
        return AuthenticationExtensionsClientInputs(
            buildMap {
                json[AuthenticationExtensionsClientInputs.reserved[0]]?.let {
                    put(
                        AuthenticationExtensionsClientInputs.reserved[0],
                        decoder.json.decodeFromJsonElement(DOMString.serializer(), it)
                    )
                }
                json[AuthenticationExtensionsClientInputs.reserved[1]]?.let {
                    put(
                        AuthenticationExtensionsClientInputs.reserved[1],
                        decoder.json.decodeFromJsonElement(DOMString.serializer(), it)
                    )
                }
                json[AuthenticationExtensionsClientInputs.reserved[2]]?.jsonPrimitive?.boolean?.let {
                    put(AuthenticationExtensionsClientInputs.reserved[2], it)
                }
                json[AuthenticationExtensionsClientInputs.reserved[3]]?.jsonPrimitive?.boolean?.let {
                    put(AuthenticationExtensionsClientInputs.reserved[3], it)
                }
                json[AuthenticationExtensionsClientInputs.reserved[4]]?.let {
                    put(
                        AuthenticationExtensionsClientInputs.reserved[4],
                        decoder.json.decodeFromJsonElement(AuthenticationExtensionsLargeBlobInputs.serializer(), it)
                    )
                }
                putAll(
                    json.filterKeys { !AuthenticationExtensionsClientInputs.reserved.contains(it) }
                        .mapNotNull { (key, value) -> value.extractedContent?.let { key to it } }
                        .associate { it }
                )
            }
        )
    }

    override fun serialize(encoder: Encoder, value: AuthenticationExtensionsClientInputs) {
        require(encoder is JsonEncoder)
        encoder.encodeJsonElement(
            buildJsonObject {
                value.appid?.let {
                    put(
                        AuthenticationExtensionsClientInputs.reserved[0],
                        encoder.json.encodeToJsonElement(it)
                    )
                }
                value.appidExclude?.let {
                    put(
                        AuthenticationExtensionsClientInputs.reserved[1],
                        encoder.json.encodeToJsonElement(it)
                    )
                }
                value.uvm?.let { put(AuthenticationExtensionsClientInputs.reserved[2], JsonPrimitive(it)) }
                value.credProps?.let { put(AuthenticationExtensionsClientInputs.reserved[3], JsonPrimitive(it)) }
                value.largeBlob?.let {
                    put(
                        AuthenticationExtensionsClientInputs.reserved[4],
                        encoder.json.encodeToJsonElement(it)
                    )
                }
                value.value.filterKeys { !AuthenticationExtensionsClientInputs.reserved.contains(it) }
                    .forEach { (key, value) ->
                        put(key, value.jsonElement)
                    }
            }
        )
    }
}
