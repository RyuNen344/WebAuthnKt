package io.github.ryunen344.webauthn2.json.serialization

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransportTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import kotlinx.serialization.encodeToString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KotlinxAuthenticatorTransportTest : AuthenticatorTransportTest() {
    @Test
    override fun testSerialize_givenUsb_thenValueIsUsb() =
        runJsonTest("AuthenticatorTransport-usb.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorTransport.Usb)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenNfc_thenValueIsNfc() =
        runJsonTest("AuthenticatorTransport-nfc.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorTransport.Nfc)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenBle_thenValueIsBle() =
        runJsonTest("AuthenticatorTransport-ble.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorTransport.Ble)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenInternal_thenValueIsInternal() =
        runJsonTest("AuthenticatorTransport-internal.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorTransport.Internal)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("AuthenticatorTransport-unknown.json") {
            val actual = JsonUtil.json.encodeToString(AuthenticatorTransport.Unknown)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenUsbJsonString_thenValueIsUsb() =
        runJsonTest("AuthenticatorTransport-usb.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorTransport>(it)
            assertThat(actual).isEqualTo(AuthenticatorTransport.Usb)
        }

    @Test
    override fun testDeserialize_givenNfcJsonString_thenValueIsNfc() =
        runJsonTest("AuthenticatorTransport-nfc.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorTransport>(it)
            assertThat(actual).isEqualTo(AuthenticatorTransport.Nfc)
        }

    @Test
    override fun testDeserialize_givenBleJsonString_thenValueIsBle() =
        runJsonTest("AuthenticatorTransport-ble.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorTransport>(it)
            assertThat(actual).isEqualTo(AuthenticatorTransport.Ble)
        }

    @Test
    override fun testDeserialize_givenInternalJsonString_thenValueIsInternal() =
        runJsonTest("AuthenticatorTransport-internal.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorTransport>(it)
            assertThat(actual).isEqualTo(AuthenticatorTransport.Internal)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorTransport-undefined.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorTransport>(it)
            assertThat(actual).isEqualTo(AuthenticatorTransport.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorTransport-unknown.json") {
            val actual = JsonUtil.json.decodeFromString<AuthenticatorTransport>(it)
            assertThat(actual).isEqualTo(AuthenticatorTransport.Unknown)
        }
}
