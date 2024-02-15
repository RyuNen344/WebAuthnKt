import { bufferToBase64url } from "@github/webauthn-json/extended";
import * as fs from "fs";
import { PathLike } from "fs";
import {
    AuthenticationExtensionsClientInputs,
    AuthenticationExtensionsClientOutputs,
    AuthenticationExtensionsLargeBlobInputs,
    AuthenticationExtensionsLargeBlobOutputs,
    CollectedClientData,
    LargeBlobSupport,
    PublicKeyCredentialDescriptor,
    TokenBinding,
    TokenBindingStatus,
} from "./types";
import {
    AuthenticatorAssertionResponseJSON,
    AuthenticatorAttestationResponseJSON,
    PublicKeyCredentialCreationOptionsJSON,
    PublicKeyCredentialRequestOptionsJSON,
    PublicKeyCredentialUserEntityJSON,
} from "@simplewebauthn/types";

const fixturePath = "fixture/json";
const S = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
const N = 16;

const clientData: CollectedClientData = {
    origin: "https://github.com/RyuNen344/WebAuthnKt",
    challenge: "aXo0cnI0c3RMSXdabFA1SA",
    type: "webauthn.create",
    crossOrigin: false,
    tokenBinding: {
        status: "supported",
    },
};

const random = () =>
    Array.from(crypto.getRandomValues(new Uint8Array(N)))
        .map((n) => S[n % S.length])
        .join("");

const buffer = (value: string | number | boolean) =>
    new Uint8Array(
        decodeURIComponent(encodeURIComponent(value))
            .split("")
            .map((char) => char.charCodeAt(0)),
    );

const write = (path: PathLike, object: any) => fs.promises.writeFile(path, JSON.stringify(object, null, 2), "utf-8");

const authenticationExtensionsClientInputs = () => {
    const json: [string, AuthenticationExtensionsClientInputs][] = [
        ["none", {}],
        [
            "appid",
            {
                appid: "AuthenticationExtensionsClientInputs-appid",
            },
        ],
        [
            "appidExclude",
            {
                appidExclude: "AuthenticationExtensionsClientInputs-appidExclude",
            },
        ],
        [
            "uvm",
            {
                uvm: true,
            },
        ],
        [
            "credProps",
            {
                credProps: true,
            },
        ],
        [
            "largeBlob",
            {
                largeBlob: {},
            },
        ],
        [
            "undefined",
            {
                boolean: true,
                number: 1,
                string: "string",
                array: [1, 2, 3],
                object: { key: "value" },
            },
        ],
    ];
    return json.map(([path, object]) =>
        write(`${fixturePath}/AuthenticationExtensionsClientInputs-${path}.json`, object),
    );
};

const authenticationExtensionsClientOutputs = () => {
    const json: [string, AuthenticationExtensionsClientOutputs][] = [
        ["none", {}],
        [
            "appid",
            {
                appid: true,
            },
        ],
        [
            "appidExclude",
            {
                appidExclude: false,
            },
        ],
        [
            "uvm",
            {
                uvm: [
                    [1, 2],
                    [3, 4],
                ],
            },
        ],
        [
            "credProps",
            {
                credProps: {
                    rk: true,
                },
            },
        ],
        [
            "largeBlob",
            {
                largeBlob: {
                    supported: false,
                },
            },
        ],
        [
            "undefined",
            {
                boolean: true,
                number: 1,
                string: "string",
                array: [1, 2, 3],
                object: { key: "value" },
            },
        ],
    ];
    return json.map(([path, object]) =>
        write(`${fixturePath}/AuthenticationExtensionsClientOutputs-${path}.json`, object),
    );
};

const attestationConveyancePreference = () => {
    const json: [string, AttestationConveyancePreference | string][] = [
        ["none", "none"],
        ["indirect", "indirect"],
        ["direct", "direct"],
        ["enterprise", "enterprise"],
        ["undefined", "undefined"],
        ["unknown", ""],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/AttestationConveyancePreference-${path}.json`, object));
};

const authenticatorAttachment = () => {
    const json: [string, AuthenticatorAttachment | string][] = [
        ["platform", "platform"],
        ["cross-platform", "cross-platform"],
        ["undefined", "undefined"],
        ["unknown", ""],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/AuthenticatorAttachment-${path}.json`, object));
};

