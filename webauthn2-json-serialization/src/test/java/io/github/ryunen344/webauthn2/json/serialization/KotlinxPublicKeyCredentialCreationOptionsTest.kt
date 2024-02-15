package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialCreationOptions
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialCreationOptionsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxPublicKeyCredentialCreationOptionsTest : PublicKeyCredentialCreationOptionsTest() {
    @Test
    override fun testSerialize_givenValue_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-minimum.json") {
            val actual = JsonUtil.json.encodeToString(minimum)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenTimeout_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-timeout.json") {
            val actual = JsonUtil.json.encodeToString(timeout)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenExcludeCredentials_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-exclude-credentials.json") {
            val actual = JsonUtil.json.encodeToString(excludeCredentials)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticatorSelection_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-authenticator-selection.json") {
            val actual = JsonUtil.json.encodeToString(authenticatorSelection)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAttestation_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-attestation.json") {
            val actual = JsonUtil.json.encodeToString(attestation)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenValue_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-minimum.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialCreationOptions>(it)
            assertThat(actual).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenTimeout_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-timeout.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialCreationOptions>(it)
            assertThat(actual).isEqualTo(timeout)
        }

    @Test
    override fun testDeserialize_givenExcludeCredentials_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-exclude-credentials.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialCreationOptions>(it)
            assertThat(actual).isEqualTo(excludeCredentials)
        }

    @Test
    override fun testDeserialize_givenAuthenticatorSelection_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-authenticator-selection.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialCreationOptions>(it)
            assertThat(actual).isEqualTo(authenticatorSelection)
        }

    @Test
    override fun testDeserialize_givenAttestation_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-attestation.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialCreationOptions>(it)
            assertThat(actual).isEqualTo(attestation)
        }
}
