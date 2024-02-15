package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobOutputs
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobOutputsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticationExtensionsLargeBlobOutputsTest : AuthenticationExtensionsLargeBlobOutputsTest() {
    @Test
    override fun testSerialize_givenRegistrationSupported_thenValueIsRegistrationSupported() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-registration-supported.json") {
            val actual = JsonUtil.json.encodeToString(registrationSupported)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationRead_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-read.json") {
            val actual = JsonUtil.json.encodeToString(authenticationRead)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationWrite_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-write.json") {
            val actual = JsonUtil.json.encodeToString(authenticationWrite)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRegistrationSupportedJsonString_thenValueIsRegistrationSupported() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-registration-supported.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsLargeBlobOutputs>(it)
            assertThat(actual).isEqualTo(registrationSupported)
        }

    @Test
    override fun testDeserialize_givenAuthenticationReadJsonString_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-read.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsLargeBlobOutputs>(it)
            assertThat(actual).isEqualTo(authenticationRead)
        }

    @Test
    override fun testDeserialize_givenAuthenticationWriteJsonString_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobOutputs-authentication-write.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsLargeBlobOutputs>(it)
            assertThat(actual).isEqualTo(authenticationWrite)
        }
}
