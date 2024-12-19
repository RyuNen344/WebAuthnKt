package kotlinx.serialization

import kotlin.reflect.KClass

/**
 * shadow annotation of [kotlinx.serialization.Serializable]
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class Serializable(val with: KClass<out KSerializer<*>> = KSerializer::class)
