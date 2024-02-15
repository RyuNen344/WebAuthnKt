package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachment
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorAttachmentTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticatorAttachmentTest : AuthenticatorAttachmentTest() {

    @Test
    override fun testSerialize_givenCrossPlatform_thenValueIsCrossPlatform() =
        runJsonTest("AuthenticatorAttachment-cross-platform.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttachment::class)
            val serialized = adapter.toJson(AuthenticatorAttachment.CrossPlatform)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPlatform_thenValueIsPlatform() =
        runJsonTest("AuthenticatorAttachment-platform.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttachment::class)
            val serialized = adapter.toJson(AuthenticatorAttachment.Platform)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() = runJsonTest("AuthenticatorAttachment-unknown.json") {
        val adapter = MoshiUtil.adapter(AuthenticatorAttachment::class)
        val serialized = adapter.toJson(AuthenticatorAttachment.Unknown)
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testDeserialize_givenCrossPlatformJsonString_thenValueIsCrossPlatform() =
        runJsonTest("AuthenticatorAttachment-cross-platform.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttachment::class)
            val attachment = adapter.fromJson(it)
            assertThat(attachment).isEqualTo(AuthenticatorAttachment.CrossPlatform)
        }

    @Test
    override fun testDeserialize_givenPlatformJsonString_thenValueIsPlatform() =
        runJsonTest("AuthenticatorAttachment-platform.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttachment::class)
            val attachment = adapter.fromJson(it)
            assertThat(attachment).isEqualTo(AuthenticatorAttachment.Platform)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorAttachment-undefined.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttachment::class)
            val attachment = adapter.fromJson(it)
            assertThat(attachment).isEqualTo(AuthenticatorAttachment.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorAttachment-unknown.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorAttachment::class)
            val attachment = adapter.fromJson(it)
            assertThat(attachment).isEqualTo(AuthenticatorAttachment.Unknown)
        }
}
