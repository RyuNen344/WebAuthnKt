package com.squareup.moshi

/**
 * shadow annotation of [com.squareup.moshi.JsonClass]
 */
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonClass(val generateAdapter: Boolean, val generator: String = "")
