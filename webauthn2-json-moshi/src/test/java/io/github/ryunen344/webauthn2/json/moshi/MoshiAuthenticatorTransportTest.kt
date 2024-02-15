package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransport
import io.github.ryunen344.webauthn2.json.core.enum.AuthenticatorTransportTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiAuthenticatorTransportTest : AuthenticatorTransportTest() {
    @Test
    override fun testSerialize_givenUsb_thenValueIsUsb() =
        runJsonTest("AuthenticatorTransport-usb.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val serialized = adapter.toJson(AuthenticatorTransport.Usb)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenNfc_thenValueIsNfc() =
        runJsonTest("AuthenticatorTransport-nfc.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val serialized = adapter.toJson(AuthenticatorTransport.Nfc)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenBle_thenValueIsBle() =
        runJsonTest("AuthenticatorTransport-ble.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val serialized = adapter.toJson(AuthenticatorTransport.Ble)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenInternal_thenValueIsInternal() =
        runJsonTest("AuthenticatorTransport-internal.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val serialized = adapter.toJson(AuthenticatorTransport.Internal)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenUnknown_thenValueIsUnknown() =
        runJsonTest("AuthenticatorTransport-unknown.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val serialized = adapter.toJson(AuthenticatorTransport.Unknown)
            assertJson(serialized).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenUsbJsonString_thenValueIsUsb() =
        runJsonTest("AuthenticatorTransport-usb.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val transport = adapter.fromJson(it)
            assertThat(transport).isEqualTo(AuthenticatorTransport.Usb)
        }

    @Test
    override fun testDeserialize_givenNfcJsonString_thenValueIsNfc() =
        runJsonTest("AuthenticatorTransport-nfc.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val transport = adapter.fromJson(it)
            assertThat(transport).isEqualTo(AuthenticatorTransport.Nfc)
        }

    @Test
    override fun testDeserialize_givenBleJsonString_thenValueIsBle() =
        runJsonTest("AuthenticatorTransport-ble.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val transport = adapter.fromJson(it)
            assertThat(transport).isEqualTo(AuthenticatorTransport.Ble)
        }

    @Test
    override fun testDeserialize_givenInternalJsonString_thenValueIsInternal() =
        runJsonTest("AuthenticatorTransport-internal.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val transport = adapter.fromJson(it)
            assertThat(transport).isEqualTo(AuthenticatorTransport.Internal)
        }

    @Test
    override fun testDeserialize_givenUndefinedJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorTransport-undefined.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val transport = adapter.fromJson(it)
            assertThat(transport).isEqualTo(AuthenticatorTransport.Unknown)
        }

    @Test
    override fun testDeserialize_givenUnknownJsonString_thenValueIsUnknown() =
        runJsonTest("AuthenticatorTransport-unknown.json") {
            val adapter = MoshiUtil.adapter(AuthenticatorTransport::class)
            val transport = adapter.fromJson(it)
            assertThat(transport).isEqualTo(AuthenticatorTransport.Unknown)
        }
}