const authenticatorTransport = () => {
    const json: [string, AuthenticatorTransport | string][] = [
        ["usb", "usb"],
        ["nfc", "nfc"],
        ["ble", "ble"],
        ["internal", "internal"],
        ["undefined", "undefined"],
        ["unknown", ""],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/AuthenticatorTransport-${path}.json`, object));
};

const largeBlobSupport = () => {
    const json: [string, LargeBlobSupport][] = [
        ["required", "required"],
        ["preferred", "preferred"],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/LargeBlobSupport-${path}.json`, object));
};

const publicKeyCredentialType = () => {
    const json: [string, PublicKeyCredentialType | string][] = [
        ["public-key", "public-key"],
        ["undefined", "undefined"],
        ["unknown", ""],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/PublicKeyCredentialType-${path}.json`, object));
};

const residentKeyRequirement = () => {
    const json: [string, ResidentKeyRequirement | string][] = [
        ["discouraged", "discouraged"],
        ["preferred", "preferred"],
        ["required", "required"],
        ["undefined", "undefined"],
        ["unknown", ""],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/ResidentKeyRequirement-${path}.json`, object));
};

const tokenBindingStatus = () => {
    const json: [string, TokenBindingStatus | string][] = [
        ["present", "present"],
        ["supported", "supported"],
        ["undefined", "undefined"],
        ["unknown", ""],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/TokenBindingStatus-${path}.json`, object));
};

const userVerificationRequirement = () => {
    const json: [string, UserVerificationRequirement | string][] = [
        ["required", "required"],
        ["preferred", "preferred"],
        ["discouraged", "discouraged"],
        ["undefined", "undefined"],
        ["unknown", ""],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/UserVerificationRequirement-${path}.json`, object));
};

const authenticationExtensionsLargeBlobInputs = () => {
    const json: [string, AuthenticationExtensionsLargeBlobInputs][] = [
        [
            "registration-required",
            {
                support: "required",
            },
        ],
        [
            "registration-preferred",
            {
                support: "preferred",
            },
        ],
        [
            "authentication-read",
            {
                read: true,
            },
        ],
        [
            "authentication-write",
            {
                write: bufferToBase64url(
                    Buffer.from(
                        "UVZOUllWVTJhVUpZY1hGcFQyZGFaMEYxZEdobGJuUnBZMkYwYVc5dVJYaDBaVzV6YVc5dWMweGhjbWRsUW14dllrbHVjSFYwY3c9PQ",
                    ),
                ),
            },
        ],
    ];
    return json.map(([path, object]) =>
        write(`${fixturePath}/AuthenticationExtensionsLargeBlobInputs-${path}.json`, object),
    );
};

const authenticationExtensionsLargeBlobOutputs = () => {
    const json: [string, AuthenticationExtensionsLargeBlobOutputs][] = [
        [
            "registration-supported",
            {
                supported: true,
            },
        ],
        [
            "authentication-read",
            {
                blob: bufferToBase64url(
                    Buffer.from(
                        "VlZaU1IyRkdTalpVYlRWcFRXeHZlRlpyYUZOaWF6UjVVbXhTYTFKVldYaGFSV1J2WWtkS2RWVnVRbHBOYTFsM1dWWmpOV1JXU2xsaFJFSmhWbnBXTmxsV1l6VmtWMDEzWlVkb2FtSlhVbk5WVnpFMFpHeHNjazlVUm10VFJVbDRXa1ZvVGxCUg",
                    ),
                ),
            },
        ],
        [
            "authentication-write",
            {
                written: true,
            },
        ],
    ];
    return json.map(([path, object]) =>
        write(`${fixturePath}/AuthenticationExtensionsLargeBlobOutputs-${path}.json`, object),
    );
};

