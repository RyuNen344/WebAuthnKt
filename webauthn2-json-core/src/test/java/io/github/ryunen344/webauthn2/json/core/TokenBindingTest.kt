package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatus
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class TokenBindingTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(TokenBinding::class.java).verify()
    }

    abstract fun testSerialize_givenId_thenSuccess()
    abstract fun testSerialize_givenNullId_thenSuccess()
    abstract fun testDeserialize_givenId_thenSuccess()
    abstract fun testDeserialize_givenNullId_thenSuccess()

    companion object {
        val id = TokenBinding(
            status = TokenBindingStatus.Supported,
            id = DOMString("TokenBinding-id"),
        )

        val nullId = TokenBinding(
            status = TokenBindingStatus.Supported,
            id = null,
        )
    }
}
