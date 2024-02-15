package io.github.ryunen344.webauthn2.json.core

import com.google.common.truth.Truth
import io.github.ryunen344.webauthn2.json.core.enum.ResidentKeyRequirement
import io.github.ryunen344.webauthn2.json.core.enum.UserVerificationRequirement
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class AuthenticatorSelectionCriteriaTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(AuthenticatorSelectionCriteria::class.java).verify()
    }

    @Test
    fun testInitialize_givenAllNull_thenReturnDefaultValues() {
        val value = AuthenticatorSelectionCriteria(authenticatorAttachment = null, residentKey = null)
        Truth.assertThat(value.requireResidentKey).isFalse()
        Truth.assertThat(value.userVerification).isEqualTo(UserVerificationRequirement.Preferred)
    }

    @Test
    fun testInitialize_givenRequireResidentKeyIsNull_thenReturnDefaultValues() {
        val value = AuthenticatorSelectionCriteria(
            authenticatorAttachment = null,
            residentKey = null,
            requireResidentKey = null
        )
        Truth.assertThat(value.requireResidentKey).isNull()
        Truth.assertThat(value.userVerification).isEqualTo(UserVerificationRequirement.Preferred)
    }

    @Test
    fun testInitialize_givenUserVerificationIsNull_thenReturnDefaultValues() {
        val value = AuthenticatorSelectionCriteria(
            authenticatorAttachment = null,
            residentKey = null,
            userVerification = null
        )
        Truth.assertThat(value.requireResidentKey).isFalse()
        Truth.assertThat(value.userVerification).isNull()
    }

    abstract fun testSerialize_givenNull_thenSuccess()
    abstract fun testSerialize_givenResidentKey_thenSuccess()
    abstract fun testSerialize_givenRequireResidentKey_thenSuccess()
    abstract fun testSerialize_givenUserVerification_thenSuccess()
    abstract fun testDeserialize_givenNullJsonString_thenSuccess()
    abstract fun testDeserialize_givenResidentKeyJsonString_thenSuccess()
    abstract fun testDeserialize_givenRequireResidentKeyJsonString_thenSuccess()
    abstract fun testDeserialize_givenUserVerificationJsonString_thenSuccess()

    companion object {
        val nullValue = AuthenticatorSelectionCriteria(
            authenticatorAttachment = null,
            residentKey = null,
            requireResidentKey = null,
            userVerification = null,
        )

        val residentKey = AuthenticatorSelectionCriteria(
            authenticatorAttachment = null,
            residentKey = ResidentKeyRequirement.Required,
            requireResidentKey = null,
            userVerification = null,
        )

        val requireResidentKey = AuthenticatorSelectionCriteria(
            authenticatorAttachment = null,
            residentKey = null,
            requireResidentKey = true,
            userVerification = null,
        )

        val userVerification = AuthenticatorSelectionCriteria(
            authenticatorAttachment = null,
            residentKey = null,
            requireResidentKey = null,
            userVerification = UserVerificationRequirement.Required,
        )
    }
}
