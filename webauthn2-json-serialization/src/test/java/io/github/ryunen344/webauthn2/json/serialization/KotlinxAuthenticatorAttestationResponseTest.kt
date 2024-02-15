package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAttestationResponse
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAttestationResponseTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticatorAttestationResponseTest : AuthenticatorAttestationResponseTest() {
    @Test
    override fun testSerialize_givenMinimum_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-minimum.json") {
            val actual = JsonUtil.json.encodeToString(minimum)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEmptyTransports_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-empty-transports.json") {
            val actual = JsonUtil.json.encodeToString(emptyTransports)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenTransports_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-transports.json") {
            val actual = JsonUtil.json.encodeToString(transports)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticatorData_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-authenticator-data.json") {
            val actual = JsonUtil.json.encodeToString(authenticatorData)
            assertJson(actual).isEquivalentTo(it)
        }


    @Test
    override fun testSerialize_givenPublicKey_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-public-key.json") {
            val actual = JsonUtil.json.encodeToString(publicKey)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAlgorithm_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-algorithm.json") {
            val actual = JsonUtil.json.encodeToString(algorithm)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenMinimumJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-minimum.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttestationResponse>(it)
            assertThat(actual).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenEmptyTransportsJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-empty-transports.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttestationResponse>(it)
            assertThat(actual).isEqualTo(emptyTransports)
        }

    @Test
    override fun testDeserialize_givenTransportsJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-transports.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttestationResponse>(it)
            assertThat(actual).isEqualTo(transports)
        }

    @Test
    override fun testDeserialize_givenAuthenticatorDataJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-authenticator-data.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttestationResponse>(it)
            assertThat(actual).isEqualTo(authenticatorData)
        }

    @Test
    override fun testDeserialize_givenPublicKeyJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-public-key.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttestationResponse>(it)
            assertThat(actual).isEqualTo(publicKey)
        }

    @Test
    override fun testDeserialize_givenAlgorithmJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-algorithm.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttestationResponse>(it)
            assertThat(actual).isEqualTo(algorithm)
        }
}
