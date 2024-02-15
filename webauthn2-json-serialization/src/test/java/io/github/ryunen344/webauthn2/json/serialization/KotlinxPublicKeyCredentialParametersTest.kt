package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialParameters
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialParametersTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxPublicKeyCredentialParametersTest : PublicKeyCredentialParametersTest() {
    @Test
    override fun testSerialize_givenValue_thenSerialize() =
        runJsonTest("PublicKeyCredentialParameters-value.json") {
            val actual = JsonUtil.json.encodeToString(value)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenValue_thenDeserialize() =
        runJsonTest("PublicKeyCredentialParameters-value.json") {
            val actual = JsonUtil.json.decodeFromString<PublicKeyCredentialParameters>(it)
            assertThat(actual).isEqualTo(value)
        }
}
