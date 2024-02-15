package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class PublicKeyCredentialParametersTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(PublicKeyCredentialParameters::class.java).verify()
    }

    abstract fun testSerialize_givenValue_thenSerialize()
    abstract fun testDeserialize_givenValue_thenDeserialize()

    companion object {
        val value = PublicKeyCredentialParameters(
            type = PublicKeyCredentialType.PublicKey,
            alg = COSEAlgorithmIdentifier.ES256
        )
    }
}
