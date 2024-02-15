package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreference
import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreferenceTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAttestationConveyancePreferenceTest : AttestationConveyancePreferenceTest() {
    @Test
    override fun testSerialize_givenNone_thenValueIsNone() =
        runJsonTest("AttestationConveyancePreference-none.json") {
            val actual = JsonUtil.json.encodeToString(AttestationConveyancePreference.None)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenIndirect_thenValueIsIndirect() =
        runJsonTest("AttestationConveyancePreference-indirect.json") {
            val actual = JsonUtil.json.encodeToString(AttestationConveyancePreference.Indirect)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenDirect_thenValueIsDirect() =
        runJsonTest("AttestationConveyancePreference-direct.json") {
            val actual = JsonUtil.json.encodeToString(AttestationConveyancePreference.Direct)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEnterprise_thenValueIsEnterprise() =
        runJsonTest("AttestationConveyancePreference-enterprise.json") {
            val actual = JsonUtil.json.encodeToString(AttestationConveyancePreference.Enterprise)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("AttestationConveyancePreference-unknown.json") {
            val actual = JsonUtil.json.encodeToString(AttestationConveyancePreference.Unknown)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenNoneJsonString_thenValueIsNone() =
        runJsonTest("AttestationConveyancePreference-none.json") {
            val actual = JsonUtil.json.decodeFromString<AttestationConveyancePreference>(it)
            assertThat(actual).isEqualTo(AttestationConveyancePreference.None)
        }

    @Test
    override fun testDeserialize_givenIndirectJsonString_thenValueIsIndirect() =
        runJsonTest("AttestationConveyancePreference-indirect.json") {
            val actual = JsonUtil.json.decodeFromString<AttestationConveyancePreference>(it)
            assertThat(actual).isEqualTo(AttestationConveyancePreference.Indirect)
        }

    @Test
    override fun testDeserialize_givenDirectJsonString_thenValueIsDirect() =
        runJsonTest("AttestationConveyancePreference-direct.json") {
            val actual = JsonUtil.json.decodeFromString<AttestationConveyancePreference>(it)
            assertThat(actual).isEqualTo(AttestationConveyancePreference.Direct)
        }

    @Test
    override fun testDeserialize_givenEnterpriseJsonString_thenValueIsEnterprise() =
        runJsonTest("AttestationConveyancePreference-enterprise.json") {
            val actual = JsonUtil.json.decodeFromString<AttestationConveyancePreference>(it)
            assertThat(actual).isEqualTo(AttestationConveyancePreference.Enterprise)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("AttestationConveyancePreference-unknown.json") {
            val actual = JsonUtil.json.decodeFromString<AttestationConveyancePreference>(it)
            assertThat(actual).isEqualTo(AttestationConveyancePreference.Unknown)
        }
}
