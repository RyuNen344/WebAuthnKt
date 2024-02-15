package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import io.github.ryunen344.webauthn2.json.moshi.annotation.UndefinedToNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UndefinedToNullJsonFactoryTest {

    private lateinit var moshi: Moshi

    @Before
    fun setup() {
        moshi = Moshi.Builder()
            .add(UndefinedToNullJsonFactory())
            .build()
    }

    @Test
    fun testUndefinedWithoutAnnotation_givenUndefined_thenSuccess() {
        val expect = UndefinedWithoutAnnotation(key = null)
        val adapter = moshi.adapter(UndefinedWithoutAnnotation::class.java)
        val serialized = adapter.toJson(expect)
        assertThat(serialized).isEqualTo(UndefinedWithoutAnnotation.JSON_UNDEFINED)

        val deserialized = adapter.fromJson(UndefinedWithoutAnnotation.JSON_UNDEFINED)
        assertThat(deserialized).isEqualTo(expect)
    }

    @Test
    fun testUndefinedWithoutAnnotation_givenValue_thenSuccess() {
        val expect = UndefinedWithoutAnnotation(key = true)
        val adapter = moshi.adapter(UndefinedWithoutAnnotation::class.java)
        val serialized = adapter.toJson(expect)
        assertThat(serialized).isEqualTo(UndefinedWithoutAnnotation.JSON_VALUE)

        val deserialized = adapter.fromJson(UndefinedWithoutAnnotation.JSON_VALUE)
        assertThat(deserialized).isEqualTo(expect)
    }

    @Test
    fun testUndefinedWithAnnotation_givenUndefined_thenSuccess() {
        val expect = UndefinedWithAnnotation(key = null)
        val adapter = moshi.adapter(UndefinedWithAnnotation::class.java)
        val serialized = adapter.toJson(expect)
        assertThat(serialized).isEqualTo(UndefinedWithAnnotation.JSON_UNDEFINED)

        val deserialized = adapter.fromJson(UndefinedWithAnnotation.JSON_UNDEFINED)
        assertThat(deserialized).isEqualTo(expect)
    }

    @Test
    fun testUndefinedWithAnnotation_givenValue_thenSuccess() {
        val expect = UndefinedWithAnnotation(key = true)
        val adapter = moshi.adapter(UndefinedWithAnnotation::class.java)
        val serialized = adapter.toJson(expect)
        assertThat(serialized).isEqualTo(UndefinedWithAnnotation.JSON_VALUE)

        val deserialized = adapter.fromJson(UndefinedWithAnnotation.JSON_VALUE)
        assertThat(deserialized).isEqualTo(expect)
    }

    @Test
    fun testUndefinedWithAnnotationAndName_givenUndefined_thenSuccess() {
        val expect = UndefinedWithAnnotationAndName(key = null)
        val adapter = moshi.adapter(UndefinedWithAnnotationAndName::class.java)
        val serialized = adapter.toJson(expect)
        assertThat(serialized).isEqualTo(UndefinedWithAnnotationAndName.JSON_UNDEFINED)

        val deserialized = adapter.fromJson(UndefinedWithAnnotationAndName.JSON_UNDEFINED)
        assertThat(deserialized).isEqualTo(expect)
    }

    @Test
    fun testUndefinedWithAnnotationAndName_givenValue_thenSuccess() {
        val expect = UndefinedWithAnnotationAndName(key = true)
        val adapter = moshi.adapter(UndefinedWithAnnotationAndName::class.java)
        val serialized = adapter.toJson(expect)
        assertThat(serialized).isEqualTo(UndefinedWithAnnotationAndName.JSON_VALUE)

        val deserialized = adapter.fromJson(UndefinedWithAnnotationAndName.JSON_VALUE)
        assertThat(deserialized).isEqualTo(expect)
    }

    @Test
    fun testUndefinedWithInvalidAnnotationAndName_givenUndefined_thenConstructsWithDefaultValue() {
        val expect = UndefinedWithInvalidAnnotationAndName(key = true)
        val adapter = moshi.adapter(UndefinedWithInvalidAnnotationAndName::class.java)
        val serialized = adapter.toJson(expect)
        assertThat(serialized).isEqualTo(UndefinedWithInvalidAnnotationAndName.JSON_VALUE)

        val deserialized = adapter.fromJson(UndefinedWithInvalidAnnotationAndName.JSON_UNDEFINED)
        assertThat(deserialized).isEqualTo(expect)
    }

    @Test
    fun testNested() {
        val adapter = moshi.adapter(NestedClass::class.java)
        val data = listOf(
            NestedClass.JSON_UNDEFINED to NestedClass(key = null, nested = null),
            NestedClass.JSON_TOP_VALUE to NestedClass(key = true, nested = null),
            NestedClass.JSON_BOTTOM_VALUE to NestedClass(key = null, nested = UndefinedWithAnnotationAndName(true))
        )
        data.forEach { (json, expected) ->
            val actual = adapter.fromJson(json)
            assertThat(actual).isEqualTo(expected)
        }
    }

    @UndefinedToNull
    @JsonClass(generateAdapter = true)
    data class UndefinedWithoutAnnotation(
        val key: Boolean? = true,
    ) {
        companion object {
            const val JSON_UNDEFINED = "{}"
            const val JSON_VALUE = "{\"key\":true}"
        }
    }

    @UndefinedToNull
    @JsonClass(generateAdapter = true)
    data class UndefinedWithAnnotation(
        @field:Json(name = "key")
        val key: Boolean? = true,
    ) {
        companion object {
            const val JSON_UNDEFINED = "{}"
            const val JSON_VALUE = "{\"key\":true}"
        }
    }

    @UndefinedToNull
    @JsonClass(generateAdapter = true)
    data class UndefinedWithAnnotationAndName(
        @field:Json(name = "not_same_key")
        val key: Boolean? = true,
    ) {
        companion object {
            const val JSON_UNDEFINED = "{}"
            const val JSON_VALUE = "{\"not_same_key\":true}"
        }
    }

    @UndefinedToNull
    @JsonClass(generateAdapter = true)
    data class UndefinedWithInvalidAnnotationAndName(
        @Json(name = "not_same_key")
        val key: Boolean? = true,
    ) {
        companion object {
            const val JSON_UNDEFINED = "{}"
            const val JSON_VALUE = "{\"not_same_key\":true}"
        }
    }

    @UndefinedToNull
    @JsonClass(generateAdapter = true)
    data class NestedClass(
        @field:Json(name = "not_same_key")
        val key: Boolean? = true,

        @field:Json(name = "not_same_nested")
        val nested: UndefinedWithAnnotationAndName? = UndefinedWithAnnotationAndName(true)
    ) {
        companion object {
            const val JSON_UNDEFINED = "{}"
            const val JSON_TOP_VALUE = "{\"not_same_key\":true}"
            const val JSON_BOTTOM_VALUE = "{\"not_same_nested\":{\"not_same_key\":true}}"
        }
    }
}
