package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialCreationOptions
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialCreationOptionsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiPublicKeyCredentialCreationOptionsTest : PublicKeyCredentialCreationOptionsTest() {
    @Test
    override fun testSerialize_givenValue_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-minimum.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.toJson(minimum)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenTimeout_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-timeout.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.toJson(timeout)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenExcludeCredentials_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-exclude-credentials.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.toJson(excludeCredentials)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticatorSelection_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-authenticator-selection.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.toJson(authenticatorSelection)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAttestation_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-attestation.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.toJson(attestation)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenValue_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-minimum.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenTimeout_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-timeout.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(timeout)
        }

    @Test
    override fun testDeserialize_givenExcludeCredentials_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-exclude-credentials.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(excludeCredentials)
        }

    @Test
    override fun testDeserialize_givenAuthenticatorSelection_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-authenticator-selection.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(authenticatorSelection)
        }

    @Test
    override fun testDeserialize_givenAttestation_thenSuccess() =
        runJsonTest("PublicKeyCredentialCreationOptions-attestation.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialCreationOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(attestation)
        }
}
