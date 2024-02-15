package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialTypeTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiPublicKeyCredentialTypeTest : PublicKeyCredentialTypeTest() {
    @Test
    override fun testSerialize_givenPublicKey_thenValueIsPublicKey() =
        runJsonTest("PublicKeyCredentialType-public-key.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialType::class)
            val serialized = adapter.toJson(PublicKeyCredentialType.PublicKey)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("PublicKeyCredentialType-unknown.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialType::class)
            val serialized = adapter.toJson(PublicKeyCredentialType.Unknown)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenPublicKeyJsonString_thenValueIsPublicKey() =
        runJsonTest("PublicKeyCredentialType-public-key.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialType::class)
            val type = adapter.fromJson(it)
            assertThat(type).isEqualTo(PublicKeyCredentialType.PublicKey)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("PublicKeyCredentialType-undefined.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialType::class)
            val type = adapter.fromJson(it)
            assertThat(type).isEqualTo(PublicKeyCredentialType.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("PublicKeyCredentialType-unknown.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialType::class)
            val type = adapter.fromJson(it)
            assertThat(type).isEqualTo(PublicKeyCredentialType.Unknown)
        }
}
