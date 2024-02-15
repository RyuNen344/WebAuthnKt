package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.TokenBinding
import io.github.ryunen344.webauthn2.json.core.TokenBindingTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxTokenBindingTest : TokenBindingTest() {
    @Test
    override fun testSerialize_givenId_thenSuccess() =
        runJsonTest("TokenBinding-id.json") {
            val actual = JsonUtil.json.encodeToString(id)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenNullId_thenSuccess() =
        runJsonTest("TokenBinding-null.json") {
            val actual = JsonUtil.json.encodeToString(nullId)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenId_thenSuccess() =
        runJsonTest("TokenBinding-id.json") {
            val actual = JsonUtil.json.decodeFromString<TokenBinding>(it)
            assertThat(actual).isEqualTo(id)
        }

    @Test
    override fun testDeserialize_givenNullId_thenSuccess() =
        runJsonTest("TokenBinding-null.json") {
            val actual = JsonUtil.json.decodeFromString<TokenBinding>(it)
            assertThat(actual).isEqualTo(nullId)
        }
}
