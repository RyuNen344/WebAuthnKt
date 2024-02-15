package io.github.ryunen344.webauthn2.json.serialization

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.longOrNull

internal val JsonElement.extractedContent: Any?
    get() {
        return when (this) {
            is JsonNull -> null
            is JsonPrimitive -> {
                if (isString) {
                    content
                } else {
                    booleanOrNull ?: intOrNull ?: longOrNull ?: floatOrNull ?: doubleOrNull ?: content
                }
            }

            is JsonArray -> mapNotNull { it.extractedContent }
            is JsonObject -> entries.associate { it.key to it.value.extractedContent }.filterNot { it.value == null }
            else -> null
        }
    }

internal val Any?.jsonElement: JsonElement
    get() {
        return when (this) {
            is Number -> JsonPrimitive(this)
            is Boolean -> JsonPrimitive(this)
            is String -> JsonPrimitive(this)
            is ByteArray -> toJsonArray()
            is CharArray -> toJsonArray()
            is ShortArray -> toJsonArray()
            is IntArray -> toJsonArray()
            is LongArray -> toJsonArray()
            is FloatArray -> toJsonArray()
            is DoubleArray -> toJsonArray()
            is BooleanArray -> toJsonArray()
            is Map<*, *> -> toJsonObject()
            is Array<*> -> toJsonArray()
            is Iterable<*> -> toJsonArray()
            is JsonElement -> this
            else -> JsonNull
        }
    }

private fun ByteArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it) })
    }
}

private fun CharArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it.toString()) })
    }
}

private fun ShortArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it) })
    }
}

private fun IntArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it) })
    }
}

private fun LongArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it) })
    }
}

private fun FloatArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it) })
    }
}

private fun DoubleArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it) })
    }
}

private fun BooleanArray.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { JsonPrimitive(it) })
    }
}

private fun Map<*, *>.toJsonObject(): JsonObject {
    return buildJsonObject {
        forEach { (k, v) -> put(k.toString(), v.jsonElement) }
    }
}

private fun Array<*>.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { it.jsonElement })
    }
}

private fun Iterable<*>.toJsonArray(): JsonArray {
    return buildJsonArray {
        addAll(map { it.jsonElement })
    }
}
