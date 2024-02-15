package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatus
import io.github.ryunen344.webauthn2.json.core.enum.TokenBindingStatusTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiTokenBindingStatusTest : TokenBindingStatusTest() {
    @Test
    override fun testSerialize_givenPresent_thenValueIsPresent() =
        runJsonTest("TokenBindingStatus-present.json") {
            val adapter = MoshiUtil.adapter(TokenBindingStatus::class)
            val serialized = adapter.toJson(TokenBindingStatus.Present)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenSupported_thenValueIsSupported() =
        runJsonTest("TokenBindingStatus-supported.json") {
            val adapter = MoshiUtil.adapter(TokenBindingStatus::class)
            val serialized = adapter.toJson(TokenBindingStatus.Supported)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("TokenBindingStatus-unknown.json") {
            val adapter = MoshiUtil.adapter(TokenBindingStatus::class)
            val serialized = adapter.toJson(TokenBindingStatus.Unknown)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenPresentJsonString_thenValueIsPresent() =
        runJsonTest("TokenBindingStatus-present.json") {
            val adapter = MoshiUtil.adapter(TokenBindingStatus::class)
            val status = adapter.fromJson(it)
            assertThat(status).isEqualTo(TokenBindingStatus.Present)
        }

    @Test
    override fun testDeserialize_givenSupportedJsonString_thenValueIsSupported() =
        runJsonTest("TokenBindingStatus-supported.json") {
            val adapter = MoshiUtil.adapter(TokenBindingStatus::class)
            val status = adapter.fromJson(it)
            assertThat(status).isEqualTo(TokenBindingStatus.Supported)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("TokenBindingStatus-undefined.json") {
            val adapter = MoshiUtil.adapter(TokenBindingStatus::class)
            val status = adapter.fromJson(it)
            assertThat(status).isEqualTo(TokenBindingStatus.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("TokenBindingStatus-unknown.json") {
            val adapter = MoshiUtil.adapter(TokenBindingStatus::class)
            val status = adapter.fromJson(it)
            assertThat(status).isEqualTo(TokenBindingStatus.Unknown)
        }
}
