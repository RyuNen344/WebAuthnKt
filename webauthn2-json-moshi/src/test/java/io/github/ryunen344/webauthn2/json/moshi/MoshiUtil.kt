package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlin.reflect.KClass

object MoshiUtil {
    private val moshi by lazy {
        Moshi.Builder()
            .apply(WebAuthnAdapterHelper()::setup)
            .build()
    }

    fun <T : Any> adapter(clazz: KClass<T>): JsonAdapter<T> {
        return moshi.adapter(clazz.java)
    }
}
