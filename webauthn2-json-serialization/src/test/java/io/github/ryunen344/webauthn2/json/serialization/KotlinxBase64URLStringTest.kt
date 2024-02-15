package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.Base64URLString
import io.github.ryunen344.webauthn2.json.core.Base64URLStringTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxBase64URLStringTest : Base64URLStringTest() {
    @Test
    override fun testSerialize_givenEmptyString_thenEmptyString() = runJsonTest("Base64URLString-empty.json") {
        val actual = JsonUtil.json.encodeToString(empty)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenZero_thenNumber() = runJsonTest("Base64URLString-zero.json") {
        val actual = JsonUtil.json.encodeToString(zero)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenAlphabet_thenUrlSafeAlphabet() = runJsonTest("Base64URLString-alphabet.json") {
        val actual = JsonUtil.json.encodeToString(alphabet)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenJwks_thenJwks() = runJsonTest("Base64URLString-jwks.json") {
        val actual = JsonUtil.json.encodeToString(jwks)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenJwt_thenJwt() = runJsonTest("Base64URLString-jwt.json") {
        val actual = JsonUtil.json.encodeToString(jwt)
        assertJson(actual).isEquivalentTo(it)
    }

    @Test
    override fun testDeserialize_givenEmptyString_thenEmptyString() = runJsonTest("Base64URLString-empty.json") {
        val actual = JsonUtil.json.decodeFromString<Base64URLString>(it)
        assertThat(actual).isEqualTo(empty)
    }

    @Test
    override fun testDeserialize_givenZero_thenNumber() = runJsonTest("Base64URLString-zero.json") {
        val actual = JsonUtil.json.decodeFromString<Base64URLString>(it)
        assertThat(actual).isEqualTo(zero)
    }

    @Test
    override fun testDeserialize_givenAlphabet_thenAlphabet() = runJsonTest("Base64URLString-alphabet.json") {
        val actual = JsonUtil.json.decodeFromString<Base64URLString>(it)
        assertThat(actual).isEqualTo(alphabet)
    }

    @Test
    override fun testDeserialize_givenJwks_thenJwks() = runJsonTest("Base64URLString-jwks.json") {
        val actual = JsonUtil.json.decodeFromString<Base64URLString>(it)
        assertThat(actual).isEqualTo(jwks)
    }

    @Test
    override fun testDeserialize_givenJwt_thenJwt() = runJsonTest("Base64URLString-jwt.json") {
        val actual = JsonUtil.json.decodeFromString<Base64URLString>(it)
        assertThat(actual).isEqualTo(jwt)
    }
}
