package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobInputs
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobInputsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticationExtensionsLargeBlobInputsTest : AuthenticationExtensionsLargeBlobInputsTest() {
    @Test
    override fun testSerialize_givenRegistrationRequired_thenValueIsRegistrationRequired() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-required.json") {
            val actual = JsonUtil.json.encodeToString(registrationRequired)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRegistrationPreferred_thenValueIsRegistrationPreferred() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-preferred.json") {
            val actual = JsonUtil.json.encodeToString(registrationPreferred)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationRead_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-read.json") {
            val actual = JsonUtil.json.encodeToString(authenticationRead)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationWrite_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-write.json") {
            val actual = JsonUtil.json.encodeToString(authenticationWrite)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRegistrationRequiredJsonString_thenValueIsRegistrationRequired() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-required.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsLargeBlobInputs>(it)
            assertThat(actual).isEqualTo(registrationRequired)
        }

    @Test
    override fun testDeserialize_givenRegistrationPreferredJsonString_thenValueIsRegistrationPreferred() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-preferred.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsLargeBlobInputs>(it)
            assertThat(actual).isEqualTo(registrationPreferred)
        }

    @Test
    override fun testDeserialize_givenAuthenticationReadJsonString_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-read.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsLargeBlobInputs>(it)
            assertThat(actual).isEqualTo(authenticationRead)
        }

    @Test
    override fun testDeserialize_givenAuthenticationWriteJsonString_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-write.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticationExtensionsLargeBlobInputs>(it)
            assertThat(actual).isEqualTo(authenticationWrite)
        }
}
