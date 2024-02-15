package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRequestOptions
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRequestOptionsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxPublicKeyCredentialRequestOptionsTest : PublicKeyCredentialRequestOptionsTest() {
    @Test
    override fun testSerialize_givenMinimum_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-minimum.json") {
            val actual = JsonUtil.json.encodeToString(minimum)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenTimeout_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-timeout.json") {
            val actual = JsonUtil.json.encodeToString(timeout)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRpId_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-rp-id.json") {
            val actual = JsonUtil.json.encodeToString(rpId)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAllowCredentials_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-allow-credentials.json") {
            val actual = JsonUtil.json.encodeToString(allowCredentials)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUserVerification_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-user-verification.json") {
            val actual = JsonUtil.json.encodeToString(userVerification)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenMinimum_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-minimum.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialRequestOptions>(it)
            assertThat(actual).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenTimeout_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-timeout.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialRequestOptions>(it)
            assertThat(actual).isEqualTo(timeout)
        }

    @Test
    override fun testDeserialize_givenRpId_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-rp-id.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialRequestOptions>(it)
            assertThat(actual).isEqualTo(rpId)
        }

    @Test
    override fun testDeserialize_givenAllowCredentials_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-allow-credentials.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialRequestOptions>(it)
            assertThat(actual).isEqualTo(allowCredentials)
        }

    @Test
    override fun testDeserialize_givenUserVerification_thenReturnExpected() =
        runJsonTest("PublicKeyCredentialRequestOptions-user-verification.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialRequestOptions>(it)
            assertThat(actual).isEqualTo(userVerification)
        }
}
