package io.github.ryunen344.webauthn2.json.core.test.truth

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.truth.Fact
import com.google.common.truth.FailureMetadata
import com.google.common.truth.Subject
import com.google.common.truth.Truth.assertAbout

abstract class JsonSubject<Actual>(
    metadata: FailureMetadata,
    private val actual: Actual?
) : Subject(metadata, actual) {

    fun isEquivalentTo(expected: String) = jsonRepresentationEquivalentTo(expected, inputMapper::readTree)

    fun isEquivalentTo(expected: ByteArray) = jsonRepresentationEquivalentTo(expected, inputMapper::readTree)

    fun isEquivalentTo(expected: JsonNode) = jsonRepresentationEquivalentTo(expected) { it }

    abstract fun parseActual(): JsonNode?

    private fun <E> Subject.jsonRepresentationEquivalentTo(
        expectedSource: E,
        expectedParser: (E) -> JsonNode
    ) {
        val expectedJson = runCatching {
            expectedParser(expectedSource)
        }.getOrElse {
            failWithoutActual(Fact.simpleFact("invalid json, ${it.message}"))
            null
        }

        val actualJson = runCatching {
            if (actual != null) {
                parseActual()
            } else {
                failWithoutActual(Fact.simpleFact("actual is null"))
            }
        }.getOrElse {
            failWithoutActual(Fact.simpleFact("invalid json, ${it.message}"))
            null
        }
        check("equivalent").that(actualJson).isEqualTo(expectedJson)
    }

    internal companion object {
        val strictMapper = ObjectMapper()

        val inputMapper: ObjectMapper = ObjectMapper()
            .enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES)
            .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
            .enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION)
    }
}

class JsonStringSubject(
    metadata: FailureMetadata,
    private val actual: String?
) : JsonSubject<String>(metadata, actual) {

    override fun parseActual(): JsonNode? = actual?.let(strictMapper::readTree)

    class Factory : Subject.Factory<JsonStringSubject, String> {
        override fun createSubject(metadata: FailureMetadata, actual: String?): JsonStringSubject {
            return JsonStringSubject(metadata, actual)
        }
    }
}

class JsonByteArraySubject(
    metadata: FailureMetadata,
    private val actual: ByteArray?
) : JsonSubject<ByteArray>(metadata, actual) {

    override fun parseActual(): JsonNode? = actual?.let(strictMapper::readTree)

    class Factory : Subject.Factory<JsonByteArraySubject, ByteArray> {
        override fun createSubject(metadata: FailureMetadata, actual: ByteArray?): JsonByteArraySubject {
            return JsonByteArraySubject(metadata, actual)
        }
    }
}

class JsonNodeSubject(
    metadata: FailureMetadata,
    private val actual: JsonNode?
) : JsonSubject<JsonNode>(metadata, actual) {

    override fun parseActual(): JsonNode? = actual

    class Factory : Subject.Factory<JsonNodeSubject, JsonNode> {
        override fun createSubject(metadata: FailureMetadata, actual: JsonNode?): JsonNodeSubject {
            return JsonNodeSubject(metadata, actual)
        }
    }
}

@Suppress("UNUSED")
fun assertJson(actual: String?): JsonStringSubject = assertAbout(JsonStringSubject.Factory()).that(actual)

@Suppress("UNUSED")
fun assertJson(actual: ByteArray?): JsonByteArraySubject = assertAbout(JsonByteArraySubject.Factory()).that(actual)

@Suppress("UNUSED")
fun assertJson(actual: JsonNode?): JsonNodeSubject = assertAbout(JsonNodeSubject.Factory()).that(actual)
