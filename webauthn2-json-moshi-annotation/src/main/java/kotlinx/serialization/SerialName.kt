package kotlinx.serialization

/**
 * shadow annotation of [kotlinx.serialization.SerialName]
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
annotation class SerialName(val value: String)
