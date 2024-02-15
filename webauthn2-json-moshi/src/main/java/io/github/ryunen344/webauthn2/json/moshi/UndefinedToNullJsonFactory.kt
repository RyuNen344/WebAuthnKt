package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.rawType
import io.github.ryunen344.webauthn2.json.moshi.annotation.UndefinedToNull
import java.lang.reflect.Modifier
import java.lang.reflect.Type

/**
 * [JsonAdapter.Factory] class that deserialize undefined values to null in JSON if present [UndefinedToNull] annotation
 */
class UndefinedToNullJsonFactory : JsonAdapter.Factory {
    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        if (!type.rawType.isAnnotationPresent(UndefinedToNull::class.java)) return null
        val delegate = moshi.nextAdapter<Any?>(this, type, annotations)
        return object : JsonAdapter<Any?>() {
            override fun fromJson(reader: JsonReader): Any? {
                return if (reader.peek() != JsonReader.Token.BEGIN_OBJECT) {
                    delegate.fromJson(reader)
                } else {
                    val rawBlob = reader.readJsonValue()
                    runCatching {
                        @Suppress("UNCHECKED_CAST")
                        val blob = rawBlob as Map<String, Any?>
                        val fields = type.rawType.declaredFields
                            .filter { !Modifier.isStatic(it.modifiers) }
                            .associate { (it.getAnnotation(Json::class.java)?.name ?: it.name) to null }
                            .toMutableMap<String, Any?>()
                            .apply { putAll(blob) }
                        delegate.fromJsonValue(fields)
                    }.getOrElse {
                        when (it) {
                            is JsonDataException,
                            is JsonEncodingException -> throw it

                            else -> delegate.fromJsonValue(rawBlob)
                        }
                    }
                }
            }

            override fun toJson(writer: JsonWriter, value: Any?) {
                delegate.toJson(writer, value)
            }
        }
    }
}
