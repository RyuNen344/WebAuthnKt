package io.github.ryunen344.webauthn2.json.core

import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class Base64URLStringTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(Base64URLString::class.java).verify()
    }

    abstract fun testSerialize_givenEmptyString_thenEmptyString()
    abstract fun testSerialize_givenZero_thenNumber()
    abstract fun testSerialize_givenAlphabet_thenUrlSafeAlphabet()
    abstract fun testSerialize_givenJwks_thenJwks()
    abstract fun testSerialize_givenJwt_thenJwt()
    abstract fun testDeserialize_givenEmptyString_thenEmptyString()
    abstract fun testDeserialize_givenZero_thenNumber()
    abstract fun testDeserialize_givenAlphabet_thenAlphabet()
    abstract fun testDeserialize_givenJwks_thenJwks()
    abstract fun testDeserialize_givenJwt_thenJwt()

    companion object {
        val empty = Base64URLString("".encodeToByteArray())

        val zero = Base64URLString("0".encodeToByteArray())

        val alphabet =
            Base64URLString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".encodeToByteArray())

        val jwks =
            Base64URLString("{\"keys\":[{\"kty\":\"oct\",\"alg\":\"A128KW\",\"k\":\"GawgguFyGrWKav7AX4VKUg\"},{\"kty\":\"oct\",\"k\":\"AyM1SysPpbyDfgZld3umj1qzKObwVMkoqQ-EstJQLr_T-1qS0gZH75aKtMN3Yj0iPS4hcgUuTwjAzZr1Z9CAow\",\"kid\":\"HMAC key used in JWS spec Appendix A.1 example\"}]}".encodeToByteArray())

        val jwt = Base64URLString("{\"alg\":\"HS256\",\"typ\":\"JWT\"}".encodeToByteArray())
    }
}
