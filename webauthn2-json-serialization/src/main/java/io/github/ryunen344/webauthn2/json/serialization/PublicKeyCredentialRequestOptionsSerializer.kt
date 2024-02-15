package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.BufferSource
import io.github.ryunen344.webauthn2.json.core.DOMString
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialDescriptor
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRequestOptions
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

class PublicKeyCredentialRequestOptionsSerializer : KSerializer<PublicKeyCredentialRequestOptions> {
    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("io.github.ryunen344.webauthn2.json.serialization.PublicKeyCredentialRequestOptionsSerializer") {
            element<BufferSource>("challenge")
            element<ULong>("timeout", isOptional = true)
            element<DOMString>("rpId", isOptional = true)
            element<List<PublicKeyCredentialDescriptor>>("allowCredentials", isOptional = true)
            element<UserVerificationRequirement>("userVerification", isOptional = true)
            element<AuthenticationExtensionsClientInputs>("extensions", isOptional = true)
        }

    override fun deserialize(decoder: Decoder): PublicKeyCredentialRequestOptions {
        return decoder.decodeStructure(descriptor) {
            var challenge: BufferSource? = null
            var timeout: ULong? = null
            var rpId: DOMString? = null
            var allowCredentials: List<PublicKeyCredentialDescriptor>? = null
            var userVerification: UserVerificationRequirement? = null
            var extensions: AuthenticationExtensionsClientInputs? = null

            do {
                val index = decodeElementIndex(descriptor)
                when (index) {
                    0 -> challenge = decodeSerializableElement(descriptor, index, BufferSource.serializer())
                    1 -> timeout = decodeNullableSerializableElement(descriptor, index, ULong.serializer())
                    2 -> rpId = decodeNullableSerializableElement(descriptor, index, DOMString.serializer())
                    3 -> allowCredentials = decodeNullableSerializableElement(
                        descriptor,
                        index,
                        ListSerializer(PublicKeyCredentialDescriptor.serializer())
                    )

                    4 -> userVerification = decodeNullableSerializableElement(
                        descriptor,
                        index,
                        UserVerificationRequirement.serializer()
                    )

                    5 -> extensions = decodeNullableSerializableElement(
                        descriptor,
                        index,
                        AuthenticationExtensionsClientInputs.serializer()
                    )
                }
            } while (index != CompositeDecoder.DECODE_DONE)

            PublicKeyCredentialRequestOptions(
                challenge = requireNotNull(challenge),
                timeout = timeout,
                rpId = rpId,
                allowCredentials = allowCredentials,
                userVerification = userVerification,
                extensions = extensions
            )
        }
    }

    override fun serialize(encoder: Encoder, value: PublicKeyCredentialRequestOptions) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, BufferSource.serializer(), value.challenge)
            encodeNullableSerializableElement(descriptor, 1, ULong.serializer(), value.timeout)
            encodeNullableSerializableElement(descriptor, 2, DOMString.serializer(), value.rpId)
            encodeNullableSerializableElement(
                descriptor,
                3,
                ListSerializer(PublicKeyCredentialDescriptor.serializer()),
                value.allowCredentials
            )
            encodeNullableSerializableElement(
                descriptor,
                4,
                UserVerificationRequirement.serializer(),
                value.userVerification
            )
            encodeNullableSerializableElement(
                descriptor,
                5,
                AuthenticationExtensionsClientInputs.serializer(),
                value.extensions
            )
        }
    }
}
