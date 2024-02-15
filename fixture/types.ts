import { Base64urlString } from "@github/webauthn-json/src/webauthn-json/base64url";

export type LargeBlobSupport = "required" | "preferred";
export type TokenBindingStatus = "present" | "supported";

export interface AuthenticationExtensionsLargeBlobInputs {
    support?: LargeBlobSupport;
    read?: boolean;
    write?: Base64urlString;
}

export interface AuthenticationExtensionsLargeBlobOutputs {
    supported?: boolean;
    blob?: Base64urlString;
    written?: boolean;
}

export interface TokenBinding {
    status: TokenBindingStatus;
    id?: string;
}

export interface CollectedClientData {
    type: "webauthn.create" | "webauthn.get";
    challenge: Base64urlString;
    origin: string;
    crossOrigin?: boolean;
    tokenBinding?: TokenBinding;
}

export interface PublicKeyCredentialDescriptor {
    id: Base64urlString;
    transports?: AuthenticatorTransport[];
    type: PublicKeyCredentialType;
}

export interface AuthenticationExtensionsClientInputs {
    appid?: string;
    appidExclude?: string;
    uvm?: boolean;
    credProps?: boolean;
    largeBlob?: AuthenticationExtensionsLargeBlobInputs;
    // undefined values
    boolean?: boolean;
    number?: number;
    string?: string;
    array?: number[];
    object?: { [key: string]: string };
}

export interface AuthenticationExtensionsClientOutputs {
    appid?: boolean;
    appidExclude?: boolean;
    uvm?: UvmEntries;
    credProps?: CredentialPropertiesOutput;
    largeBlob?: AuthenticationExtensionsLargeBlobOutputs;
    // undefined values
    boolean?: boolean;
    number?: number;
    string?: string;
    array?: number[];
    object?: { [key: string]: string };
}

export type UvmEntry = number[];
export type UvmEntries = UvmEntry[];
