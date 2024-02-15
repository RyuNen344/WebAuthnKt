package io.github.ryunen344.webauthn2.json.moshi.annotation

/**
 * if present, deserialize undefined values in JSON to null by [io.github.ryunen344.webauthn2.json.moshi.UndefinedToNullJsonFactory]
 *
 * when applied this with [com.squareup.moshi.Json] annotated field, it requires define {@code @field:Json(name = "fieldName")} to use the field name in JSON
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class UndefinedToNull
