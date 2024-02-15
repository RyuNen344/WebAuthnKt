package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class PublicKeyCredentialDescriptorTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(PublicKeyCredentialDescriptor::class.java).verify()
    }

    abstract fun testSerialize_givenTransport_thenSuccess()
    abstract fun testSerialize_givenEmptyTransport_thenSuccess()
    abstract fun testDeserialize_givenTransport_thenSuccess()
    abstract fun testDeserialize_givenEmptyTransport_thenSuccess()

    companion object {
        val transport = PublicKeyCredentialDescriptor(
            type = PublicKeyCredentialType.PublicKey,
            id = Base64URLString.decode("UHVibGljS2V5Q3JlZGVudGlhbERlc2NyaXB0b3ItaWQ"),
            transports = listOf(
                AuthenticatorTransport.Ble,
                AuthenticatorTransport.Internal,
                AuthenticatorTransport.Nfc,
                AuthenticatorTransport.Usb
            )
        )

        val emptyTransport = PublicKeyCredentialDescriptor(
            type = PublicKeyCredentialType.PublicKey,
            id = Base64URLString.decode("UHVibGljS2V5Q3JlZGVudGlhbERlc2NyaXB0b3ItaWQ"),
            transports = null
        )
    }
}
