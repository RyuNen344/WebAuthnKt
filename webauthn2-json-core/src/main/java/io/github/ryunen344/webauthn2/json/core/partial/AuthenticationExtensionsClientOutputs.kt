package io.github.ryunen344.webauthn2.json.core.partial

import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobOutputs
import io.github.ryunen344.webauthn2.json.core.CredentialPropertiesOutput
import io.github.ryunen344.webauthn2.json.core.UvmEntries
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-appid-extension
 */
val AuthenticationExtensionsClientOutputs.appid: Boolean?
    get() = value[AuthenticationExtensionsClientOutputs.reserved[0]] as? Boolean

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-appid-exclude-extension
 */
val AuthenticationExtensionsClientOutputs.appidExclude: Boolean?
    get() = value[AuthenticationExtensionsClientOutputs.reserved[1]] as? Boolean

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-uvm-extension
 */
val AuthenticationExtensionsClientOutputs.uvm: UvmEntries?
    get() = value[AuthenticationExtensionsClientOutputs.reserved[2]] as? UvmEntries

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-authenticator-credential-properties-extension
 */
val AuthenticationExtensionsClientOutputs.credProps: CredentialPropertiesOutput?
    get() = value[AuthenticationExtensionsClientOutputs.reserved[3]] as? CredentialPropertiesOutput

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-large-blob-extension
 */
val AuthenticationExtensionsClientOutputs.largeBlob: AuthenticationExtensionsLargeBlobOutputs?
    get() = value[AuthenticationExtensionsClientOutputs.reserved[4]] as? AuthenticationExtensionsLargeBlobOutputs
