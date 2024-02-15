package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsClientOutputsTest
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticationExtensionsClientOutputsTest : AuthenticationExtensionsClientOutputsTest() {
    @Test
    override fun testSerialize_givenNone_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-none.json") {
            val actual = JsonUtil.json.encodeToString(none)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppid_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appid.json") {
            val actual = JsonUtil.json.encodeToString(appid)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppidExclude_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appidExclude.json") {
            val actual = JsonUtil.json.encodeToString(appidExclude)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUvm_thenSuccess() = runJsonTest("AuthenticationExtensionsClientOutputs-uvm.json") {
        val actual = JsonUtil.json.encodeToString(uvm)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenCredProps_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-credProps.json") {
            val actual = JsonUtil.json.encodeToString(credProps)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenLargeBlob_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-largeBlob.json") {
            val actual = JsonUtil.json.encodeToString(largeBlob)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUndefined_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-undefined.json") {
            val actual = JsonUtil.json.encodeToString(undefined)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenNone_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-none.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientOutputs>(it)
            assertThat(actual).isEqualTo(none)
        }

    @Test
    override fun testDeserialize_givenAppid_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appid.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientOutputs>(it)
            assertThat(actual).isEqualTo(appid)
        }

    @Test
    override fun testDeserialize_givenAppidExclude_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appidExclude.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientOutputs>(it)
            assertThat(actual).isEqualTo(appidExclude)
        }

    @Test
    override fun testDeserialize_givenUvm_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-uvm.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientOutputs>(it)
            assertThat(actual).isEqualTo(uvm)
        }

    @Test
    override fun testDeserialize_givenCredProps_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-credProps.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientOutputs>(it)
            assertThat(actual).isEqualTo(credProps)
        }

    @Test
    override fun testDeserialize_givenLargeBlob_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-largeBlob.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientOutputs>(it)
            assertThat(actual).isEqualTo(largeBlob)
        }

    @Test
    override fun testDeserialize_givenUndefined_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientOutputs>(it)
            assertThat(actual).isEqualTo(undefined)
        }
}
