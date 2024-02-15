package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialDescriptor
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialDescriptorTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiPublicKeyCredentialDescriptorTest : PublicKeyCredentialDescriptorTest() {
    @Test
    override fun testSerialize_givenTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-transport.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialDescriptor::class)
            val actual = adapter.toJson(transport)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEmptyTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-empty-transport.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialDescriptor::class)
            val actual = adapter.toJson(emptyTransport)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-transport.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialDescriptor::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(transport)
        }

    @Test
    override fun testDeserialize_givenEmptyTransport_thenSuccess() =
        runJsonTest("PublicKeyCredentialDescriptor-empty-transport.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialDescriptor::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(emptyTransport)
        }
}
