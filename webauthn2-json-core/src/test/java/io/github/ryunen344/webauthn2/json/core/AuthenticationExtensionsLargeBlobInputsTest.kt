package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.LargeBlobSupport
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class AuthenticationExtensionsLargeBlobInputsTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(AuthenticationExtensionsLargeBlobInputs::class.java).verify()
    }

    abstract fun testSerialize_givenRegistrationRequired_thenValueIsRegistrationRequired()
    abstract fun testSerialize_givenRegistrationPreferred_thenValueIsRegistrationPreferred()
    abstract fun testSerialize_givenAuthenticationRead_thenValueIsAuthenticationRead()
    abstract fun testSerialize_givenAuthenticationWrite_thenValueIsAuthenticationWrite()
    abstract fun testDeserialize_givenRegistrationRequiredJsonString_thenValueIsRegistrationRequired()
    abstract fun testDeserialize_givenRegistrationPreferredJsonString_thenValueIsRegistrationPreferred()
    abstract fun testDeserialize_givenAuthenticationReadJsonString_thenValueIsAuthenticationRead()
    abstract fun testDeserialize_givenAuthenticationWriteJsonString_thenValueIsAuthenticationWrite()

    companion object {
        val registrationRequired = AuthenticationExtensionsLargeBlobInputs(
            support = LargeBlobSupport.Required,
            read = null,
            write = null,
        )

        val registrationPreferred = AuthenticationExtensionsLargeBlobInputs(
            support = LargeBlobSupport.Preferred,
            read = null,
            write = null,
        )

        val authenticationRead = AuthenticationExtensionsLargeBlobInputs(
            support = null,
            read = true,
            write = null,
        )

        val authenticationWrite = AuthenticationExtensionsLargeBlobInputs(
            support = null,
            read = null,
            write = Base64URLString.decode("VVZaT1VsbFdWVEpoVlVwWlkxaEdjRlF5WkdGYU1FWXhaRWRvYkdKdVVuQlpNa1l3WVZjNWRWSllhREJhVnpWNllWYzVkV013ZUdoamJXUnNVVzE0ZGxscmJIVmpTRll3WTNjOVBR"),
        )
    }
}
