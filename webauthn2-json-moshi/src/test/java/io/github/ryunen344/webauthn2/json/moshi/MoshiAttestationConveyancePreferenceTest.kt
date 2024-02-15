package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreference
import io.github.ryunen344.webauthn2.json.core.enum.AttestationConveyancePreferenceTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAttestationConveyancePreferenceTest : AttestationConveyancePreferenceTest() {

    @Test
    override fun testSerialize_givenNone_thenValueIsNone() = runJsonTest("AttestationConveyancePreference-none.json") {
        val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
        val serialized = adapter.toJson(AttestationConveyancePreference.None)
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenIndirect_thenValueIsIndirect() =
        runJsonTest("AttestationConveyancePreference-indirect.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val serialized = adapter.toJson(AttestationConveyancePreference.Indirect)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenDirect_thenValueIsDirect() =
        runJsonTest("AttestationConveyancePreference-direct.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val serialized = adapter.toJson(AttestationConveyancePreference.Direct)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEnterprise_thenValueIsEnterprise() =
        runJsonTest("AttestationConveyancePreference-enterprise.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val serialized = adapter.toJson(AttestationConveyancePreference.Enterprise)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("AttestationConveyancePreference-unknown.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val serialized = adapter.toJson(AttestationConveyancePreference.Unknown)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenNoneJsonString_thenValueIsNone() =
        runJsonTest("AttestationConveyancePreference-none.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val preference = adapter.fromJson(it)
            assertThat(preference).isEqualTo(AttestationConveyancePreference.None)
        }

    @Test
    override fun testDeserialize_givenIndirectJsonString_thenValueIsIndirect() =
        runJsonTest("AttestationConveyancePreference-indirect.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val preference = adapter.fromJson(it)
            assertThat(preference).isEqualTo(AttestationConveyancePreference.Indirect)
        }

    @Test
    override fun testDeserialize_givenDirectJsonString_thenValueIsDirect() =
        runJsonTest("AttestationConveyancePreference-direct.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val preference = adapter.fromJson(it)
            assertThat(preference).isEqualTo(AttestationConveyancePreference.Direct)
        }

    @Test
    override fun testDeserialize_givenEnterpriseJsonString_thenValueIsEnterprise() =
        runJsonTest("AttestationConveyancePreference-enterprise.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val preference = adapter.fromJson(it)
            assertThat(preference).isEqualTo(AttestationConveyancePreference.Enterprise)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("AttestationConveyancePreference-undefined.json") {
            val adapter = MoshiUtil.adapter(AttestationConveyancePreference::class)
            val preference = adapter.fromJson(it)
            assertThat(preference).isEqualTo(AttestationConveyancePreference.Unknown)
        }
}
