package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.COSEAlgorithmIdentifier

class COSEAlgorithmIdentifierAdapter {
    @ToJson
    fun toJson(value: COSEAlgorithmIdentifier): Int {
        return value.value
    }

    @FromJson
    fun fromJson(value: Int): COSEAlgorithmIdentifier {
        return COSEAlgorithmIdentifier(value)
    }
}
