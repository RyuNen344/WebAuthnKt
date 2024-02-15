package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticatorSelectionCriteria
import io.github.ryunen344.webauthn2.json.core.AuthenticatorSelectionCriteriaTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticatorSelectionCriteriaTest : AuthenticatorSelectionCriteriaTest() {

    @Test
    override fun testSerialize_givenNull_thenSuccess() = runJsonTest("AuthenticatorSelectionCriteria-null.json") {
        val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
        val serialized = adapter.toJson(nullValue)
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenResidentKey_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-resident-key.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
            val serialized = adapter.toJson(residentKey)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRequireResidentKey_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-require-resident-key.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
            val serialized = adapter.toJson(requireResidentKey)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUserVerification_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-user-verification.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
            val serialized = adapter.toJson(userVerification)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenNullJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-null.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
            val criteria = adapter.fromJson(it)
            assertThat(criteria).isEqualTo(nullValue)
        }

    @Test
    override fun testDeserialize_givenResidentKeyJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-resident-key.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
            val criteria = adapter.fromJson(it)
            assertThat(criteria).isEqualTo(residentKey)
        }

    @Test
    override fun testDeserialize_givenRequireResidentKeyJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-require-resident-key.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
            val criteria = adapter.fromJson(it)
            assertThat(criteria).isEqualTo(requireResidentKey)
        }

    @Test
    override fun testDeserialize_givenUserVerificationJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-user-verification.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorSelectionCriteria::class)
            val criteria = adapter.fromJson(it)
            assertThat(criteria).isEqualTo(userVerification)
        }
}
