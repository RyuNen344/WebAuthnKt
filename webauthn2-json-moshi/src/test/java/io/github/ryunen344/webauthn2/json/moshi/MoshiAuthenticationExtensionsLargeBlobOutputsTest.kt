package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobOutputs
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobOutputsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticationExtensionsLargeBlobOutputsTest : AuthenticationExtensionsLargeBlobOutputsTest() {
    @Test
    override fun testSerialize_givenRegistrationSupported_thenValueIsRegistrationSupported() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-registration-supported.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobOutputs::class)
            val serialized = adapter.toJson(registrationSupported)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationRead_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-read.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobOutputs::class)
            val serialized = adapter.toJson(authenticationRead)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationWrite_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-write.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobOutputs::class)
            val serialized = adapter.toJson(authenticationWrite)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRegistrationSupportedJsonString_thenValueIsRegistrationSupported() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-registration-supported.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobOutputs::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(registrationSupported)
        }

    @Test
    override fun testDeserialize_givenAuthenticationReadJsonString_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-read.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobOutputs::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(authenticationRead)
        }

    @Test
    override fun testDeserialize_givenAuthenticationWriteJsonString_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-write.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobOutputs::class)
            val deserialized = adapter.fromJson(it)
            assertThat(deserialized).isEqualTo(authenticationWrite)
        }
}
