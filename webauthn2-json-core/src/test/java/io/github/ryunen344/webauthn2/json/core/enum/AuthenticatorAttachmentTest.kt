package io.github.ryunen344.webauthn2.json.core.enum

abstract class AuthenticatorAttachmentTest {
    abstract fun testSerialize_givenCrossPlatform_thenValueIsCrossPlatform()
    abstract fun testSerialize_givenPlatform_thenValueIsPlatform()
    abstract fun testSerialize_givenUnknown_thenValueIsUnknown()
    abstract fun testDeserialize_givenCrossPlatformJsonString_thenValueIsCrossPlatform()
    abstract fun testDeserialize_givenPlatformJsonString_thenValueIsPlatform()
    abstract fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown()
    abstract fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown()
}
