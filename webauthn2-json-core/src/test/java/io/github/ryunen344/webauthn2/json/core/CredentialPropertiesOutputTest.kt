package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class CredentialPropertiesOutputTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(CredentialPropertiesOutput::class.java).verify()
    }

    abstract fun testSerialize_givenNull_thenSerializeToUndefined()
    abstract fun testSerialize_givenRKTrue_thenSerializeToTrue()
    abstract fun testSerialize_givenRKFalse_thenSerializeToFalse()
    abstract fun testDeserialize_givenUndefined_thenDeserializeToNull()
    abstract fun testDeserialize_givenTrue_thenDeserializeToRKTrue()
    abstract fun testDeserialize_givenFalse_thenDeserializeToRKFalse()
}
