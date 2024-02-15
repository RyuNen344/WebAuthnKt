package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class COSEAlgorithmIdentifierTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(COSEAlgorithmIdentifier::class.java).verify()
    }

    abstract fun testSerialize_givenES256_thenSerializeToNegative7()
    abstract fun testSerialize_givenES384_thenSerializeToNegative35()
    abstract fun testSerialize_givenES512_thenSerializeToNegative36()
    abstract fun testSerialize_givenEdDSA_thenSerializeToNegative8()
    abstract fun testSerialize_givenRS256_thenSerializeToNegative257()
    abstract fun testSerialize_givenRS384_thenSerializeToNegative258()
    abstract fun testSerialize_givenRS512_thenSerializeToNegative259()
    abstract fun testDeserialize_givenNegative7_thenDeserializeToES256()
    abstract fun testDeserialize_givenNegative35_thenDeserializeToES384()
    abstract fun testDeserialize_givenNegative36_thenDeserializeToES512()
    abstract fun testDeserialize_givenNegative8_thenDeserializeToEdDSA()
    abstract fun testDeserialize_givenNegative257_thenDeserializeToRS256()
    abstract fun testDeserialize_givenNegative258_thenDeserializeToRS384()
    abstract fun testDeserialize_givenNegative259_thenDeserializeToRS512()
}
