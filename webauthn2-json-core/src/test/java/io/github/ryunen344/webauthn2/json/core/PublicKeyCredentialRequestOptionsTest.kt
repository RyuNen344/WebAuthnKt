package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class PublicKeyCredentialRequestOptionsTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(PublicKeyCredentialRequestOptions::class.java).verify()
    }

    abstract fun testSerialize_givenMinimum_thenReturnExpected()
    abstract fun testSerialize_givenTimeout_thenReturnExpected()
    abstract fun testSerialize_givenRpId_thenReturnExpected()
    abstract fun testSerialize_givenAllowCredentials_thenReturnExpected()
    abstract fun testSerialize_givenUserVerification_thenReturnExpected()
    abstract fun testDeserialize_givenMinimum_thenReturnExpected()
    abstract fun testDeserialize_givenTimeout_thenReturnExpected()
    abstract fun testDeserialize_givenRpId_thenReturnExpected()
    abstract fun testDeserialize_givenAllowCredentials_thenReturnExpected()
    abstract fun testDeserialize_givenUserVerification_thenReturnExpected()

    companion object {
        val minimum = PublicKeyCredentialRequestOptions(
            challenge = Base64URLString("challenge".encodeToByteArray()),
            timeout = null,
            rpId = null,
            allowCredentials = null,
            userVerification = null,
            extensions = null
        )

        val timeout = PublicKeyCredentialRequestOptions(
            challenge = Base64URLString("challenge".encodeToByteArray()),
            timeout = 6000u,
            rpId = null,
            allowCredentials = null,
            userVerification = null,
            extensions = null
        )

        val rpId = PublicKeyCredentialRequestOptions(
            challenge = Base64URLString("challenge".encodeToByteArray()),
            timeout = null,
            rpId = DOMString("PublicKeyCredentialRequestOptions-rpId"),
            allowCredentials = null,
            userVerification = null,
            extensions = null
        )

        val allowCredentials = PublicKeyCredentialRequestOptions(
            challenge = Base64URLString("challenge".encodeToByteArray()),
            timeout = null,
            rpId = null,
            allowCredentials = listOf(
                PublicKeyCredentialDescriptor(
                    type = PublicKeyCredentialType.PublicKey,
                    id = Base64URLString("PublicKeyCredentialDescriptor-id".encodeToByteArray()),
                    transports = null,
                )
            ),
            userVerification = null,
            extensions = null
        )

        val userVerification = PublicKeyCredentialRequestOptions(
            challenge = Base64URLString("challenge".encodeToByteArray()),
            timeout = null,
            rpId = null,
            allowCredentials = null,
            userVerification = UserVerificationRequirement.Discouraged,
            extensions = null
        )
    }
}
