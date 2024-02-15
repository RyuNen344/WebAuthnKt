package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.internal.Util
import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobOutputs
import io.github.ryunen344.webauthn2.json.core.CredentialPropertiesOutput
import io.github.ryunen344.webauthn2.json.core.UvmEntries
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
import java.lang.reflect.Type

class AuthenticationExtensionsClientOutputsAdapter(moshi: Moshi) :
    JsonAdapter<AuthenticationExtensionsClientOutputs>() {
    private val options: JsonReader.Options =
        JsonReader.Options.of(*AuthenticationExtensionsClientOutputs.reserved.toTypedArray())

    private val nullableAppidAdapter: JsonAdapter<Boolean?> =
        moshi.adapter(
            Boolean::class.javaObjectType,
            Util.NO_ANNOTATIONS,
            AuthenticationExtensionsClientOutputs.reserved[0]
        )

    private val nullableAppidExcludeAdapter: JsonAdapter<Boolean?> =
        moshi.adapter(
            Boolean::class.javaObjectType,
            Util.NO_ANNOTATIONS,
            AuthenticationExtensionsClientOutputs.reserved[1]
        )

    private val nullableUvmEntriesAdapter: JsonAdapter<UvmEntries?> =
        moshi.adapter(UvmEntries::class.java, Util.NO_ANNOTATIONS, AuthenticationExtensionsClientOutputs.reserved[2])

    private val nullableCredPropsAdapter: JsonAdapter<CredentialPropertiesOutput?> =
        moshi.adapter(
            CredentialPropertiesOutput::class.java,
            Util.NO_ANNOTATIONS,
            AuthenticationExtensionsClientOutputs.reserved[3]
        )

    private val nullableLargeBlobAdapter: JsonAdapter<AuthenticationExtensionsLargeBlobOutputs?> =
        moshi.adapter(
            AuthenticationExtensionsLargeBlobOutputs::class.java,
            Util.NO_ANNOTATIONS,
            AuthenticationExtensionsClientOutputs.reserved[4]
        )

    private val jsonKeyAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, Util.NO_ANNOTATIONS, null)

    private val jsonValueAdapter: JsonAdapter<Any?> =
        moshi.adapter(Types.subtypeOf(Object::class.java), Util.NO_ANNOTATIONS, null)

    override fun fromJson(reader: JsonReader): AuthenticationExtensionsClientOutputs {
        return AuthenticationExtensionsClientOutputs(
            buildMap {
                reader.beginObject()
                while (reader.hasNext()) {
                    when (reader.selectName(options)) {
                        0 -> nullableAppidAdapter.fromJson(reader)
                            ?.let { put(AuthenticationExtensionsClientOutputs.reserved[0], it) }

                        1 -> nullableAppidExcludeAdapter.fromJson(reader)
                            ?.let { put(AuthenticationExtensionsClientOutputs.reserved[1], it) }

                        2 -> nullableUvmEntriesAdapter.fromJson(reader)
                            ?.let { put(AuthenticationExtensionsClientOutputs.reserved[2], it) }

                        3 -> nullableCredPropsAdapter.fromJson(reader)
                            ?.let { put(AuthenticationExtensionsClientOutputs.reserved[3], it) }

                        4 -> nullableLargeBlobAdapter.fromJson(reader)
                            ?.let { put(AuthenticationExtensionsClientOutputs.reserved[4], it) }

                        -1 -> {
                            reader.promoteNameToValue()
                            val name =
                                jsonKeyAdapter.fromJson(reader)
                                    ?: throw JsonDataException("Map key is null at ${reader.path}")
                            jsonValueAdapter.fromJson(reader)?.let { value ->
                                val replaced = put(name, value)
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
            }
        )
    }

    override fun toJson(writer: JsonWriter, value: AuthenticationExtensionsClientOutputs?) {
        if (value == null) {
            throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
        }
        writer.beginObject()
        value.value[AuthenticationExtensionsClientOutputs.reserved[0]]?.let { appid ->
            writer.name(AuthenticationExtensionsClientOutputs.reserved[0])
            if (appid is Boolean) {
                nullableAppidAdapter.toJson(writer, appid)
            } else {
                throw JsonDataException("appid is not Boolean")
            }
        }
        value.value[AuthenticationExtensionsClientOutputs.reserved[1]]?.let { appidExclude ->
            writer.name(AuthenticationExtensionsClientOutputs.reserved[1])
            if (appidExclude is Boolean) {
                nullableAppidExcludeAdapter.toJson(writer, appidExclude)
            } else {
                throw JsonDataException("appidExclude is not Boolean")
            }
        }
        value.value[AuthenticationExtensionsClientOutputs.reserved[2]]?.let { uvm ->
            writer.name(AuthenticationExtensionsClientOutputs.reserved[2])
            if (uvm is UvmEntries) {
                nullableUvmEntriesAdapter.toJson(writer, uvm)
            } else {
                throw JsonDataException("uvm is not UvmEntries")
            }
        }
        value.value[AuthenticationExtensionsClientOutputs.reserved[3]]?.let { credProps ->
            writer.name(AuthenticationExtensionsClientOutputs.reserved[3])
            if (credProps is CredentialPropertiesOutput) {
                nullableCredPropsAdapter.toJson(writer, credProps)
            } else {
                throw JsonDataException("credProps is not CredentialPropertiesOutput")
            }
        }
        value.value[AuthenticationExtensionsClientOutputs.reserved[4]]?.let { largeBlob ->
            writer.name(AuthenticationExtensionsClientOutputs.reserved[4])
            if (largeBlob is AuthenticationExtensionsLargeBlobOutputs) {
                nullableLargeBlobAdapter.toJson(writer, largeBlob)
            } else {
                throw JsonDataException("largeBlob is not AuthenticationExtensionsLargeBlobInputs")
            }
        }
        value.value.filter { it.key !in AuthenticationExtensionsClientOutputs.reserved }.forEach { (k, v) ->
            writer.promoteValueToName()
            jsonKeyAdapter.toJson(writer, k)
            jsonValueAdapter.toJson(writer, v)
        }
        writer.endObject()
    }

    class Factory : JsonAdapter.Factory {
        override fun create(type: Type, annotations: Set<Annotation>, moshi: Moshi): JsonAdapter<*>? {
            if (annotations.isNotEmpty()) return null
            if (type != AuthenticationExtensionsClientOutputs::class.java) return null
            return AuthenticationExtensionsClientOutputsAdapter(moshi).nullSafe()
        }
    }
}
