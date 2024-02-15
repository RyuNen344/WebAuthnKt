package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsClientOutputsTest
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticationExtensionsClientOutputsTest : AuthenticationExtensionsClientOutputsTest() {
    @Test
    override fun testSerialize_givenNone_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-none.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.toJson(none)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppid_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appid.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.toJson(appid)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppidExclude_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appidExclude.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.toJson(appidExclude)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUvm_thenSuccess() = runJsonTest("AuthenticationExtensionsClientOutputs-uvm.json") {
        val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
        val actual = adapter.toJson(uvm)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenCredProps_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-credProps.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.toJson(credProps)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenLargeBlob_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-largeBlob.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.toJson(largeBlob)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUndefined_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-undefined.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.toJson(undefined)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenNone_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-none.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(none)
        }

    @Test
    override fun testDeserialize_givenAppid_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appid.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(appid)
        }

    @Test
    override fun testDeserialize_givenAppidExclude_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-appidExclude.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(appidExclude)
        }

    @Test
    override fun testDeserialize_givenUvm_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-uvm.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(uvm)
        }

    @Test
    override fun testDeserialize_givenCredProps_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-credProps.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(credProps)
        }

    @Test
    override fun testDeserialize_givenLargeBlob_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-largeBlob.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(largeBlob)
        }

    @Test
    override fun testDeserialize_givenUndefined_thenSuccess() =
        runJsonTest("AuthenticationExtensionsClientOutputs-undefined.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientOutputs::class)
            // moshi serializes number to double
            val expect = AuthenticationExtensionsClientOutputs(
                mapOf(
                    "boolean" to true,
                    "number" to 1.0,
                    "string" to "string",
                    "array" to listOf(1.0, 2.0, 3.0),
                    "object" to mapOf("key" to "value")
                )
            )
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(expect)
        }
}
