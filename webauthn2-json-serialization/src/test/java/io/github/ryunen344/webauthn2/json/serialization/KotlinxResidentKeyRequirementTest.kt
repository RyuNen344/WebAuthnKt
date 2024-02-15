package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirement
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirementTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxResidentKeyRequirementTest : ResidentKeyRequirementTest() {
    @Test
    override fun testSerialize_givenDiscouraged_thenValueIsDiscouraged() =
        runJsonTest("ResidentKeyRequirement-discouraged.json") {
            val actual = JsonUtil.json.encodeToString(ResidentKeyRequirement.Discouraged)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenPreferred_thenValueIsPreferred() =
        runJsonTest("ResidentKeyRequirement-preferred.json") {
            val actual = JsonUtil.json.encodeToString(ResidentKeyRequirement.Preferred)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRequired_thenValueIsRequired() =
        runJsonTest("ResidentKeyRequirement-required.json") {
            val actual = JsonUtil.json.encodeToString(ResidentKeyRequirement.Required)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("ResidentKeyRequirement-unknown.json") {
            val actual = JsonUtil.json.encodeToString(ResidentKeyRequirement.Unknown)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenDiscouragedJsonString_thenValueIsDiscouraged() =
        runJsonTest("ResidentKeyRequirement-discouraged.json") {
            val actual = JsonUtil.json.decodeFromString<ResidentKeyRequirement>(it)
            assertThat(actual).isEqualTo(ResidentKeyRequirement.Discouraged)
        }

    @Test
    override fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred() =
        runJsonTest("ResidentKeyRequirement-preferred.json") {
            val actual = JsonUtil.json.decodeFromString<ResidentKeyRequirement>(it)
            assertThat(actual).isEqualTo(ResidentKeyRequirement.Preferred)
        }

    @Test
    override fun testDeserialize_givenRequiredJsonString_thenValueIsRequired() =
        runJsonTest("ResidentKeyRequirement-required.json") {
            val actual = JsonUtil.json.decodeFromString<ResidentKeyRequirement>(it)
            assertThat(actual).isEqualTo(ResidentKeyRequirement.Required)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("ResidentKeyRequirement-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<ResidentKeyRequirement>(it)
            assertThat(actual).isEqualTo(ResidentKeyRequirement.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("ResidentKeyRequirement-unknown.json") {
            val actual = JsonUtil.json.decodeFromString<ResidentKeyRequirement>(it)
            assertThat(actual).isEqualTo(ResidentKeyRequirement.Unknown)
        }
}
