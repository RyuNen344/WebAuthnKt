package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class PublicKeyCredentialUserEntityTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(PublicKeyCredentialUserEntity::class.java).verify()
    }

    abstract fun testSerialize_givenValue_thenSerialize()
    abstract fun testDeserialize_givenValue_thenDeserialize()

    companion object {
        val value = PublicKeyCredentialUserEntity(
            name = DOMString(value = "PublicKeyCredentialUserEntity-name"),
            id = Base64URLString.decode("UHVibGljS2V5Q3JlZGVudGlhbFVzZXJFbnRpdHktaWQ"),
            displayName = DOMString(value = "PublicKeyCredentialUserEntity-displayName")
        )
    }
}
