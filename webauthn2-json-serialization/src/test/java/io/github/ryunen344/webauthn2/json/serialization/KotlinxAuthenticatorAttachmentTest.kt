package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachment
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachmentTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticatorAttachmentTest : AuthenticatorAttachmentTest() {

    @Test
    override fun testSerialize_givenCrossPlatform_thenValueIsCrossPlatform() =
        runJsonTest("AuthenticatorAttachment-cross-platform.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorAttachment.CrossPlatform)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPlatform_thenValueIsPlatform() =
        runJsonTest("AuthenticatorAttachment-platform.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorAttachment.Platform)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("AuthenticatorAttachment-unknown.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorAttachment.Unknown)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenCrossPlatformJsonString_thenValueIsCrossPlatform() =
        runJsonTest("AuthenticatorAttachment-cross-platform.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttachment>(it)
            assertThat(actual).isEqualTo(AuthenticatorAttachment.CrossPlatform)
        }

    @Test
    override fun testDeserialize_givenPlatformJsonString_thenValueIsPlatform() =
        runJsonTest("AuthenticatorAttachment-platform.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttachment>(it)
            assertThat(actual).isEqualTo(AuthenticatorAttachment.Platform)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorAttachment-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttachment>(it)
            assertThat(actual).isEqualTo(AuthenticatorAttachment.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorAttachment-unknown.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorAttachment>(it)
            assertThat(actual).isEqualTo(AuthenticatorAttachment.Unknown)
        }
}
