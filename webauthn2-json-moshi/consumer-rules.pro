-if class io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
-keepnames class io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
-if class io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientInputs
-keep class io.github.ryunen344.webauthn2.json.moshi.AuthenticationExtensionsClientInputsAdapter {
    public <init>(com.squareup.moshi.Moshi);
}

-if class io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
-keepnames class io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
-if class io.github.ryunen344.webauthn2.json.core.dict.AuthenticationExtensionsClientOutputs
-keep class io.github.ryunen344.webauthn2.json.moshi.AuthenticationExtensionsClientOutputsAdapter {
    public <init>(com.squareup.moshi.Moshi);
}
