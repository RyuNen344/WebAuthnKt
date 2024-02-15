package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatus
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class CollectedClientDataTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(CollectedClientData::class.java).verify()
    }

    abstract fun testSerialize_givenMinimum_thenSuccess()
    abstract fun testSerialize_givenCrossOrigin_thenSuccess()
    abstract fun testSerialize_givenToken_thenSuccess()
    abstract fun testDeserialize_givenMinimum_thenSuccess()
    abstract fun testDeserialize_givenCrossOrigin_thenSuccess()
    abstract fun testDeserialize_givenToken_thenSuccess()

    companion object {
        val minimum = CollectedClientData(
            type = DOMString("webauthn.create"),
            challenge = Base64URLString.decode("eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9"),
            origin = DOMString("https://github.com/RyuNen344/WebAuthnKt"),
            crossOrigin = null,
            tokenBinding = null
        )

        val crossOrigin = CollectedClientData(
            type = DOMString("webauthn.create"),
            challenge = Base64URLString.decode("eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9"),
            origin = DOMString("https://github.com/RyuNen344/WebAuthnKt"),
            crossOrigin = true,
            tokenBinding = null
        )

        val token = CollectedClientData(
            type = DOMString("webauthn.get"),
            challenge = Base64URLString.decode("eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9"),
            origin = DOMString("https://github.com/RyuNen344/WebAuthnKt"),
            crossOrigin = null,
            tokenBinding = TokenBinding(
                status = TokenBindingStatus.Supported,
                id = null
            )
        )
    }
}
