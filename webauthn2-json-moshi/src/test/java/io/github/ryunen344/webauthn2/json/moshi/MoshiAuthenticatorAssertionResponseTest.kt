package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAssertionResponse
import io.github.ryunen344.webauthn2.json.core.AuthenticatorAssertionResponseTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticatorAssertionResponseTest : AuthenticatorAssertionResponseTest() {

    @Test
    override fun testSerialize_givenHandler_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-handle.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAssertionResponse::class)
            val serialized = adapter.toJson(handle)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEmptyHandler_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-empty-handle.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAssertionResponse::class)
            val serialized = adapter.toJson(emptyHandle)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenHandlerJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-handle.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAssertionResponse::class)
            val response = adapter.fromJson(it)
            assertThat(response).isEqualTo(handle)
        }

    @Test
    override fun testDeserialize_givenEmptyHandlerJsonString_thenSuccess() =
        runJsonTest("AuthenticatorAssertionResponse-empty-handle.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAssertionResponse::class)
            val response = adapter.fromJson(it)
            assertThat(response).isEqualTo(emptyHandle)
        }
}
