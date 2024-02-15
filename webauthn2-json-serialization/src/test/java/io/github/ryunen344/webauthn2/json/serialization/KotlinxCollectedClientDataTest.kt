package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.CollectedClientData
import io.github.ryunen344.webauthn2.json.core.CollectedClientDataTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxCollectedClientDataTest : CollectedClientDataTest() {

    @Test
    override fun testSerialize_givenMinimum_thenSuccess() =
        runJsonTest("CollectedClientData-minimum.json") {
            val actual = JsonUtil.json.encodeToString(minimum)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenCrossOrigin_thenSuccess() =
        runJsonTest("CollectedClientData-cross-origin.json") {
            val actual = JsonUtil.json.encodeToString(crossOrigin)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenToken_thenSuccess() =
        runJsonTest("CollectedClientData-token.json") {
            val actual = JsonUtil.json.encodeToString(token)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenMinimum_thenSuccess() =
        runJsonTest("CollectedClientData-minimum.json") {
            val actual = JsonUtil.json.decodeFromString<CollectedClientData>(it)
            assertThat(actual).isEqualTo(minimum)
        }

    @Test
    override fun testDeserialize_givenCrossOrigin_thenSuccess() =
        runJsonTest("CollectedClientData-cross-origin.json") {
            val actual = JsonUtil.json.decodeFromString<CollectedClientData>(it)
            assertThat(actual).isEqualTo(crossOrigin)
        }

    @Test
    override fun testDeserialize_givenToken_thenSuccess() =
        runJsonTest("CollectedClientData-token.json") {
            val actual = JsonUtil.json.decodeFromString<CollectedClientData>(it)
            assertThat(actual).isEqualTo(token)
        }
}
