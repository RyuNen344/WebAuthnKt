package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.CredentialPropertiesOutput
import io.github.ryunen344.webauthn2.json.core.CredentialPropertiesOutputTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiCredentialPropertiesOutputTest : CredentialPropertiesOutputTest() {
    @Test
    override fun testSerialize_givenNull_thenSerializeToUndefined() =
        runJsonTest("CredentialPropertiesOutput-undefined.json") {
            val adapter = MoshiUtil.adapter(CredentialPropertiesOutput::class)
            val actual = adapter.toJson(CredentialPropertiesOutput(null))
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRKTrue_thenSerializeToTrue() =
        runJsonTest("CredentialPropertiesOutput-true.json") {
            val adapter = MoshiUtil.adapter(CredentialPropertiesOutput::class)
            val actual = adapter.toJson(CredentialPropertiesOutput(true))
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRKFalse_thenSerializeToFalse() =
        runJsonTest("CredentialPropertiesOutput-false.json") {
            val adapter = MoshiUtil.adapter(CredentialPropertiesOutput::class)
            val actual = adapter.toJson(CredentialPropertiesOutput(false))
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenUndefined_thenDeserializeToNull() =
        runJsonTest("CredentialPropertiesOutput-undefined.json") {
            val adapter = MoshiUtil.adapter(CredentialPropertiesOutput::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(CredentialPropertiesOutput(null))
        }

    @Test
    override fun testDeserialize_givenTrue_thenDeserializeToRKTrue() =
        runJsonTest("CredentialPropertiesOutput-true.json") {
            val adapter = MoshiUtil.adapter(CredentialPropertiesOutput::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(CredentialPropertiesOutput(true))
        }

    @Test
    override fun testDeserialize_givenFalse_thenDeserializeToRKFalse() =
        runJsonTest("CredentialPropertiesOutput-false.json") {
            val adapter = MoshiUtil.adapter(CredentialPropertiesOutput::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(CredentialPropertiesOutput(false))
        }
}
