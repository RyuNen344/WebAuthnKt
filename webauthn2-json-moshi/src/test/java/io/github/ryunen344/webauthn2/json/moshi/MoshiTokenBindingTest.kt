package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.TokenBinding
import io.github.ryunen344.webauthn2.json.core.TokenBindingTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiTokenBindingTest : TokenBindingTest() {
    @Test
    override fun testSerialize_givenId_thenSuccess() =
        runJsonTest("TokenBinding-id.json") {
            val adapter = MoshiUtil.adapter(TokenBinding::class)
            val actual = adapter.toJson(id)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenNullId_thenSuccess() =
        runJsonTest("TokenBinding-null.json") {
            val adapter = MoshiUtil.adapter(TokenBinding::class)
            val actual = adapter.toJson(nullId)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenId_thenSuccess() =
        runJsonTest("TokenBinding-id.json") {
            val adapter = MoshiUtil.adapter(TokenBinding::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(id)
        }

    @Test
    override fun testDeserialize_givenNullId_thenSuccess() =
        runJsonTest("TokenBinding-null.json") {
            val adapter = MoshiUtil.adapter(TokenBinding::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(nullId)
        }
}
