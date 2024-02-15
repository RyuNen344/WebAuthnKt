package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatus
import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatusTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxTokenBindingStatusTest : TokenBindingStatusTest() {
    @Test
    override fun testSerialize_givenPresent_thenValueIsPresent() =
        runJsonTest("TokenBindingStatus-present.json") {
            val actual = JsonUtil.json.encodeToString(TokenBindingStatus.Present)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenSupported_thenValueIsSupported() =
        runJsonTest("TokenBindingStatus-supported.json") {
            val actual = JsonUtil.json.encodeToString(TokenBindingStatus.Supported)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("TokenBindingStatus-unknown.json") {
            val actual = JsonUtil.json.encodeToString(TokenBindingStatus.Unknown)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenPresentJsonString_thenValueIsPresent() =
        runJsonTest("TokenBindingStatus-present.json") {
            val actual = JsonUtil.json.decodeFromString<TokenBindingStatus>(it)
            assertThat(actual).isEqualTo(TokenBindingStatus.Present)
        }

    @Test
    override fun testDeserialize_givenSupportedJsonString_thenValueIsSupported() =
        runJsonTest("TokenBindingStatus-supported.json") {
            val actual = JsonUtil.json.decodeFromString<TokenBindingStatus>(it)
            assertThat(actual).isEqualTo(TokenBindingStatus.Supported)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("TokenBindingStatus-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<TokenBindingStatus>(it)
            assertThat(actual).isEqualTo(TokenBindingStatus.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("TokenBindingStatus-unknown.json") {
            val actual = JsonUtil.json.decodeFromString<TokenBindingStatus>(it)
            assertThat(actual).isEqualTo(TokenBindingStatus.Unknown)
        }
}
