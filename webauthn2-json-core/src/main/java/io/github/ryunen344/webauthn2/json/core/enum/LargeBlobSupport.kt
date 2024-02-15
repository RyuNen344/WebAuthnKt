package io.github.ryunen344.webauthn2.json.core.enum

import com.squareup.moshi.JsonClass
import io.github.ryunen344.webauthn2.json.serialization.LargeBlobSupportSerializer
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#enumdef-largeblobsupport
 */
@Serializable(with = LargeBlobSupportSerializer::class)
@JsonClass(generateAdapter = false)
enum class LargeBlobSupport(val value: String) {
    Required("required"),
    Preferred("preferred"),
}
