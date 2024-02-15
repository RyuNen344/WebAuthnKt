package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import io.github.ryunen344.webauthn2.json.core.UvmEntries
import io.github.ryunen344.webauthn2.json.core.UvmEntry

class UvmEntriesAdapter {
    @ToJson
    fun toJson(writer: JsonWriter, value: UvmEntries, delegate: JsonAdapter<List<UvmEntry>>) {
        delegate.toJson(writer, value.value)
    }

    @FromJson
    fun fromJson(reader: JsonReader, delegate: JsonAdapter<List<UvmEntry>>): UvmEntries? {
        return delegate.fromJson(reader)?.let(::UvmEntries)
    }
}
