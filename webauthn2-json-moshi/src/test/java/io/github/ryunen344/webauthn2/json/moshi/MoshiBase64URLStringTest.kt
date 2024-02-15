package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.Base64URLString
import io.github.ryunen344.webauthn2.json.core.Base64URLStringTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiBase64URLStringTest : Base64URLStringTest() {
    @Test
    override fun testSerialize_givenEmptyString_thenEmptyString() = runJsonTest("Base64URLString-empty.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val serialized = adapter.toJson(Base64URLString("".encodeToByteArray()))
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenZero_thenNumber() = runJsonTest("Base64URLString-zero.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val serialized = adapter.toJson(Base64URLString("0".encodeToByteArray()))
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenAlphabet_thenUrlSafeAlphabet() = runJsonTest("Base64URLString-alphabet.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val serialized =
            adapter.toJson(Base64URLString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".encodeToByteArray()))
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenJwks_thenJwks() = runJsonTest("Base64URLString-jwks.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val serialized =
            adapter.toJson(Base64URLString("{\"keys\":[{\"kty\":\"oct\",\"alg\":\"A128KW\",\"k\":\"GawgguFyGrWKav7AX4VKUg\"},{\"kty\":\"oct\",\"k\":\"AyM1SysPpbyDfgZld3umj1qzKObwVMkoqQ-EstJQLr_T-1qS0gZH75aKtMN3Yj0iPS4hcgUuTwjAzZr1Z9CAow\",\"kid\":\"HMAC key used in JWS spec Appendix A.1 example\"}]}".encodeToByteArray()))
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testSerialize_givenJwt_thenJwt() = runJsonTest("Base64URLString-jwt.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val serialized =
            adapter.toJson(Base64URLString("{\"alg\":\"HS256\",\"typ\":\"JWT\"}".encodeToByteArray()))
        assertJson(serialized).isEquivalentTo(it)
    }

    @Test
    override fun testDeserialize_givenEmptyString_thenEmptyString() = runJsonTest("Base64URLString-empty.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val deserialized = adapter.fromJson(it)
        assertThat(deserialized).isEqualTo(Base64URLString("".encodeToByteArray()))
    }

    @Test
    override fun testDeserialize_givenZero_thenNumber() = runJsonTest("Base64URLString-zero.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val deserialized = adapter.fromJson(it)
        assertThat(deserialized).isEqualTo(Base64URLString("0".encodeToByteArray()))
    }

    @Test
    override fun testDeserialize_givenAlphabet_thenAlphabet() = runJsonTest("Base64URLString-alphabet.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val deserialized = adapter.fromJson(it)
        assertThat(deserialized).isEqualTo(Base64URLString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".encodeToByteArray()))
    }

    @Test
    override fun testDeserialize_givenJwks_thenJwks() = runJsonTest("Base64URLString-jwks.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val deserialized = adapter.fromJson(it)
        assertThat(deserialized).isEqualTo(Base64URLString("{\"keys\":[{\"kty\":\"oct\",\"alg\":\"A128KW\",\"k\":\"GawgguFyGrWKav7AX4VKUg\"},{\"kty\":\"oct\",\"k\":\"AyM1SysPpbyDfgZld3umj1qzKObwVMkoqQ-EstJQLr_T-1qS0gZH75aKtMN3Yj0iPS4hcgUuTwjAzZr1Z9CAow\",\"kid\":\"HMAC key used in JWS spec Appendix A.1 example\"}]}".encodeToByteArray()))
    }

    @Test
    override fun testDeserialize_givenJwt_thenJwt() = runJsonTest("Base64URLString-jwt.json") {
        val adapter = MoshiUtil.adapter(Base64URLString::class)
        val deserialized = adapter.fromJson(it)
        assertThat(deserialized).isEqualTo(Base64URLString("{\"alg\":\"HS256\",\"typ\":\"JWT\"}".encodeToByteArray()))
    }
}
