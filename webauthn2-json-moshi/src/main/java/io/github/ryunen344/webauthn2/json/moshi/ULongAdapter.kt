package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class ULongAdapter : JsonAdapter<ULong>() {
    override fun toJson(writer: JsonWriter, value: ULong?) {
        writer.value(requireNotNull(value).toLong())
    }

    override fun fromJson(reader: JsonReader): ULong {
        return reader.nextLong().toULong()
    }
}
