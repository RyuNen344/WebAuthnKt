package io.github.ryunen344.webauthn2.json.core.enum

abstract class PublicKeyCredentialTypeTest {
    abstract fun testSerialize_givenPublicKey_thenValueIsPublicKey()
    abstract fun testSerialize_givenUnknown_thenValueIsUnknown()
    abstract fun testDeserialize_givenPublicKeyJsonString_thenValueIsPublicKey()
    abstract fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown()
    abstract fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown()
}
