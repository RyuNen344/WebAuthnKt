package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsClientInputsTest
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticationExtensionsClientInputsTest : AuthenticationExtensionsClientInputsTest() {
    @Test
    override fun testSerialize_givenNone_thenReturnEmptyMap() =
        runJsonTest("AuthenticationExtensionsClientInputs-none.json") {
            val actual = JsonUtil.json.encodeToString(none)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppid_thenReturnMapWithAppid() =
        runJsonTest("AuthenticationExtensionsClientInputs-appid.json") {
            val actual = JsonUtil.json.encodeToString(appid)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAppidExclude_thenReturnMapWithAppidExclude() =
        runJsonTest("AuthenticationExtensionsClientInputs-appidExclude.json") {
            val actual = JsonUtil.json.encodeToString(appidExclude)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUvm_thenReturnMapWithUvm() =
        runJsonTest("AuthenticationExtensionsClientInputs-uvm.json") {
            val actual = JsonUtil.json.encodeToString(uvm)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenCredProps_thenReturnMapWithCredProps() =
        runJsonTest("AuthenticationExtensionsClientInputs-credProps.json") {
            val actual = JsonUtil.json.encodeToString(credProps)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenLargeBlob_thenReturnMapWithLargeBlob() =
        runJsonTest("AuthenticationExtensionsClientInputs-largeBlob.json") {
            val actual = JsonUtil.json.encodeToString(largeBlob)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUndefined_thenReturnUndefined() =
        runJsonTest("AuthenticationExtensionsClientInputs-undefined.json") {
            val actual = JsonUtil.json.encodeToString(undefined)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenEmptyMap_thenReturnNone() =
        runJsonTest("AuthenticationExtensionsClientInputs-none.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientInputs>(it)
            assertThat(actual).isEqualTo(none)
        }

    @Test
    override fun testDeserialize_givenMapWithAppid_thenReturnAppid() =
        runJsonTest("AuthenticationExtensionsClientInputs-appid.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientInputs>(it)
            assertThat(actual).isEqualTo(appid)
        }

    @Test
    override fun testDeserialize_givenMapWithAppidExclude_thenReturnAppidExclude() =
        runJsonTest("AuthenticationExtensionsClientInputs-appidExclude.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientInputs>(it)
            assertThat(actual).isEqualTo(appidExclude)
        }

    @Test
    override fun testDeserialize_givenMapWithUvm_thenReturnUvm() =
        runJsonTest("AuthenticationExtensionsClientInputs-uvm.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientInputs>(it)
            assertThat(actual).isEqualTo(uvm)
        }

    @Test
    override fun testDeserialize_givenMapWithCredProps_thenReturnCredProps() =
        runJsonTest("AuthenticationExtensionsClientInputs-credProps.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientInputs>(it)
            assertThat(actual).isEqualTo(credProps)
        }

    @Test
    override fun testDeserialize_givenMapWithLargeBlob_thenReturnLargeBlob() =
        runJsonTest("AuthenticationExtensionsClientInputs-largeBlob.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientInputs>(it)
            assertThat(actual).isEqualTo(largeBlob)
        }

    @Test
    override fun testDeserialize_givenUndefined_thenReturnUndefined() =
        runJsonTest("AuthenticationExtensionsClientInputs-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsClientInputs>(it)
            assertThat(actual).isEqualTo(undefined)
        }
}
