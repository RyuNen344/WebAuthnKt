package io.github.ryunen344.webauthn2.json.core.enum

abstract class AuthenticatorTransportTest {
    abstract fun testSerialize_givenUsb_thenValueIsUsb()
    abstract fun testSerialize_givenNfc_thenValueIsNfc()
    abstract fun testSerialize_givenBle_thenValueIsBle()
    abstract fun testSerialize_givenInternal_thenValueIsInternal()
    abstract fun testSerialize_givenUnknown_thenValueIsUnknown()
    abstract fun testDeserialize_givenUsbJsonString_thenValueIsUsb()
    abstract fun testDeserialize_givenNfcJsonString_thenValueIsNfc()
    abstract fun testDeserialize_givenBleJsonString_thenValueIsBle()
    abstract fun testDeserialize_givenInternalJsonString_thenValueIsInternal()
    abstract fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown()
    abstract fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown()
}
