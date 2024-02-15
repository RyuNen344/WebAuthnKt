package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class AuthenticationExtensionsLargeBlobOutputsTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(AuthenticationExtensionsLargeBlobOutputs::class.java).verify()
    }

    abstract fun testSerialize_givenRegistrationSupported_thenValueIsRegistrationSupported()
    abstract fun testSerialize_givenAuthenticationRead_thenValueIsAuthenticationRead()
    abstract fun testSerialize_givenAuthenticationWrite_thenValueIsAuthenticationWrite()
    abstract fun testDeserialize_givenRegistrationSupportedJsonString_thenValueIsRegistrationSupported()
    abstract fun testDeserialize_givenAuthenticationReadJsonString_thenValueIsAuthenticationRead()
    abstract fun testDeserialize_givenAuthenticationWriteJsonString_thenValueIsAuthenticationWrite()

    companion object {
        val registrationSupported = AuthenticationExtensionsLargeBlobOutputs(
            supported = true,
            blob = null,
            written = null
        )

        val authenticationRead = AuthenticationExtensionsLargeBlobOutputs(
            supported = null,
            blob = Base64URLString.decode("VmxaYVUxSXlSa2RUYWxwVllsUldjRlJYZUhabFJscHlZVVpPYVdGNlVqVlZiWGhUWVRGS1ZsZFlhR0ZTVjFKMldXdGtTMlJXVm5WUmJIQk9ZVEZzTTFkV1dtcE9WMUpYVTJ4c2FGSkZTbWhXYm5CWFRteHNWMWw2Vm10V01ERXpXbFZrYjJGdFNsaFZiazVXVm5wRk1GcEhlSE5qYXpsVlVtMTBWRkpWYkRSWGExWnZWR3hDVWc"),
            written = null
        )

        val authenticationWrite = AuthenticationExtensionsLargeBlobOutputs(
            supported = null,
            blob = null,
            written = true
        )
    }
}
