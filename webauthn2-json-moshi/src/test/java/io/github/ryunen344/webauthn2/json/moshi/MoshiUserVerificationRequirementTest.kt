package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirementTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiUserVerificationRequirementTest : UserVerificationRequirementTest() {
    @Test
    override fun testSerialize_givenRequired_thenValueIsRequired() =
        runJsonTest("UserVerificationRequirement-required.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val serialized = adapter.toJson(UserVerificationRequirement.Required)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPreferred_thenValueIsPreferred() =
        runJsonTest("UserVerificationRequirement-preferred.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val serialized = adapter.toJson(UserVerificationRequirement.Preferred)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenDiscouraged_thenValueIsDiscouraged() =
        runJsonTest("UserVerificationRequirement-discouraged.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val serialized = adapter.toJson(UserVerificationRequirement.Discouraged)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("UserVerificationRequirement-unknown.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val serialized = adapter.toJson(UserVerificationRequirement.Unknown)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenRequiredJsonString_thenValueIsRequired() =
        runJsonTest("UserVerificationRequirement-required.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(UserVerificationRequirement.Required)
        }

    @Test
    override fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred() =
        runJsonTest("UserVerificationRequirement-preferred.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(UserVerificationRequirement.Preferred)
        }

    @Test
    override fun testDeserialize_givenDiscouragedJsonString_thenValueIsDiscouraged() =
        runJsonTest("UserVerificationRequirement-discouraged.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(UserVerificationRequirement.Discouraged)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("UserVerificationRequirement-undefined.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(UserVerificationRequirement.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("UserVerificationRequirement-unknown.json") {
            val adapter = MoshiUtil.adapter(UserVerificationRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(UserVerificationRequirement.Unknown)
        }
}
