package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.AuthenticatorSelectionCriteria
import io.github.ryunen344.webauthn2.json.core.BufferSource
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialCreationOptions
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialDescriptor
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialParameters
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRpEntity
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialUserEntity
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreference
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

class PublicKeyCredentialCreationOptionsSerializer : KSerializer<PublicKeyCredentialCreationOptions> {
    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("io.github.ryunen344.webauthn2.json.serialization.PublicKeyCredentialCreationOptionsSerializer") {
            element<PublicKeyCredentialRpEntity>("rp")
            element<PublicKeyCredentialUserEntity>("user")
            element<BufferSource>("challenge")
            element<List<PublicKeyCredentialParameters>>("pubKeyCredParams")
            element<ULong>("timeout", isOptional = true)
            element<List<PublicKeyCredentialDescriptor>>("excludeCredentials", isOptional = true)
            element<AuthenticatorSelectionCriteria>("authenticatorSelection", isOptional = true)
            element<AttestationConveyancePreference>("attestation", isOptional = true)
            element<AuthenticationExtensionsClientInputs>("extensions", isOptional = true)
        }

    override fun deserialize(decoder: Decoder): PublicKeyCredentialCreationOptions {
        return decoder.decodeStructure(descriptor) {
            var rp: PublicKeyCredentialRpEntity? = null
            var user: PublicKeyCredentialUserEntity? = null
            var challenge: BufferSource? = null
            var pubKeyCredParams: List<PublicKeyCredentialParameters>? = null
            var timeout: ULong? = null
            var excludeCredentials: List<PublicKeyCredentialDescriptor>? = null
            var authenticatorSelection: AuthenticatorSelectionCriteria? = null
            var attestation: AttestationConveyancePreference? = null
            var extensions: AuthenticationExtensionsClientInputs? = null

            do {
                val index = decodeElementIndex(descriptor)
                when (index) {
                    0 -> rp = decodeSerializableElement(descriptor, index, PublicKeyCredentialRpEntity.serializer())
                    1 -> user = decodeSerializableElement(descriptor, index, PublicKeyCredentialUserEntity.serializer())
                    2 -> challenge = decodeSerializableElement(descriptor, index, BufferSource.serializer())
                    3 -> pubKeyCredParams = decodeSerializableElement(
                        descriptor,
                        index,
                        ListSerializer(PublicKeyCredentialParameters.serializer())
                    )

                    4 -> timeout = decodeNullableSerializableElement(descriptor, index, ULong.serializer())
                    5 -> excludeCredentials = decodeNullableSerializableElement(
                        descriptor,
                        index,
                        ListSerializer(PublicKeyCredentialDescriptor.serializer())
                    )

                    6 -> authenticatorSelection = decodeNullableSerializableElement(
                        descriptor,
                        index,
                        AuthenticatorSelectionCriteria.serializer()
                    )

                    7 -> attestation = decodeNullableSerializableElement(
                        descriptor,
                        index,
                        AttestationConveyancePreference.serializer()
                    )

                    8 -> extensions = decodeNullableSerializableElement(
                        descriptor,
                        index,
                        AuthenticationExtensionsClientInputs.serializer()
                    )
                }
            } while (index != CompositeDecoder.DECODE_DONE)

            PublicKeyCredentialCreationOptions(
                rp = requireNotNull(rp),
                user = requireNotNull(user),
                challenge = requireNotNull(challenge),
                pubKeyCredParams = requireNotNull(pubKeyCredParams),
                timeout = timeout,
                excludeCredentials = excludeCredentials,
                authenticatorSelection = authenticatorSelection,
                attestation = attestation,
                extensions = extensions
            )
        }
    }

    override fun serialize(encoder: Encoder, value: PublicKeyCredentialCreationOptions) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, PublicKeyCredentialRpEntity.serializer(), value.rp)
            encodeSerializableElement(descriptor, 1, PublicKeyCredentialUserEntity.serializer(), value.user)
            encodeSerializableElement(descriptor, 2, BufferSource.serializer(), value.challenge)
            encodeSerializableElement(
                descriptor,
                3,
                ListSerializer(PublicKeyCredentialParameters.serializer()),
                value.pubKeyCredParams
            )
            encodeNullableSerializableElement(descriptor, 4, ULong.serializer(), value.timeout)
            encodeNullableSerializableElement(
                descriptor,
                5,
                ListSerializer(PublicKeyCredentialDescriptor.serializer()),
                value.excludeCredentials
            )
            encodeNullableSerializableElement(
                descriptor,
                6,
                AuthenticatorSelectionCriteria.serializer(),
                value.authenticatorSelection
            )
            encodeNullableSerializableElement(
                descriptor,
                7,
                AttestationConveyancePreference.serializer(),
                value.attestation
            )
            encodeNullableSerializableElement(
                descriptor,
                8,
                AuthenticationExtensionsClientInputs.serializer(),
                value.extensions
            )
        }
    }
}
