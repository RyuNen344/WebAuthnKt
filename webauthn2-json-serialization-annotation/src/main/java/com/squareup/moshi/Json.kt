package com.squareup.moshi

/**
 * shadow annotation of [com.squareup.moshi.Json]
 */
@Retention(AnnotationRetention.SOURCE)
annotation class Json(val name: String = "\u0000", val ignore: Boolean = false)
