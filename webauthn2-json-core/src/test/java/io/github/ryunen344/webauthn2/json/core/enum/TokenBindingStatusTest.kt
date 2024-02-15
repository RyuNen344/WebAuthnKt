package io.github.ryunen344.webauthn2.json.core.enum

abstract class TokenBindingStatusTest {
    abstract fun testSerialize_givenPresent_thenValueIsPresent()
    abstract fun testSerialize_givenSupported_thenValueIsSupported()
    abstract fun testSerialize_givenUnknown_thenValueIsUnknown()
    abstract fun testDeserialize_givenPresentJsonString_thenValueIsPresent()
    abstract fun testDeserialize_givenSupportedJsonString_thenValueIsSupported()
    abstract fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown()
    abstract fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown()
}
