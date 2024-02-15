package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRequestOptions
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRequestOptionsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiPublicKeyCredentialRequestOptionsTest : PublicKeyCredentialRequestOptionsTest() {
    @Test
    override fun testSerialize_givenMinimum_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-minimum.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.toJson(minimum)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenTimeout_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-timeout.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.toJson(timeout)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRpId_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-rp-id.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.toJson(rpId)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAllowCredentials_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-allow-credentials.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.toJson(allowCredentials)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUserVerification_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-user-verification.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.toJson(userVerification)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenMinimum_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-minimum.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenTimeout_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-timeout.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(timeout)
        }

    @Test
    override fun testDeserialize_givenRpId_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-rp-id.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(rpId)
        }

    @Test
    override fun testDeserialize_givenAllowCredentials_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-allow-credentials.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(allowCredentials)
        }

    @Test
    override fun testDeserialize_givenUserVerification_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-user-verification.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialRequestOptions::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(userVerification)
        }
}
