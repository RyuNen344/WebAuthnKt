package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobInputs
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobInputsTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticationExtensionsLargeBlobInputsTest : AuthenticationExtensionsLargeBlobInputsTest() {
    @Test
    override fun testSerialize_givenRegistrationRequired_thenValueIsRegistrationRequired() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-required.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val serialized = adapter.toJson(registrationRequired)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRegistrationPreferred_thenValueIsRegistrationPreferred() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-preferred.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val serialized = adapter.toJson(registrationPreferred)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationRead_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-read.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val serialized = adapter.toJson(authenticationRead)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenAuthenticationWrite_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-write.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val serialized = adapter.toJson(authenticationWrite)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRegistrationRequiredJsonString_thenValueIsRegistrationRequired() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-required.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val inputs = adapter.fromJson(it)
            assertThat(inputs).isEqualTo(registrationRequired)
        }

    @Test
    override fun testDeserialize_givenRegistrationPreferredJsonString_thenValueIsRegistrationPreferred() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-registration-preferred.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val inputs = adapter.fromJson(it)
            assertThat(inputs).isEqualTo(registrationPreferred)
        }

    @Test
    override fun testDeserialize_givenAuthenticationReadJsonString_thenValueIsAuthenticationRead() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-read.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val inputs = adapter.fromJson(it)
            assertThat(inputs).isEqualTo(authenticationRead)
        }

    @Test
    override fun testDeserialize_givenAuthenticationWriteJsonString_thenValueIsAuthenticationWrite() =
        runJsonTest("AuthenticationExtensionsLargeBlobInputs-authentication-write.json") {
            val adapter = MoshiUtil.adapter(AuthenticationExtensionsLargeBlobInputs::class)
            val inputs = adapter.fromJson(it)
            assertThat(inputs).isEqualTo(authenticationWrite)
        }
}
