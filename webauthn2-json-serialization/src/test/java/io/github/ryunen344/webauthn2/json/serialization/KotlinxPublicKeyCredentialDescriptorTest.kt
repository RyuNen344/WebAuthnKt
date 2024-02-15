package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialDescriptor
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialDescriptorTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxPublicKeyCredentialDescriptorTest : PublicKeyCredentialDescriptorTest() {
    @Test
    override fun testSerialize_givenTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-transport.json") {
            val actual = JsonUtil.json.encodeToString(transport)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEmptyTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-empty-transport.json") {
            val actual = JsonUtil.json.encodeToString(emptyTransport)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-transport.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialDescriptor>(it)
            assertThat(actual).isEqualTo(transport)
        }

    @Test
    override fun testDeserialize_givenEmptyTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-empty-transport.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialDescriptor>(it)
            assertThat(actual).isEqualTo(emptyTransport)
        }
}
