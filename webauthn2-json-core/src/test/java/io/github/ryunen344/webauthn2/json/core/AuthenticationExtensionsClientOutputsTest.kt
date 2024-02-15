package io.github.ryunen344.webauthn2.json.core

import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
import io.github.ryunen344.webauthn2.json.core.partial.appid
import io.github.ryunen344.webauthn2.json.core.partial.appidExclude
import io.github.ryunen344.webauthn2.json.core.partial.credProps
import io.github.ryunen344.webauthn2.json.core.partial.largeBlob
import io.github.ryunen344.webauthn2.json.core.partial.uvm
import nl.jqno.equalsverifier.EqualsVerifier
import org.junit.Test

abstract class AuthenticationExtensionsClientOutputsTest {
    @Test
    fun testEquals() {
        EqualsVerifier.forClass(AuthenticationExtensionsClientOutputs::class.java).verify()
    }

    @Test
    fun testExtension_givenFilledMap_thenReturnValue() {
        assertThat(full.appid).isEqualTo(true)
        assertThat(full.appidExclude).isEqualTo(false)
        assertThat(full.uvm).isEqualTo(
            UvmEntries(
                listOf(
                    UvmEntry(listOf(1u, 2u)),
                    UvmEntry(listOf(3u, 4u)),
                )
            )
        )
        assertThat(full.credProps).isEqualTo(
            CredentialPropertiesOutput(
                rk = true,
            )
        )
        assertThat(full.largeBlob)
            .isEqualTo(AuthenticationExtensionsLargeBlobOutputs(true, null, null))
    }

    @Test
    fun testExtension_givenEmptyMap_thenReturnNullValue() {
        assertThat(none.appid).isNull()
        assertThat(none.appidExclude).isNull()
        assertThat(none.uvm).isNull()
        assertThat(none.credProps).isNull()
        assertThat(none.largeBlob).isNull()
    }

    abstract fun testSerialize_givenNone_thenSuccess()
    abstract fun testSerialize_givenAppid_thenSuccess()
    abstract fun testSerialize_givenAppidExclude_thenSuccess()
    abstract fun testSerialize_givenUvm_thenSuccess()
    abstract fun testSerialize_givenCredProps_thenSuccess()
    abstract fun testSerialize_givenLargeBlob_thenSuccess()
    abstract fun testSerialize_givenUndefined_thenSuccess()
    abstract fun testDeserialize_givenNone_thenSuccess()
    abstract fun testDeserialize_givenAppid_thenSuccess()
    abstract fun testDeserialize_givenAppidExclude_thenSuccess()
    abstract fun testDeserialize_givenUvm_thenSuccess()
    abstract fun testDeserialize_givenCredProps_thenSuccess()
    abstract fun testDeserialize_givenLargeBlob_thenSuccess()
    abstract fun testDeserialize_givenUndefined_thenSuccess()

    companion object {
        val full =
            AuthenticationExtensionsClientOutputs(
                mapOf(
                    "appid" to true,
                    "appidExclude" to false,
                    "uvm" to UvmEntries(
                        listOf(
                            UvmEntry(listOf(1u, 2u)),
                            UvmEntry(listOf(3u, 4u)),
                        )
                    ),
                    "credProps" to CredentialPropertiesOutput(
                        rk = true,
                    ),
                    "largeBlob" to AuthenticationExtensionsLargeBlobOutputs(true, null, null)
                )
            )

        val none = AuthenticationExtensionsClientOutputs(emptyMap())

        val appid =
            AuthenticationExtensionsClientOutputs(mapOf("appid" to true))

        val appidExclude =
            AuthenticationExtensionsClientOutputs(mapOf("appidExclude" to false))

        val uvm =
            AuthenticationExtensionsClientOutputs(
                mapOf(
                    "uvm" to UvmEntries(
                        listOf(
                            UvmEntry(listOf(1u, 2u)),
                            UvmEntry(listOf(3u, 4u)),
                        )
                    )
                )
            )

        val credProps =
            AuthenticationExtensionsClientOutputs(
                mapOf(
                    "credProps" to CredentialPropertiesOutput(
                        rk = true,
                    )
                )
            )

        val largeBlob =
            AuthenticationExtensionsClientOutputs(
                mapOf("largeBlob" to AuthenticationExtensionsLargeBlobOutputs(false, null, null))
            )

        val undefined =
            AuthenticationExtensionsClientOutputs(
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
