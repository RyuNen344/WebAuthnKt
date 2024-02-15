package io.github.ryunen344.webauthn2.json.core

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-pkcredentialentity
 */
@Serializable
@JsonClass(generateAdapter = false)
sealed class PublicKeyCredentialEntity {
    abstract val name: DOMString
}

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-rp-credential-params
 */
@Serializable
@JsonClass(generateAdapter = true)
class PublicKeyCredentialRpEntity(
    @field:Json(name = "name")
    @SerialName("name")
    override val name: DOMString,

    @field:Json(name = "id")
    @SerialName("id")
    val id: DOMString?,
) : PublicKeyCredentialEntity() {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true

            other is PublicKeyCredentialRpEntity -> {
                other.name == name &&
                    other.id == id
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }
}

/**
 * https://www.w3.org/TR/webauthn-2/#dictionary-user-credential-params
 */
@Serializable
@JsonClass(generateAdapter = true)
class PublicKeyCredentialUserEntity(
    @field:Json(name = "name")
    @SerialName("name")
    override val name: DOMString,

    @field:Json(name = "id")
    @SerialName("id")
    val id: BufferSource,

    @field:Json(name = "displayName")
    @SerialName("displayName")
    val displayName: DOMString,
) : PublicKeyCredentialEntity() {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true

            other is PublicKeyCredentialUserEntity -> {
                other.name == name &&
                    other.id == id &&
                    other.displayName == displayName
            }

            else -> false
        }
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + displayName.hashCode()
        return result
    }
}
