package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.LargeBlobSupport
import io.github.ryunen344.webauthn2.json.core.enum.LargeBlobSupportTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiLargeBlobSupportTest : LargeBlobSupportTest() {
    @Test
    override fun testSerialize_givenRequired_thenValueIsRequired() =
        runJsonTest("LargeBlobSupport-required.json") {
            val adapter = MoshiUtil.adapter(LargeBlobSupport::class)
            val serialized = adapter.toJson(LargeBlobSupport.Required)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPreferred_thenValueIsPreferred() =
        runJsonTest("LargeBlobSupport-preferred.json") {
            val adapter = MoshiUtil.adapter(LargeBlobSupport::class)
            val serialized = adapter.toJson(LargeBlobSupport.Preferred)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRequiredJsonString_thenValueIsRequired() =
        runJsonTest("LargeBlobSupport-required.json") {
            val adapter = MoshiUtil.adapter(LargeBlobSupport::class)
            val support = adapter.fromJson(it)
            assertThat(support).isEqualTo(LargeBlobSupport.Required)
        }

    @Test
    override fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred() =
        runJsonTest("LargeBlobSupport-preferred.json") {
            val adapter = MoshiUtil.adapter(LargeBlobSupport::class)
            val support = adapter.fromJson(it)
            assertThat(support).isEqualTo(LargeBlobSupport.Preferred)
        }
}
