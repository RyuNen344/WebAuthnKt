package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialParameters
import io.github.ryunen344.webauthn2.json.core.PublicKeyCredentialParametersTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiPublicKeyCredentialParametersTest : PublicKeyCredentialParametersTest() {
    @Test
    override fun testSerialize_givenValue_thenSerialize() =
        runJsonTest("PublicKeyCredentialParameters-value.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialParameters::class)
            val actual = adapter.toJson(value)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenValue_thenDeserialize() =
        runJsonTest("PublicKeyCredentialParameters-value.json") {
            val adapter = MoshiUtil.adapter(PublicKeyCredentialParameters::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(value)
        }
}
