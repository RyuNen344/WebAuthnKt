package io.github.ryunen344.webauthn2.json.core.enum

abstract class ResidentKeyRequirementTest {
    abstract fun testSerialize_givenDiscouraged_thenValueIsDiscouraged()
    abstract fun testSerialize_givenPreferred_thenValueIsPreferred()
    abstract fun testSerialize_givenRequired_thenValueIsRequired()
    abstract fun testSerialize_givenUnknown_thenValueIsUnknown()
    abstract fun testDeserialize_givenDiscouragedJsonString_thenValueIsDiscouraged()
    abstract fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred()
    abstract fun testDeserialize_givenRequiredJsonString_thenValueIsRequired()
    abstract fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown()
    abstract fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown()
}
