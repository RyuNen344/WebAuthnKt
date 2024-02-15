package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class PublicKeyCredentialRpEntityTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(PublicKeyCredentialUserEntity::class.java).verify()
    }

    abstract fun testSerialize_givenId_thenSuccess()
    abstract fun testSerialize_givenNullId_thenSuccess()
    abstract fun testDeserialize_givenId_thenSuccess()
    abstract fun testDeserialize_givenNullId_thenSuccess()

    companion object {
        val id = PublicKeyCredentialRpEntity(
            name = DOMString("PublicKeyCredentialRpEntity-name"),
            id = DOMString("PublicKeyCredentialRpEntity-id")
        )

        val emptyId = PublicKeyCredentialRpEntity(
            name = DOMString("PublicKeyCredentialRpEntity-name"),
            id = null
        )
    }
}
