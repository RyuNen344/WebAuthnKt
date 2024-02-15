package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.LargeBlobSupport
import io.github.ryunen344.webauthn2.json.core.enum.LargeBlobSupportTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxLargeBlobSupportTest : LargeBlobSupportTest() {
    @Test
    override fun testSerialize_givenRequired_thenValueIsRequired() =
        runJsonTest("LargeBlobSupport-required.json") {
            val actual = JsonUtil.json.encodeToString(LargeBlobSupport.Required)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPreferred_thenValueIsPreferred() =
        runJsonTest("LargeBlobSupport-preferred.json") {
            val actual = JsonUtil.json.encodeToString(LargeBlobSupport.Preferred)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRequiredJsonString_thenValueIsRequired() =
        runJsonTest("LargeBlobSupport-required.json") {
            val actual = JsonUtil.json.decodeFromString<LargeBlobSupport>(it)
            assertThat(actual).isEqualTo(LargeBlobSupport.Required)
        }

    @Test
    override fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred() =
        runJsonTest("LargeBlobSupport-preferred.json") {
            val actual = JsonUtil.json.decodeFromString<LargeBlobSupport>(it)
            assertThat(actual).isEqualTo(LargeBlobSupport.Preferred)
        }
}
