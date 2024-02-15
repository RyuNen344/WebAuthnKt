package io.github.ryunen344.webauthn2.json.core.enum

abstract class AttestationConveyancePreferenceTest {
    abstract fun testSerialize_givenNone_thenValueIsNone()
    abstract fun testSerialize_givenIndirect_thenValueIsIndirect()
    abstract fun testSerialize_givenDirect_thenValueIsDirect()
    abstract fun testSerialize_givenEnterprise_thenValueIsEnterprise()
    abstract fun testSerialize_givenUnknown_thenValueIsUnknown()
    abstract fun testDeserialize_givenNoneJsonString_thenValueIsNone()
    abstract fun testDeserialize_givenIndirectJsonString_thenValueIsIndirect()
    abstract fun testDeserialize_givenDirectJsonString_thenValueIsDirect()
    abstract fun testDeserialize_givenEnterpriseJsonString_thenValueIsEnterprise()
    abstract fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown()
}
