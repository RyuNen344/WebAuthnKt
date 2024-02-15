package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.CollectedClientData
import io.github.ryunen344.webauthn2.json.core.CollectedClientDataTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiCollectedClientDataTest : CollectedClientDataTest() {

    @Test
    override fun testSerialize_givenMinimum_thenSuccess() =
        runJsonTest("CollectedClientData-minimum.json") {
            val adapter = MoshiUtil.adapter(CollectedClientData::class)
            val serialized = adapter.toJson(minimum)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenCrossOrigin_thenSuccess() =
        runJsonTest("CollectedClientData-cross-origin.json") {
            val adapter = MoshiUtil.adapter(CollectedClientData::class)
            val serialized = adapter.toJson(crossOrigin)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenToken_thenSuccess() =
        runJsonTest("CollectedClientData-token.json") {
            val adapter = MoshiUtil.adapter(CollectedClientData::class)
            val serialized = adapter.toJson(token)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenMinimum_thenSuccess() =
        runJsonTest("CollectedClientData-minimum.json") {
            val adapter = MoshiUtil.adapter(CollectedClientData::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenCrossOrigin_thenSuccess() =
        runJsonTest("CollectedClientData-cross-origin.json") {
            val adapter = MoshiUtil.adapter(CollectedClientData::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(crossOrigin)
        }

    @Test
    override fun testDeserialize_givenToken_thenSuccess() =
        runJsonTest("CollectedClientData-token.json") {
            val adapter = MoshiUtil.adapter(CollectedClientData::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(token)
        }
}
