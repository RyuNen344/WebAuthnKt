package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirement
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirementTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiResidentKeyRequirementTest : ResidentKeyRequirementTest() {
    @Test
    override fun testSerialize_givenDiscouraged_thenValueIsDiscouraged() =
        runJsonTest("ResidentKeyRequirement-discouraged.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val serialized = adapter.toJson(ResidentKeyRequirement.Discouraged)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPreferred_thenValueIsPreferred() =
        runJsonTest("ResidentKeyRequirement-preferred.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val serialized = adapter.toJson(ResidentKeyRequirement.Preferred)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRequired_thenValueIsRequired() =
        runJsonTest("ResidentKeyRequirement-required.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val serialized = adapter.toJson(ResidentKeyRequirement.Required)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("ResidentKeyRequirement-unknown.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val serialized = adapter.toJson(ResidentKeyRequirement.Unknown)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenDiscouragedJsonString_thenValueIsDiscouraged() =
        runJsonTest("ResidentKeyRequirement-discouraged.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(ResidentKeyRequirement.Discouraged)
        }

    @Test
    override fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred() =
        runJsonTest("ResidentKeyRequirement-preferred.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(ResidentKeyRequirement.Preferred)
        }

    @Test
    override fun testDeserialize_givenRequiredJsonString_thenValueIsRequired() =
        runJsonTest("ResidentKeyRequirement-required.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(ResidentKeyRequirement.Required)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("ResidentKeyRequirement-undefined.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(ResidentKeyRequirement.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("ResidentKeyRequirement-unknown.json") {
            val adapter = MoshiUtil.adapter(ResidentKeyRequirement::class)
            val requirement = adapter.fromJson(it)
            assertThat(requirement).isEqualTo(ResidentKeyRequirement.Unknown)
        }
}
