package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.UvmEntry

class UvmEntryAdapter {
    @ToJson
    fun toJson(writer: JsonWriter, value: UvmEntry, delegate: JsonAdapter<List<ULong>>) {
        delegate.toJson(writer, value.value)
    }

    @FromJson
    fun fromJson(reader: JsonReader, delegate: JsonAdapter<List<ULong>>): UvmEntry? {
        return delegate.fromJson(reader)?.let(::UvmEntry)
    }
}
