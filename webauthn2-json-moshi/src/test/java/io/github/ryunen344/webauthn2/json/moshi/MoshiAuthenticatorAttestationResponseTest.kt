package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAttestationResponse
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAttestationResponseTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticatorAttestationResponseTest : AuthenticatorAttestationResponseTest() {
    @Test
    override fun testSerialize_givenMinimum_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-minimum.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val serialized = adapter.toJson(minimum)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEmptyTransports_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-empty-transports.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val serialized = adapter.toJson(emptyTransports)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenTransports_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-transports.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val serialized = adapter.toJson(transports)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticatorData_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-authenticator-data.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val serialized = adapter.toJson(authenticatorData)
            assertJson(serialized).isEquivalentTo(it)
        }


    @Test
    override fun testSerialize_givenPublicKey_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-public-key.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val serialized = adapter.toJson(publicKey)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAlgorithm_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-algorithm.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val serialized = adapter.toJson(algorithm)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenMinimumJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-minimum.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenEmptyTransportsJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-empty-transports.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(emptyTransports)
        }

    @Test
    override fun testDeserialize_givenTransportsJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-transports.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(transports)
        }

    @Test
    override fun testDeserialize_givenAuthenticatorDataJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-authenticator-data.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(authenticatorData)
        }

    @Test
    override fun testDeserialize_givenPublicKeyJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-public-key.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(publicKey)
        }

    @Test
    override fun testDeserialize_givenAlgorithmJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAttestationResponse-algorithm.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttestationResponse::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(algorithm)
        }
}
