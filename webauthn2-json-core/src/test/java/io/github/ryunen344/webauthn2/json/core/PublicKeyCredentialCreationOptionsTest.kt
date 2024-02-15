package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreference
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachment
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class PublicKeyCredentialCreationOptionsTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(PublicKeyCredentialCreationOptions::class.java).verify()
    }

    abstract fun testSerialize_givenValue_thenSuccess()
    abstract fun testSerialize_givenTimeout_thenSuccess()
    abstract fun testSerialize_givenExcludeCredentials_thenSuccess()
    abstract fun testSerialize_givenAuthenticatorSelection_thenSuccess()
    abstract fun testSerialize_givenAttestation_thenSuccess()
    abstract fun testDeserialize_givenValue_thenSuccess()
    abstract fun testDeserialize_givenTimeout_thenSuccess()
    abstract fun testDeserialize_givenExcludeCredentials_thenSuccess()
    abstract fun testDeserialize_givenAuthenticatorSelection_thenSuccess()
    abstract fun testDeserialize_givenAttestation_thenSuccess()

    companion object {
        val minimum = PublicKeyCredentialCreationOptions(
            rp = PublicKeyCredentialRpEntity(
                name = DOMString("PublicKeyCredentialRpEntity-name"),
                id = null
            ),
            user = PublicKeyCredentialUserEntity(
                name = DOMString("PublicKeyCredentialUserEntity-name"),
                id = Base64URLString.decode("PublicKeyCredentialUserEntity-id"),
                displayName = DOMString(value = "PublicKeyCredentialUserEntity-displayName")
            ),
            challenge = Base64URLString.decode("Y2hhbGxlbmdl"),
            pubKeyCredParams = listOf(
                PublicKeyCredentialParameters(
                    alg = COSEAlgorithmIdentifier.ES256
                )
            ),
            timeout = null,
            excludeCredentials = null,
            authenticatorSelection = null,
            attestation = null,
            extensions = null
        )

        val timeout = PublicKeyCredentialCreationOptions(
            rp = PublicKeyCredentialRpEntity(
                name = DOMString("PublicKeyCredentialRpEntity-name"),
                id = null
            ),
            user = PublicKeyCredentialUserEntity(
                name = DOMString("PublicKeyCredentialUserEntity-name"),
                id = Base64URLString.decode("PublicKeyCredentialUserEntity-id"),
                displayName = DOMString(value = "PublicKeyCredentialUserEntity-displayName")
            ),
            challenge = Base64URLString.decode("Y2hhbGxlbmdl"),
            pubKeyCredParams = listOf(
                PublicKeyCredentialParameters(
                    alg = COSEAlgorithmIdentifier.ES256
                )
            ),
            timeout = 6000.toULong(),
            excludeCredentials = null,
            authenticatorSelection = null,
            attestation = null,
            extensions = null
        )

        val excludeCredentials = PublicKeyCredentialCreationOptions(
            rp = PublicKeyCredentialRpEntity(
                name = DOMString("PublicKeyCredentialRpEntity-name"),
                id = null
            ),
            user = PublicKeyCredentialUserEntity(
                name = DOMString("PublicKeyCredentialUserEntity-name"),
                id = Base64URLString.decode("PublicKeyCredentialUserEntity-id"),
                displayName = DOMString(value = "PublicKeyCredentialUserEntity-displayName")
            ),
            challenge = Base64URLString.decode("Y2hhbGxlbmdl"),
            pubKeyCredParams = listOf(
                PublicKeyCredentialParameters(
                    alg = COSEAlgorithmIdentifier.ES256
                )
            ),
            timeout = null,
            excludeCredentials = listOf(
                PublicKeyCredentialDescriptor(
                    type = PublicKeyCredentialType.PublicKey,
                    id = Base64URLString.decode("UHVibGljS2V5Q3JlZGVudGlhbERlc2NyaXB0b3ItaWQ"),
                    transports = null,
                )
            ),
            authenticatorSelection = null,
            attestation = null,
            extensions = null
        )

        val authenticatorSelection = PublicKeyCredentialCreationOptions(
            rp = PublicKeyCredentialRpEntity(
                name = DOMString("PublicKeyCredentialRpEntity-name"),
                id = null
            ),
            user = PublicKeyCredentialUserEntity(
                name = DOMString("PublicKeyCredentialUserEntity-name"),
                id = Base64URLString.decode("PublicKeyCredentialUserEntity-id"),
                displayName = DOMString(value = "PublicKeyCredentialUserEntity-displayName")
            ),
            challenge = Base64URLString.decode("Y2hhbGxlbmdl"),
            pubKeyCredParams = listOf(
                PublicKeyCredentialParameters(
                    alg = COSEAlgorithmIdentifier.ES256
                )
            ),
            timeout = null,
            excludeCredentials = null,
            authenticatorSelection = AuthenticatorSelectionCriteria(
                authenticatorAttachment = AuthenticatorAttachment.CrossPlatform,
                residentKey = null,
                requireResidentKey = null,
                userVerification = null,
            ),
            attestation = null,
            extensions = null
        )

        val attestation = PublicKeyCredentialCreationOptions(
            rp = PublicKeyCredentialRpEntity(
                name = DOMString("PublicKeyCredentialRpEntity-name"),
                id = null
            ),
            user = PublicKeyCredentialUserEntity(
                name = DOMString("PublicKeyCredentialUserEntity-name"),
                id = Base64URLString.decode("PublicKeyCredentialUserEntity-id"),
                displayName = DOMString(value = "PublicKeyCredentialUserEntity-displayName")
            ),
            challenge = Base64URLString.decode("Y2hhbGxlbmdl"),
            pubKeyCredParams = listOf(
                PublicKeyCredentialParameters(
                    alg = COSEAlgorithmIdentifier.ES256
                )
            ),
            timeout = null,
            excludeCredentials = null,
            authenticatorSelection = null,
            attestation = AttestationConveyancePreference.Direct,
            extensions = null
        )
    }
}
