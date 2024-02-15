package io.github.ryunen344.webauthn2.json.serialization

import kotlinx.serialization.json.Json

object JsonUtil {
    val json by lazy {
        Json {
            explicitNulls = false
            encodeDefaults = true
        }
    }
}
