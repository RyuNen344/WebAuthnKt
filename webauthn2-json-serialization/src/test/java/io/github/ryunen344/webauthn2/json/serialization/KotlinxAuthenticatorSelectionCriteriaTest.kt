package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.AuthenticatorSelectionCriteria
import io.github.ryunen344.webauthn2.json.core.AuthenticatorSelectionCriteriaTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticatorSelectionCriteriaTest : AuthenticatorSelectionCriteriaTest() {

    @Test
    override fun testSerialize_givenNull_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-null.json") {
            val actual = JsonUtil.json.encodeToString(nullValue)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenResidentKey_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-resident-key.json") {
            val actual = JsonUtil.json.encodeToString(residentKey)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRequireResidentKey_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-require-resident-key.json") {
            val actual = JsonUtil.json.encodeToString(requireResidentKey)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUserVerification_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-user-verification.json") {
            val actual = JsonUtil.json.encodeToString(userVerification)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenNullJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-null.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorSelectionCriteria>(it)
            assertThat(actual).isEqualTo(nullValue)
        }

    @Test
    override fun testDeserialize_givenResidentKeyJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-resident-key.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorSelectionCriteria>(it)
            assertThat(actual).isEqualTo(residentKey)
        }

    @Test
    override fun testDeserialize_givenRequireResidentKeyJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-require-resident-key.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorSelectionCriteria>(it)
            assertThat(actual).isEqualTo(requireResidentKey)
        }

    @Test
    override fun testDeserialize_givenUserVerificationJsonString_thenSuccess() =
        runJsonTest("AuthenticatorSelectionCriteria-user-verification.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorSelectionCriteria>(it)
            assertThat(actual).isEqualTo(userVerification)
        }
}
