package io.github.ryunen344.webauthn2.json.moshi

import com.squareup.moshi.Moshi

@Suppress("MemberVisibilityCanBePrivate")
class WebAuthnAdapterHelper {
    fun setup(builder: Moshi.Builder): Moshi.Builder {
        return builder
            .apply(::addUndefinedToNullJsonFactory)
            .apply(::addAttestationConveyancePreferenceAdapter)
            .apply(::addAuthenticationExtensionsClientInputsAdapter)
            .apply(::addAuthenticationExtensionsClientOutputsAdapter)
            .apply(::addAuthenticatorAttachmentAdapter)
            .apply(::addAuthenticatorTransportAdapter)
            .apply(::addBase64URLStringAdapter)
            .apply(::addCOSEAlgorithmIdentifierAdapter)
            .apply(::addDOMStringAdapter)
            .apply(::addLargeBlobSupportAdapter)
            .apply(::addPublicKeyCredentialTypeAdapter)
            .apply(::addResidentKeyRequirementAdapter)
            .apply(::addTokenBindingStatusAdapter)
            .apply(::addULongAdapter)
            .apply(::addUserVerificationRequirementAdapter)
            .apply(::addUvmEntriesAdapter)
            .apply(::addUvmEntryAdapter)
    }

    fun addUndefinedToNullJsonFactory(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(UndefinedToNullJsonFactory())
    }

    fun addAttestationConveyancePreferenceAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(AttestationConveyancePreferenceAdapter())
    }

    fun addAuthenticationExtensionsClientInputsAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(AuthenticationExtensionsClientInputsAdapter.Factory())
    }

    fun addAuthenticationExtensionsClientOutputsAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(AuthenticationExtensionsClientOutputsAdapter.Factory())
    }

    fun addAuthenticatorAttachmentAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(AuthenticatorAttachmentAdapter())
    }

    fun addAuthenticatorTransportAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(AuthenticatorTransportAdapter())
    }

    fun addBase64URLStringAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(Base64URLStringAdapter())
    }

    fun addCOSEAlgorithmIdentifierAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(COSEAlgorithmIdentifierAdapter())
    }

    fun addDOMStringAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(DOMStringAdapter())
    }

    fun addLargeBlobSupportAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(LargeBlobSupportAdapter())
    }

    fun addPublicKeyCredentialTypeAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(PublicKeyCredentialTypeAdapter())
    }

    fun addResidentKeyRequirementAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(ResidentKeyRequirementAdapter())
    }

    fun addTokenBindingStatusAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(TokenBindingStatusAdapter())
    }

    fun addULongAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(ULong::class.java, ULongAdapter().nullSafe())
    }

    fun addUserVerificationRequirementAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(UserVerificationRequirementAdapter())
    }

    fun addUvmEntriesAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(UvmEntriesAdapter())
    }

    fun addUvmEntryAdapter(builder: Moshi.Builder): Moshi.Builder {
        return builder.add(UvmEntryAdapter())
    }
}
