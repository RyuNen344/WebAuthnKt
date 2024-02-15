package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialType
import io.github.ryunen344.webauthn2.json.core.enum.PublicKeyCredentialTypeTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxPublicKeyCredentialTypeTest : PublicKeyCredentialTypeTest() {
    @Test
    override fun testSerialize_givenPublicKey_thenValueIsPublicKey() =
        runJsonTest("PublicKeyCredentialType-public-key.json") {
            val actual = JsonUtil.json.encodeToString(PublicKeyCredentialType.PublicKey)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("PublicKeyCredentialType-unknown.json") {
            val actual = JsonUtil.json.encodeToString(PublicKeyCredentialType.Unknown)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenPublicKeyJsonString_thenValueIsPublicKey() =
        runJsonTest("PublicKeyCredentialType-public-key.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialType>(it)
            assertThat(actual).isEqualTo(PublicKeyCredentialType.PublicKey)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("PublicKeyCredentialType-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialType>(it)
            assertThat(actual).isEqualTo(PublicKeyCredentialType.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("PublicKeyCredentialType-unknown.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialType>(it)
            assertThat(actual).isEqualTo(PublicKeyCredentialType.Unknown)
        }
}
