package io.github.ryunen344.webauthn2.json.core.enum

abstract class LargeBlobSupportTest {
    abstract fun testSerialize_givenRequired_thenValueIsRequired()
    abstract fun testSerialize_givenPreferred_thenValueIsPreferred()
    abstract fun testDeserialize_givenRequiredJsonString_thenValueIsRequired()
    abstract fun testDeserialize_givenPreferredJsonString_thenValueIsPreferred()
}
