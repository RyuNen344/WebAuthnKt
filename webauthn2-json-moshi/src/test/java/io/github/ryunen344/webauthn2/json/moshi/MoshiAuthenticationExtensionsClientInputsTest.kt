package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsClientInputsTest
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticationExtensionsClientInputsTest : AuthenticationExtensionsClientInputsTest() {
    @Test
    override fun testSerialize_givenNone_thenReturnEmptyMap() =
        runJsonTest("AuthenticationExtensionsClientInputs-none.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.toJson(none)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppid_thenReturnMapWithAppid() =
        runJsonTest("AuthenticationExtensionsClientInputs-appid.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.toJson(appid)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppidExclude_thenReturnMapWithAppidExclude() =
        runJsonTest("AuthenticationExtensionsClientInputs-appidExclude.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.toJson(appidExclude)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUvm_thenReturnMapWithUvm() =
        runJsonTest("AuthenticationExtensionsClientInputs-uvm.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.toJson(uvm)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenCredProps_thenReturnMapWithCredProps() =
        runJsonTest("AuthenticationExtensionsClientInputs-credProps.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.toJson(credProps)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenLargeBlob_thenReturnMapWithLargeBlob() =
        runJsonTest("AuthenticationExtensionsClientInputs-largeBlob.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.toJson(largeBlob)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUndefined_thenReturnUndefined() =
        runJsonTest("AuthenticationExtensionsClientInputs-undefined.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.toJson(undefined)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenEmptyMap_thenReturnNone() =
        runJsonTest("AuthenticationExtensionsClientInputs-none.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(none)
        }

    @Test
    override fun testDeserialize_givenMapWithAppid_thenReturnAppid() =
        runJsonTest("AuthenticationExtensionsClientInputs-appid.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(appid)
        }

    @Test
    override fun testDeserialize_givenMapWithAppidExclude_thenReturnAppidExclude() =
        runJsonTest("AuthenticationExtensionsClientInputs-appidExclude.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(appidExclude)
        }

    @Test
    override fun testDeserialize_givenMapWithUvm_thenReturnUvm() =
        runJsonTest("AuthenticationExtensionsClientInputs-uvm.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(uvm)
        }

    @Test
    override fun testDeserialize_givenMapWithCredProps_thenReturnCredProps() =
        runJsonTest("AuthenticationExtensionsClientInputs-credProps.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(credProps)
        }

    @Test
    override fun testDeserialize_givenMapWithLargeBlob_thenReturnLargeBlob() =
        runJsonTest("AuthenticationExtensionsClientInputs-largeBlob.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(largeBlob)
        }

    @Test
    override fun testDeserialize_givenUndefined_thenReturnUndefined() =
        runJsonTest("AuthenticationExtensionsClientInputs-undefined.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsClientInputs::class)
            // moshi serializes number to double
            val expect = AuthenticationExtensionsClientInputs(
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