const authenticatorAttestationResponse = () => {
    const json: [string, AuthenticatorAttestationResponseJSON][] = [
        [
            "minimum",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                attestationObject: "TEE1T2xhZWtqbE1iVXEzM09zRkx6STNsbWRUMmhqaEptMnFEZ2pRcEZYQkVwMFY5",
            },
        ],
        [
            "empty-transports",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                attestationObject: "NFJyUE1vR21aUVhzbUhqSWJBRlJLMXhRWU5EVlY0NVpydTlvcnZOd05NWXFyakdW",
                transports: [],
            },
        ],
        [
            "transports",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                attestationObject: "dmkxOWVjWU4zbVNXNVRIeU5DS0RIaGVWc0hPd1BEMWl6UE5ITzkyeEdDV0VvNHZl",
                transports: ["usb"],
            },
        ],
        [
            "authenticator-data",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                attestationObject: "aU5oYmdUa29vczFoeldqd05YR09VNm5lU1VrbkVKOENnRlNtQVdWcDRHVEhwUXBt",
                authenticatorData: "WUpJZmpyT3hVb2U2aUxlZEoxdmVhc29HYzZ2MWduTmpRUmo4UHVSQTJnYk45aTRW",
            },
        ],
        [
            "public-key",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                attestationObject: "R3dPQVZ3aXp0NjBhazJhZ2R3MFNRUU9WYmVoUGdha1ZXanAxUjBJcmZSb01TMEpL",
                publicKey: "aU9lZlNkSzg2akdHYmxOemhzNVJTRTI2d1dxb3lOcXJyclR0YUFEejNyQnR2S2No",
            },
        ],
        [
            "algorithm",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                attestationObject: "NkpkbFRMcWlYc2ZEaUtUa2hJYXZIanhBZkx2a3paRjNTSUFlUXc2aGJCaG43MVBX",
                publicKeyAlgorithm: -257,
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/AuthenticatorAttestationResponse-${path}.json`, object));
};

const authenticatorAssertionResponse = () => {
    const json: [string, AuthenticatorAssertionResponseJSON][] = [
        [
            "handle",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                authenticatorData: "WUpJZmpyT3hVb2U2aUxlZEoxdmVhc29HYzZ2MWduTmpRUmo4UHVSQTJnYk45aTRW",
                signature: "amZiNGxzNEFRQlRyT25SbA",
                userHandle: "SmpWTmdxRzBLZGFaalJZYw",
            },
        ],
        [
            "empty-handle",
            {
                clientDataJSON: bufferToBase64url(Buffer.from(JSON.stringify(clientData))),
                authenticatorData: "WUpJZmpyT3hVb2U2aUxlZEoxdmVhc29HYzZ2MWduTmpRUmo4UHVSQTJnYk45aTRW",
                signature: "TW1MZlpsWkN2THBiUDJrZw",
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/AuthenticatorAssertionResponse-${path}.json`, object));
};

