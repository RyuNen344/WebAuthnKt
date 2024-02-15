package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.CredentialPropertiesOutput
import io.github.ryunen344.webauthn2.json.core.CredentialPropertiesOutputTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxCredentialPropertiesOutputTest : CredentialPropertiesOutputTest() {
    @Test
    override fun testSerialize_givenNull_thenSerializeToUndefined() =
        runJsonTest("CredentialPropertiesOutput-undefined.json") {
            val actual = JsonUtil.json.encodeToString(CredentialPropertiesOutput(null))
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRKTrue_thenSerializeToTrue() =
        runJsonTest("CredentialPropertiesOutput-true.json") {
            val actual = JsonUtil.json.encodeToString(CredentialPropertiesOutput(true))
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRKFalse_thenSerializeToFalse() =
        runJsonTest("CredentialPropertiesOutput-false.json") {
            val actual = JsonUtil.json.encodeToString(CredentialPropertiesOutput(false))
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenUndefined_thenDeserializeToNull() =
        runJsonTest("CredentialPropertiesOutput-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<CredentialPropertiesOutput>(it)
            assertThat(actual).isEqualTo(CredentialPropertiesOutput(null))
        }

    @Test
    override fun testDeserialize_givenTrue_thenDeserializeToRKTrue() =
        runJsonTest("CredentialPropertiesOutput-true.json") {
            val actual = JsonUtil.json.decodeFromString<CredentialPropertiesOutput>(it)
            assertThat(actual).isEqualTo(CredentialPropertiesOutput(true))
        }

    @Test
    override fun testDeserialize_givenFalse_thenDeserializeToRKFalse() =
        runJsonTest("CredentialPropertiesOutput-false.json") {
            val actual = JsonUtil.json.decodeFromString<CredentialPropertiesOutput>(it)
            assertThat(actual).isEqualTo(CredentialPropertiesOutput(false))
        }
}
