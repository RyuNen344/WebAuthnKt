package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAssertionResponse
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAssertionResponseTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticatorAssertionResponseTest : AuthenticatorAssertionResponseTest() {

    @Test
    override fun testSerialize_givenHandler_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-handle.json") {
            val actual = JsonUtil.json.encodeToString(handle)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEmptyHandler_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-empty-handle.json") {
            val actual = JsonUtil.json.encodeToString(emptyHandle)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenHandlerJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-handle.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAssertionResponse>(it)
            assertThat(actual).isEqualTo(handle)
        }

    @Test
    override fun testDeserialize_givenEmptyHandlerJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-empty-handle.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAssertionResponse>(it)
            assertThat(actual).isEqualTo(emptyHandle)
        }
}
