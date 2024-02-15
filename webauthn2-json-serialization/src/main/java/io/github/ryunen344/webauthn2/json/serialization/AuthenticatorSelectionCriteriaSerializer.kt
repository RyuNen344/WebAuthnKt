package io.github.ryunen344.webauthn2.json.serialization

import io.github.ryunen344.webauthn2.json.core.AuthenticatorSelectionCriteria
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachment
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirement
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

class AuthenticatorSelectionCriteriaSerializer : KSerializer<AuthenticatorSelectionCriteria> {
    override val descriptor: SerialDescriptor =
        buildClassSerialDescriptor("io.github.ryunen344.webauthn2.json.serialization.AuthenticatorSelectionCriteriaSerializer") {
            element<AuthenticatorAttachment>("authenticatorAttachment", isOptional = true)
            element<ResidentKeyRequirement>("residentKey", isOptional = true)
            element<Boolean>("requireResidentKey", isOptional = true)
            element<UserVerificationRequirement>("userVerification", isOptional = true)
        }

    override fun deserialize(decoder: Decoder): AuthenticatorSelectionCriteria {
        return decoder.decodeStructure(descriptor) {
            var authenticatorAttachment: AuthenticatorAttachment? = null
            var residentKey: ResidentKeyRequirement? = null
            var requireResidentKey: Boolean? = null
            var userVerification: UserVerificationRequirement? = null

            do {
                val index = decodeElementIndex(descriptor)
                when (index) {
                    0 -> authenticatorAttachment = decodeNullableSerializableElement(
                        descriptor,
                        0,
                        AuthenticatorAttachment.serializer()
                    )

                    1 -> residentKey =
                        decodeNullableSerializableElement(descriptor, 1, ResidentKeyRequirement.serializer())

                    2 -> requireResidentKey = decodeNullableSerializableElement(descriptor, 2, Boolean.serializer())

                    3 -> userVerification = decodeNullableSerializableElement(
                        descriptor,
                        3,
                        UserVerificationRequirement.serializer()
                    )
                }
            } while (index != CompositeDecoder.DECODE_DONE)

            AuthenticatorSelectionCriteria(
                authenticatorAttachment = authenticatorAttachment,
                residentKey = residentKey,
                requireResidentKey = requireResidentKey,
                userVerification = userVerification
            )
        }
    }

    override fun serialize(encoder: Encoder, value: AuthenticatorSelectionCriteria) {
        encoder.encodeStructure(descriptor) {
            encodeNullableSerializableElement(
                descriptor,
                0,
                AuthenticatorAttachment.serializer(),
                value.authenticatorAttachment
            )
            encodeNullableSerializableElement(descriptor, 1, ResidentKeyRequirement.serializer(), value.residentKey)
            encodeNullableSerializableElement(descriptor, 2, Boolean.serializer(), value.requireResidentKey)
            encodeNullableSerializableElement(
                descriptor,
                3,
                UserVerificationRequirement.serializer(),
                value.userVerification
            )
        }
    }
}
