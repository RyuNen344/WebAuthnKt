package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

class DOMStringTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(DOMString::class.java).verify()
    }
}
