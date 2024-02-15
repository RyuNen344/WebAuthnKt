package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.UvmEntriesSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#typedefdef-uvmentries
 */
@Serializable(with = UvmEntriesSerializer::class)
@JsonClass(generateAdapter = false)
class UvmEntries(val value: List<UvmEntry>) {

    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other is UvmEntries -> value == other.value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
