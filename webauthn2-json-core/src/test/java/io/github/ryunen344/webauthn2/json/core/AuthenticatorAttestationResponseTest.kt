package io.github.ryunen344.webauthn2.json.core

import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class AuthenticatorAttestationResponseTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(AuthenticatorAttestationResponse::class.java).verify()
    }

    abstract fun testSerialize_givenMinimum_thenSuccess()
    abstract fun testSerialize_givenEmptyTransports_thenSuccess()
    abstract fun testSerialize_givenTransports_thenSuccess()
    abstract fun testSerialize_givenAuthenticatorData_thenSuccess()
    abstract fun testSerialize_givenPublicKey_thenSuccess()
    abstract fun testSerialize_givenAlgorithm_thenSuccess()
    abstract fun testDeserialize_givenMinimumJsonString_thenSuccess()
    abstract fun testDeserialize_givenEmptyTransportsJsonString_thenSuccess()
    abstract fun testDeserialize_givenTransportsJsonString_thenSuccess()
    abstract fun testDeserialize_givenAuthenticatorDataJsonString_thenSuccess()
    abstract fun testDeserialize_givenPublicKeyJsonString_thenSuccess()
    abstract fun testDeserialize_givenAlgorithmJsonString_thenSuccess()

    companion object {
        val minimum = AuthenticatorAttestationResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            attestationObject = Base64URLString.decode("TEE1T2xhZWtqbE1iVXEzM09zRkx6STNsbWRUMmhqaEptMnFEZ2pRcEZYQkVwMFY5"),
            transports = null,
            authenticatorData = null,
            publicKey = null,
            publicKeyAlgorithm = null
        )

        val emptyTransports = AuthenticatorAttestationResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            attestationObject = Base64URLString.decode("NFJyUE1vR21aUVhzbUhqSWJBRlJLMXhRWU5EVlY0NVpydTlvcnZOd05NWXFyakdW"),
            transports = emptyList(),
            authenticatorData = null,
            publicKey = null,
            publicKeyAlgorithm = null
        )

        val transports = AuthenticatorAttestationResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            attestationObject = Base64URLString.decode("dmkxOWVjWU4zbVNXNVRIeU5DS0RIaGVWc0hPd1BEMWl6UE5ITzkyeEdDV0VvNHZl"),
            transports = listOf(AuthenticatorTransport.Usb),
            authenticatorData = null,
            publicKey = null,
            publicKeyAlgorithm = null
        )

        val authenticatorData = AuthenticatorAttestationResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            attestationObject = Base64URLString.decode("aU5oYmdUa29vczFoeldqd05YR09VNm5lU1VrbkVKOENnRlNtQVdWcDRHVEhwUXBt"),
            transports = null,
            authenticatorData = Base64URLString.decode("WUpJZmpyT3hVb2U2aUxlZEoxdmVhc29HYzZ2MWduTmpRUmo4UHVSQTJnYk45aTRW"),
            publicKey = null,
            publicKeyAlgorithm = null
        )

        val publicKey = AuthenticatorAttestationResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            attestationObject = Base64URLString.decode("R3dPQVZ3aXp0NjBhazJhZ2R3MFNRUU9WYmVoUGdha1ZXanAxUjBJcmZSb01TMEpL"),
            transports = null,
            authenticatorData = null,
            publicKey = Base64URLString.decode("aU9lZlNkSzg2akdHYmxOemhzNVJTRTI2d1dxb3lOcXJyclR0YUFEejNyQnR2S2No"),
            publicKeyAlgorithm = null
        )

        val algorithm = AuthenticatorAttestationResponse(
            clientDataJSON = Base64URLString.decode("eyJvcmlnaW4iOiJodHRwczovL2dpdGh1Yi5jb20vUnl1TmVuMzQ0L1dlYkF1dGhuS3QiLCJjaGFsbGVuZ2UiOiJhWG8wY25JMGMzUk1TWGRhYkZBMVNBIiwidHlwZSI6IndlYmF1dGhuLmNyZWF0ZSIsImNyb3NzT3JpZ2luIjpmYWxzZSwidG9rZW5CaW5kaW5nIjp7InN0YXR1cyI6InN1cHBvcnRlZCJ9fQ"),
            attestationObject = Base64URLString.decode("NkpkbFRMcWlYc2ZEaUtUa2hJYXZIanhBZkx2a3paRjNTSUFlUXc2aGJCaG43MVBX"),
            transports = null,
            authenticatorData = null,
            publicKey = null,
            publicKeyAlgorithm = COSEAlgorithmIdentifier.RS256
        )
    }
}
