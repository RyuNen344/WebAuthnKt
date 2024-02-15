package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.COSEAlgorithmIdentifierSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-alg-identifier
 * https://www.iana.org/assignments/cose/cose.xhtml#algorithms
 */
@Serializable(with = COSEAlgorithmIdentifierSerializer::class)
@JsonClass(generateAdapter = false)
class COSEAlgorithmIdentifier(val value: Int) {

    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other is COSEAlgorithmIdentifier -> other.value == value
            else -> false
        }
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        val ES256 = COSEAlgorithmIdentifier(-7)
        val ES384 = COSEAlgorithmIdentifier(-35)
        val ES512 = COSEAlgorithmIdentifier(-36)
        val EdDSA = COSEAlgorithmIdentifier(-8)
        val RS256 = COSEAlgorithmIdentifier(-257)
        val RS384 = COSEAlgorithmIdentifier(-258)
        val RS512 = COSEAlgorithmIdentifier(-259)
    }
}
