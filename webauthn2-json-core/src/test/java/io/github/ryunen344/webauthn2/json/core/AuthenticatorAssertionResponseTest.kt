package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class AuthenticatorAssertionResponseTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(AuthenticatorAssertionResponse::class.java).verify()
    }

    abstract fun testSerialize_givenHandler_thenSuccess()
    abstract fun testSerialize_givenEmptyHandler_thenSuccess()
    abstract fun testDeserialize_givenHandlerJsonString_thenSuccess()
    abstract fun testDeserialize_givenEmptyHandlerJsonString_thenSuccess()

    companion object {
        val handle = AuthenticatorAssertionResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            authenticatorData = Base64URLString.decode("WUpJZmpyT3hVb2U2aUxlZEoxdmVhc29HYzZ2MWduTmpRUmo4UHVSQTJnYk45aTRW"),
            signature = Base64URLString.decode("amZiNGxzNEFRQlRyT25SbA"),
            userHandle = Base64URLString.decode("SmpWTmdxRzBLZGFaalJZYw"),
        )

        val emptyHandle = AuthenticatorAssertionResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            authenticatorData = Base64URLString.decode("WUpJZmpyT3hVb2U2aUxlZEoxdmVhc29HYzZ2MWduTmpRUmo4UHVSQTJnYk45aTRW"),
            signature = Base64URLString.decode("TW1MZlpsWkN2THBiUDJrZw"),
            userHandle = null,
        )
    }
}
