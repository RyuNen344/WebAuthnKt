package io.github.ryunen344.webauthn2.json.core

import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import io.github.ryunen344.webauthn2.json.core.partial.appid
import io.github.ryunen344.webauthn2.json.core.partial.appidExclude
import io.github.ryunen344.webauthn2.json.core.partial.credProps
import io.github.ryunen344.webauthn2.json.core.partial.largeBlob
import io.github.ryunen344.webauthn2.json.core.partial.uvm
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class AuthenticationExtensionsClientInputsTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(AuthenticationExtensionsClientInputs::class.java).verify()
    }

    @Test
    fun testExtension_givenFilledMap_thenReturnValue() {
        assertThat(full.appid).isEqualTo(DOMString("AuthenticationExtensionsClientInputs-appid"))
        assertThat(full.appidExclude).isEqualTo(DOMString("AuthenticationExtensionsClientInputs-appidExclude"))
        assertThat(full.uvm).isEqualTo(true)
        assertThat(full.credProps).isEqualTo(true)
        assertThat(full.largeBlob).isEqualTo(AuthenticationExtensionsLargeBlobInputs(null, null, null))
    }

    @Test
    fun testExtension_givenEmptyMap_thenReturnNullValue() {
        assertThat(none.appid).isNull()
        assertThat(none.appidExclude).isNull()
        assertThat(none.uvm).isNull()
        assertThat(none.credProps).isNull()
        assertThat(none.largeBlob).isNull()
    }

    abstract fun testSerialize_givenNone_thenReturnEmptyMap()
    abstract fun testSerialize_givenAppid_thenReturnMapWithAppid()
    abstract fun testSerialize_givenAppidExclude_thenReturnMapWithAppidExclude()
    abstract fun testSerialize_givenUvm_thenReturnMapWithUvm()
    abstract fun testSerialize_givenCredProps_thenReturnMapWithCredProps()
    abstract fun testSerialize_givenLargeBlob_thenReturnMapWithLargeBlob()
    abstract fun testSerialize_givenUndefined_thenReturnUndefined()
    abstract fun testDeserialize_givenEmptyMap_thenReturnNone()
    abstract fun testDeserialize_givenMapWithAppid_thenReturnAppid()
    abstract fun testDeserialize_givenMapWithAppidExclude_thenReturnAppidExclude()
    abstract fun testDeserialize_givenMapWithUvm_thenReturnUvm()
    abstract fun testDeserialize_givenMapWithCredProps_thenReturnCredProps()
    abstract fun testDeserialize_givenMapWithLargeBlob_thenReturnLargeBlob()
    abstract fun testDeserialize_givenUndefined_thenReturnUndefined()

    companion object {
        val full =
            AuthenticationExtensionsClientInputs(
                mapOf(
                    "appid" to DOMString("AuthenticationExtensionsClientInputs-appid"),
                    "appidExclude" to DOMString("AuthenticationExtensionsClientInputs-appidExclude"),
                    "uvm" to true,
                    "credProps" to true,
                    "largeBlob" to AuthenticationExtensionsLargeBlobInputs(null, null, null)
                )
            )

        val none = AuthenticationExtensionsClientInputs(emptyMap())

        val appid =
            AuthenticationExtensionsClientInputs(mapOf("appid" to DOMString("AuthenticationExtensionsClientInputs-appid")))

        val appidExclude =
            AuthenticationExtensionsClientInputs(mapOf("appidExclude" to DOMString("AuthenticationExtensionsClientInputs-appidExclude")))

        val uvm =
            AuthenticationExtensionsClientInputs(mapOf("uvm" to true))

        val credProps =
            AuthenticationExtensionsClientInputs(mapOf("credProps" to true))

        val largeBlob =
            AuthenticationExtensionsClientInputs(
                mapOf("largeBlob" to AuthenticationExtensionsLargeBlobInputs(null, null, null))
            )

        val undefined =
            AuthenticationExtensionsClientInputs(
                mapOf(
                    "boolean" to true,
                    "number" to 1,
                    "string" to "string",
                    "array" to listOf(1, 2, 3),
                    "object" to mapOf("key" to "value")
                )
            )
    }
}
