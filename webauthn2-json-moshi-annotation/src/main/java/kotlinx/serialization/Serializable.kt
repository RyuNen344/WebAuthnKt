package kotlinx.serialization

import kotlin.reflect.KClass

/**
 * shadow annotation of [kotlinx.serialization.Serializable]
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class Serializable(val with: KClass<out KSerializer<*>> = KSerializer::class)
