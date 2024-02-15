package io.github.ryunen344.webauthn2.json.core.partial

import io.github.ryunen344.webauthn2.json.core.AuthenticationExtensionsLargeBlobInputs
import io.github.ryunen344.webauthn2.json.core.DOMString
import io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-appid-extension
 */
val AuthenticationExtensionsClientInputs.appid: DOMString?
    get() = value[AuthenticationExtensionsClientInputs.reserved[0]] as? DOMString

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-appid-exclude-extension
 */
val AuthenticationExtensionsClientInputs.appidExclude: DOMString?
    get() = value[AuthenticationExtensionsClientInputs.reserved[1]] as? DOMString

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-uvm-extension
 */
val AuthenticationExtensionsClientInputs.uvm: Boolean?
    get() = value[AuthenticationExtensionsClientInputs.reserved[2]] as? Boolean

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-authenticator-credential-properties-extension
 */
val AuthenticationExtensionsClientInputs.credProps: Boolean?
    get() = value[AuthenticationExtensionsClientInputs.reserved[3]] as? Boolean

/**
 * https://www.w3.org/TR/webauthn-2/#sctn-large-blob-extension
 */
val AuthenticationExtensionsClientInputs.largeBlob: AuthenticationExtensionsLargeBlobInputs?
    get() = value[AuthenticationExtensionsClientInputs.reserved[4]] as? AuthenticationExtensionsLargeBlobInputs