const authenticatorSelectionCriteria = () => {
    const json: [string, AuthenticatorSelectionCriteria][] = [
        ["null", {}],
        [
            "attachment",
            {
                authenticatorAttachment: "cross-platform",
            },
        ],
        [
            "resident-key",
            {
                residentKey: "required",
            },
        ],
        [
            "require-resident-key",
            {
                requireResidentKey: true,
            },
        ],
        [
            "user-verification",
            {
                userVerification: "required",
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/AuthenticatorSelectionCriteria-${path}.json`, object));
};

const base64URLString = () => {
    const json: [string, string][] = [
        ["empty", ""],
        ["zero", bufferToBase64url(Buffer.from("0"))],
        [
            "alphabet",
            bufferToBase64url(Buffer.from("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/")),
        ],
        [
            "jwks",
            "eyJrZXlzIjpbeyJrdHkiOiJvY3QiLCJhbGciOiJBMTI4S1ciLCJrIjoiR2F3Z2d1RnlHcldLYXY3QVg0VktVZyJ9LHsia3R5Ijoib2N0IiwiayI6IkF5TTFTeXNQcGJ5RGZnWmxkM3VtajFxektPYndWTWtvcVEtRXN0SlFMcl9ULTFxUzBnWkg3NWFLdE1OM1lqMGlQUzRoY2dVdVR3akF6WnIxWjlDQW93Iiwia2lkIjoiSE1BQyBrZXkgdXNlZCBpbiBKV1Mgc3BlYyBBcHBlbmRpeCBBLjEgZXhhbXBsZSJ9XX0",
        ],
        ["jwt", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/Base64URLString-${path}.json`, object));
};

const collectedClientData = () => {
    const json: [string, CollectedClientData][] = [
        [
            "minimum",
            {
                origin: "https://github.com/RyuNen344/WebAuthnKt",
                challenge: "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9",
                type: "webauthn.create",
            },
        ],
        [
            "cross-origin",
            {
                origin: "https://github.com/RyuNen344/WebAuthnKt",
                challenge: "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9",
                type: "webauthn.create",
                crossOrigin: true,
            },
        ],
        [
            "token",
            {
                origin: "https://github.com/RyuNen344/WebAuthnKt",
                challenge: "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9",
                type: "webauthn.get",
                tokenBinding: {
                    status: "supported",
                },
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/CollectedClientData-${path}.json`, object));
};

const coseAlgorithmIdentifier = () => {
    const json: [string, COSEAlgorithmIdentifier][] = [
        ["es256", -7],
        ["es384", -35],
        ["es512", -36],
        ["eddsa", -8],
        ["rs256", -257],
        ["rs384", -258],
        ["rs512", -259],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/COSEAlgorithmIdentifier-${path}.json`, object));
};

const credentialPropertiesOutput = () => {
    const json: [string, CredentialPropertiesOutput][] = [
        ["undefined", {}],
        [
            "true",
            {
                rk: true,
            },
        ],
        [
            "false",
            {
                rk: false,
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/CredentialPropertiesOutput-${path}.json`, object));
};

const publicKeyCredentialCreationOptions = () => {
    const json: [string, PublicKeyCredentialCreationOptionsJSON][] = [
        [
            "minimum",
            {
                rp: {
                    name: "PublicKeyCredentialRpEntity-name",
                },
                user: {
                    name: "PublicKeyCredentialUserEntity-name",
                    id: "PublicKeyCredentialUserEntity-id",
                    displayName: "PublicKeyCredentialUserEntity-displayName",
                },
                challenge: bufferToBase64url(buffer("challenge")),
                pubKeyCredParams: [
                    {
                        type: "public-key",
                        alg: -7,
                    },
                ],
            },
        ],
        [
            "timeout",
            {
                rp: {
                    name: "PublicKeyCredentialRpEntity-name",
                },
                user: {
                    name: "PublicKeyCredentialUserEntity-name",
                    id: "PublicKeyCredentialUserEntity-id",
                    displayName: "PublicKeyCredentialUserEntity-displayName",
                },
                challenge: bufferToBase64url(buffer("challenge")),
                pubKeyCredParams: [
                    {
                        type: "public-key",
                        alg: -7,
                    },
                ],
                timeout: 6000,
            },
        ],
        [
            "exclude-credentials",
            {
                rp: {
                    name: "PublicKeyCredentialRpEntity-name",
                },
                user: {
                    name: "PublicKeyCredentialUserEntity-name",
                    id: "PublicKeyCredentialUserEntity-id",
                    displayName: "PublicKeyCredentialUserEntity-displayName",
                },
                challenge: bufferToBase64url(buffer("challenge")),
                pubKeyCredParams: [
                    {
                        type: "public-key",
                        alg: -7,
                    },
                ],
                excludeCredentials: [
                    {
                        type: "public-key",
                        id: bufferToBase64url(buffer("PublicKeyCredentialDescriptor-id")),
                    },
                ],
            },
        ],
        [
            "authenticator-selection",
            {
                rp: {
                    name: "PublicKeyCredentialRpEntity-name",
                },
                user: {
                    name: "PublicKeyCredentialUserEntity-name",
                    id: "PublicKeyCredentialUserEntity-id",
                    displayName: "PublicKeyCredentialUserEntity-displayName",
                },
                challenge: bufferToBase64url(buffer("challenge")),
                pubKeyCredParams: [
                    {
                        type: "public-key",
                        alg: -7,
                    },
                ],
                authenticatorSelection: {
                    authenticatorAttachment: "cross-platform",
                },
            },
        ],
        [
            "attestation",
            {
                rp: {
                    name: "PublicKeyCredentialRpEntity-name",
                },
                user: {
                    name: "PublicKeyCredentialUserEntity-name",
                    id: "PublicKeyCredentialUserEntity-id",
                    displayName: "PublicKeyCredentialUserEntity-displayName",
                },
                challenge: bufferToBase64url(buffer("challenge")),
                pubKeyCredParams: [
                    {
                        type: "public-key",
                        alg: -7,
                    },
                ],
                attestation: "direct",
            },
        ],
    ];
    return json.map(([path, object]) =>
        write(`${fixturePath}/PublicKeyCredentialCreationOptions-${path}.json`, object),
    );
};

const publicKeyCredentialDescriptor = () => {
    const json: [string, PublicKeyCredentialDescriptor][] = [
        [
            "transport",
            {
                type: "public-key",
                id: bufferToBase64url(Buffer.from("PublicKeyCredentialDescriptor-id")),
                transports: ["ble", "internal", "nfc", "usb"],
            },
        ],
        [
            "empty-transport",
            {
                type: "public-key",
                id: bufferToBase64url(Buffer.from("PublicKeyCredentialDescriptor-id")),
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/PublicKeyCredentialDescriptor-${path}.json`, object));
};

const publicKeyCredentialRpEntity = () => {
    const json: [string, PublicKeyCredentialRpEntity][] = [
        [
            "id",
            {
                name: "PublicKeyCredentialRpEntity-name",
                id: "PublicKeyCredentialRpEntity-id",
            },
        ],
        [
            "empty-id",
            {
                name: "PublicKeyCredentialRpEntity-name",
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/PublicKeyCredentialRpEntity-${path}.json`, object));
};

const publicKeyCredentialUserEntity = () => {
    const json: [string, PublicKeyCredentialUserEntityJSON][] = [
        [
            "value",
            {
                name: "PublicKeyCredentialUserEntity-name",
                id: bufferToBase64url(buffer("PublicKeyCredentialUserEntity-id")),
                displayName: "PublicKeyCredentialUserEntity-displayName",
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/PublicKeyCredentialUserEntity-${path}.json`, object));
};

const publicKeyCredentialParameters = () => {
    const json: [string, PublicKeyCredentialParameters][] = [
        [
            "value",
            {
                type: "public-key",
                alg: -7,
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/PublicKeyCredentialParameters-${path}.json`, object));
};

const publicKeyCredentialRequestOptions = () => {
    const json: [string, PublicKeyCredentialRequestOptionsJSON][] = [
        [
            "minimum",
            {
                challenge: bufferToBase64url(buffer("challenge")),
            },
        ],
        [
            "timeout",
            {
                challenge: bufferToBase64url(buffer("challenge")),
                timeout: 6000,
            },
        ],
        [
            "rp-id",
            {
                challenge: bufferToBase64url(buffer("challenge")),
                rpId: "PublicKeyCredentialRequestOptions-rpId",
            },
        ],
        [
            "allow-credentials",
            {
                challenge: bufferToBase64url(buffer("challenge")),
                allowCredentials: [
                    {
                        type: "public-key",
                        id: bufferToBase64url(buffer("PublicKeyCredentialDescriptor-id")),
                    },
                ],
            },
        ],
        [
            "user-verification",
            {
                challenge: bufferToBase64url(buffer("challenge")),
                userVerification: "discouraged",
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/PublicKeyCredentialRequestOptions-${path}.json`, object));
};

const tokenBinding = () => {
    const json: [string, TokenBinding][] = [
        [
            "id",
            {
                status: "supported",
                id: "TokenBinding-id",
            },
        ],
        [
            "null",
            {
                status: "supported",
            },
        ],
    ];
    return json.map(([path, object]) => write(`${fixturePath}/TokenBinding-${path}.json`, object));
};

async function main() {
    await Promise.all([
        ...authenticationExtensionsClientInputs(),
        ...authenticationExtensionsClientOutputs(),
        ...attestationConveyancePreference(),
        ...authenticatorAttachment(),
        ...authenticatorTransport(),
        ...largeBlobSupport(),
        ...publicKeyCredentialType(),
        ...residentKeyRequirement(),
        ...tokenBindingStatus(),
        ...userVerificationRequirement(),
        ...authenticationExtensionsLargeBlobInputs(),
        ...authenticationExtensionsLargeBlobOutputs(),
        ...authenticatorAttestationResponse(),
        ...authenticatorAssertionResponse(),
        ...authenticatorSelectionCriteria(),
        ...base64URLString(),
        ...collectedClientData(),
        ...coseAlgorithmIdentifier(),
        ...credentialPropertiesOutput(),
        ...publicKeyCredentialCreationOptions(),
        ...publicKeyCredentialDescriptor(),
        ...publicKeyCredentialRpEntity(),
        ...publicKeyCredentialUserEntity(),
        ...publicKeyCredentialParameters(),
        ...publicKeyCredentialRequestOptions(),
        ...tokenBinding(),
    ]);
}

main().catch(console.error);
