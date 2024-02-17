# WebAuthnKt

[![jitpack](https://jitpack.io/v/RyuNen344/WebAuthnKt.svg)](https://jitpack.io/#RyuNen344/WebAuthnKt)

Pure pre-implementation
of [Web Authentication: An API for accessing Public Key Credentials Level 2](https://www.w3.org/TR/webauthn-2/)</br>
This library allows you to use WebAuthn JSON without self-implementation.</br>
Assume that uses this library with [CredentialManager](https://developer.android.com/reference/android/credentials/CredentialManager)</br>
But your app doesn't need to depend on GMS APIs.</br>
Inspired by [webauthn-json](https://github.com/github/webauthn-json)</br>

### Pre-implemented JSONs

- [PublicKeyCredentialDescriptor](webauthn2-json-core/src/main/java/io/github/ryunen344/webauthn2/json/core/PublicKeyCredentialDescriptor.kt)
- [AuthenticatorAttestationResponse](webauthn2-json-core/src/main/java/io/github/ryunen344/webauthn2/json/core/AuthenticatorResponse.kt)
- [AuthenticatorAssertionResponse](webauthn2-json-core/src/main/java/io/github/ryunen344/webauthn2/json/core/AuthenticatorResponse.kt)
- [CredentialCreationOptions](webauthn2-json-core/src/main/java/io/github/ryunen344/webauthn2/json/core/PublicKeyCredentialCreationOptions.kt)
- [CredentialRequestOptions](webauthn2-json-core/src/main/java/io/github/ryunen344/webauthn2/json/core/PublicKeyCredentialRequestOptions.kt)

### Supported Serialization Library
- [Moshi](https://github.com/square/moshi)
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)

## Setup

### MavenCentral

Set your `settings.gradle` like below

```groovy:settings.gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
```

Set your `build.gradle` like below

```groovy:settings.gradle
dependencies {
    // moshi
    implementation 'io.github.ryunen344.webauthn:webauthn2-json-moshi:${version}'
    
    // kotlinx.serialization
    implementation 'io.github.ryunen344.webauthn:webauthn2-json-serialization:${version}'
}
```

### JitPack

Set your `settings.gradle` like below

```groovy:settings.gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Set your `build.gradle` like below

```groovy:settings.gradle
dependencies {
    // moshi
    implementation 'com.github.RyuNen344.WebAuthnKt:webauthn2-json-moshi:${version}'
    
    // kotlinx.serialization
    implementation 'com.github.RyuNen344.WebAuthnKt:webauthn2-json-serialization:${version}'
}
```

## Usage

### Moshi

you need to use WebAuthnAdapterHelper to setup moshi

```kotlin 
val moshi = Moshi.Builder().apply(WebAuthnAdapterHelper()::setup).build()
val adapter = moshi.adapter(PublicKeyCredentialCreationOptions::class.java)
val json = adapter.fromJson(PublicKeyCredentialCreationOptionsJSON)
```

### kotlinx.serialization

you can use serializers, directly

```kotlin
Json {}.encodeToString(
    PublicKeyCredentialRequestOptions.serializer(),
    PublicKeyCredentialRequestOptionsJSON
)
```

# License

```
Copyright 2023 RyuNen344
Copyright 2015 Square, Inc.
Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0.txt

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
