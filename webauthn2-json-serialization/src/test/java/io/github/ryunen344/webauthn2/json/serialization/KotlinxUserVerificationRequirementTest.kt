package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirementTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxUserVerificationRequirementTest : UserVerificationRequirementTest() {
    @Test
    override fun testSerialize_givenRequired_thenValueIsRequired() =
        runJsonTest("UserVerificationRequirement-required.json") {
            val actual = JsonUtil.json.encodeToString(UserVerificationRequirement.Required)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPreferred_thenValueIsPreferred() =
        runJsonTest("UserVerificationRequirement-preferred.json") {
            val actual = JsonUtil.json.encodeToString(UserVerificationRequirement.Preferred)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenDiscouraged_thenValueIsDiscouraged() =
        runJsonTest("UserVerificationRequirement-discouraged.json") {
            val actual = JsonUtil.json.encodeToString(UserVerificationRequirement.Discouraged)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("UserVerificationRequirement-unknown.json") {
            val actual = JsonUtil.json.encodeToString(UserVerificationRequirement.Unknown)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRequiredJsonString_thenValueIsRequired() =
        runJsonTest("UserVerificationRequirement-required.json") {
            val actual = JsonUtil.json.decodeFromString<UserVerificationRequirement>(it)
            assertThat(actual).isEqualTo(UserVerificationRequirement.Required)
        }

    @Test
    override fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred() =
        runJsonTest("UserVerificationRequirement-preferred.json") {
            val actual = JsonUtil.json.decodeFromString<UserVerificationRequirement>(it)
            assertThat(actual).isEqualTo(UserVerificationRequirement.Preferred)
        }

    @Test
    override fun testDeserialize_givenDiscouragedJsonString_thenValueIsDiscouraged() =
        runJsonTest("UserVerificationRequirement-discouraged.json") {
            val actual = JsonUtil.json.decodeFromString<UserVerificationRequirement>(it)
            assertThat(actual).isEqualTo(UserVerificationRequirement.Discouraged)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("UserVerificationRequirement-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<UserVerificationRequirement>(it)
            assertThat(actual).isEqualTo(UserVerificationRequirement.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("UserVerificationRequirement-unknown.json") {
            val actual = JsonUtil.json.decodeFromString<UserVerificationRequirement>(it)
            assertThat(actual).isEqualTo(UserVerificationRequirement.Unknown)
        }
}
