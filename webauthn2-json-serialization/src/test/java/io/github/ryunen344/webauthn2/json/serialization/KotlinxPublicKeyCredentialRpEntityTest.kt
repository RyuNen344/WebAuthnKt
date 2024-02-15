package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRpEntity
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialRpEntityTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxPublicKeyCredentialRpEntityTest : PublicKeyCredentialRpEntityTest() {
    @Test
    override fun testSerialize_givenId_thenSuccess() = runJsonTest("PublicKeyCredentialRpEntity-id.json") {
        val actual = JsonUtil.json.encodeToString(id)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenNullId_thenSuccess() = runJsonTest("PublicKeyCredentialRpEntity-empty-id.json") {
        val actual = JsonUtil.json.encodeToString(emptyId)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testDeserialize_givenId_thenSuccess() = runJsonTest("PublicKeyCredentialRpEntity-id.json") {
        val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialRpEntity>(it)
        assertThat(actual).isEqualTo(id)
    }

    @Test
    override fun testDeserialize_givenNullId_thenSuccess() = runJsonTest("PublicKeyCredentialRpEntity-empty-id.json") {
        val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialRpEntity>(it)
        assertThat(actual).isEqualTo(emptyId)
    }
}
