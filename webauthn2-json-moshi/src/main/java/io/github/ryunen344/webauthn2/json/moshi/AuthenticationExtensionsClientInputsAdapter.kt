package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.internal.Util.NO_ANNOTATIONS
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobInputs
import io.github.ryunen344.webauthn2.json.core.DOMString
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
import java.lang.reflect.Type

class AuthenticationExtensionsClientInputsAdapter(moshi: Moshi) :
    JsonAdapter<AuthenticationExtensionsClientInputs>() {
    private val options: JsonReader.Options =
        JsonReader.Options.of(*AuthenticationExtensionsClientInputs.reserved.toTypedArray())

    private val nullableAppidAdapter: JsonAdapter<DOMString?> =
        moshi.adapter(DOMString::class.java, NO_ANNOTATIONS, AuthenticationExtensionsClientInputs.reserved[0])

    private val nullableAppidExcludeAdapter: JsonAdapter<DOMString?> =
        moshi.adapter(DOMString::class.java, NO_ANNOTATIONS, AuthenticationExtensionsClientInputs.reserved[1])

    private val nullableUvmAdapter: JsonAdapter<Boolean?> =
        moshi.adapter(Boolean::class.java, NO_ANNOTATIONS, AuthenticationExtensionsClientInputs.reserved[2])

    private val nullableCredPropsAdapter: JsonAdapter<Boolean?> =
        moshi.adapter(Boolean::class.javaObjectType, NO_ANNOTATIONS, AuthenticationExtensionsClientInputs.reserved[3])

    private val nullableLargeBlobAdapter: JsonAdapter<AuthenticationExtensionsLargeBlobInputs?> =
        moshi.adapter(
            AuthenticationExtensionsLargeBlobInputs::class.java,
            NO_ANNOTATIONS,
            AuthenticationExtensionsClientInputs.reserved[4]
        )

    private val jsonKeyAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, NO_ANNOTATIONS, null)

    private val jsonValueAdapter: JsonAdapter<Any?> =
        moshi.adapter(Types.subtypeOf(Object::class.java), NO_ANNOTATIONS, null)

    override fun fromJson(reader: JsonReader): AuthenticationExtensionsClientInputs {
        val result = mutableMapOf<String, Any>()
        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> nullableAppidAdapter.fromJson(reader)
                    ?.let { result.put(AuthenticationExtensionsClientInputs.reserved[0], it) }

                1 -> nullableAppidExcludeAdapter.fromJson(reader)
                    ?.let { result.put(AuthenticationExtensionsClientInputs.reserved[1], it) }

                2 -> nullableUvmAdapter.fromJson(reader)
                    ?.let { result.put(AuthenticationExtensionsClientInputs.reserved[2], it) }

                3 -> nullableCredPropsAdapter.fromJson(reader)
                    ?.let { result.put(AuthenticationExtensionsClientInputs.reserved[3], it) }

                4 -> nullableLargeBlobAdapter.fromJson(reader)
                    ?.let { result.put(AuthenticationExtensionsClientInputs.reserved[4], it) }

                -1 -> {
                    reader.promoteNameToValue()
                    val name =
                        jsonKeyAdapter.fromJson(reader) ?: throw JsonDataException("Map key is null at ${reader.path}")
                    jsonValueAdapter.fromJson(reader)?.let { value ->
                        val replaced = result.put(name, value)
                        if (replaced != null) {
                            throw JsonDataException(
                                "Map key '$name' has multiple values at path ${reader.path}: $replaced and $value",
                            )
                        }
                    }
                }
            }
        }
        reader.endObject()

        return AuthenticationExtensionsClientInputs(result)
    }

    override fun toJson(writer: JsonWriter, value: AuthenticationExtensionsClientInputs?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        value.value[AuthenticationExtensionsClientInputs.reserved[0]]?.let { appid ->
            writer.name(AuthenticationExtensionsClientInputs.reserved[0])
            if (appid is DOMString) {
                nullableAppidAdapter.toJson(writer, appid)
            } else {
                throw JsonDataException("appid is not DOMString")
            }
        }
        value.value[AuthenticationExtensionsClientInputs.reserved[1]]?.let { appidExclude ->
            writer.name(AuthenticationExtensionsClientInputs.reserved[1])
            if (appidExclude is DOMString) {
                nullableAppidExcludeAdapter.toJson(writer, appidExclude)
            } else {
                throw JsonDataException("appidExclude is not DOMString")
            }
        }
        value.value[AuthenticationExtensionsClientInputs.reserved[2]]?.let { uvm ->
            writer.name(AuthenticationExtensionsClientInputs.reserved[2])
            if (uvm is Boolean) {
                nullableUvmAdapter.toJson(writer, uvm)
            } else {
                throw JsonDataException("uvm is not Boolean")
            }
        }
        value.value[AuthenticationExtensionsClientInputs.reserved[3]]?.let { credProps ->
            writer.name(AuthenticationExtensionsClientInputs.reserved[3])
            if (credProps is Boolean) {
                nullableCredPropsAdapter.toJson(writer, credProps)
            } else {
                throw JsonDataException("credProps is not Boolean")
            }
        }
        value.value[AuthenticationExtensionsClientInputs.reserved[4]]?.let { largeBlob ->
            writer.name(AuthenticationExtensionsClientInputs.reserved[4])
            if (largeBlob is AuthenticationExtensionsLargeBlobInputs) {
                nullableLargeBlobAdapter.toJson(writer, largeBlob)
            } else {
                throw JsonDataException("largeBlob is not AuthenticationExtensionsLargeBlobInputs")
            }
        }
        value.value.filter { it.key !in AuthenticationExtensionsClientInputs.reserved }.forEach { (k, v) ->
            writer.promoteValueToName()
            jsonKeyAdapter.toJson(writer, k)
            jsonValueAdapter.toJson(writer, v)
        }
        writer.endObject()
    }

    class Factory : JsonAdapter.Factory {
        override fun create(type: Type, annotations: Set<Annotation>, moshi: Moshi): JsonAdapter<*>? {
            if (annotations.isNotEmpty()) return null
            if (type != AuthenticationExtensionsClientInputs::class.java) return null
            return AuthenticationExtensionsClientInputsAdapter(moshi).nullSafe()
        }
    }
}
