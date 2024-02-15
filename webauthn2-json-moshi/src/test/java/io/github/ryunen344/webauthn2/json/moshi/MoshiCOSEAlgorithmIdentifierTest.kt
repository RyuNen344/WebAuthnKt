package io.github.ryunen344.webauthn2.json.moshi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.github.ryunen344.webauthn2.json.core.COSEAlgorithmIdentifier
import io.github.ryunen344.webauthn2.json.core.COSEAlgorithmIdentifierTest
import io.github.ryunen344.webauthn2.json.core.test.runJsonTest
import io.github.ryunen344.webauthn2.json.core.test.truth.assertJson
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoshiCOSEAlgorithmIdentifierTest : COSEAlgorithmIdentifierTest() {
    @Test
    override fun testSerialize_givenES256_thenSerializeToNegative7() =
        runJsonTest("COSEAlgorithmIdentifier-es256.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.toJson(COSEAlgorithmIdentifier.ES256)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenES384_thenSerializeToNegative35() =
        runJsonTest("COSEAlgorithmIdentifier-es384.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.toJson(COSEAlgorithmIdentifier.ES384)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenES512_thenSerializeToNegative36() =
        runJsonTest("COSEAlgorithmIdentifier-es512.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.toJson(COSEAlgorithmIdentifier.ES512)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenEdDSA_thenSerializeToNegative8() =
        runJsonTest("COSEAlgorithmIdentifier-eddsa.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.toJson(COSEAlgorithmIdentifier.EdDSA)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRS256_thenSerializeToNegative257() =
        runJsonTest("COSEAlgorithmIdentifier-rs256.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.toJson(COSEAlgorithmIdentifier.RS256)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRS384_thenSerializeToNegative258() =
        runJsonTest("COSEAlgorithmIdentifier-rs384.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.toJson(COSEAlgorithmIdentifier.RS384)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testSerialize_givenRS512_thenSerializeToNegative259() =
        runJsonTest("COSEAlgorithmIdentifier-rs512.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.toJson(COSEAlgorithmIdentifier.RS512)
            assertJson(actual).isEquivalentTo(it)
        }

    @Test
    override fun testDeserialize_givenNegative7_thenDeserializeToES256() =
        runJsonTest("COSEAlgorithmIdentifier-es256.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(COSEAlgorithmIdentifier.ES256)
        }

    @Test
    override fun testDeserialize_givenNegative35_thenDeserializeToES384() =
        runJsonTest("COSEAlgorithmIdentifier-es384.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(COSEAlgorithmIdentifier.ES384)
        }

    @Test
    override fun testDeserialize_givenNegative36_thenDeserializeToES512() =
        runJsonTest("COSEAlgorithmIdentifier-es512.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(COSEAlgorithmIdentifier.ES512)
        }

    @Test
    override fun testDeserialize_givenNegative8_thenDeserializeToEdDSA() =
        runJsonTest("COSEAlgorithmIdentifier-eddsa.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(COSEAlgorithmIdentifier.EdDSA)
        }

    @Test
    override fun testDeserialize_givenNegative257_thenDeserializeToRS256() =
        runJsonTest("COSEAlgorithmIdentifier-rs256.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(COSEAlgorithmIdentifier.RS256)
        }

    @Test
    override fun testDeserialize_givenNegative258_thenDeserializeToRS384() =
        runJsonTest("COSEAlgorithmIdentifier-rs384.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(COSEAlgorithmIdentifier.RS384)
        }

    @Test
    override fun testDeserialize_givenNegative259_thenDeserializeToRS512() =
        runJsonTest("COSEAlgorithmIdentifier-rs512.json") {
            val adapter = MoshiUtil.adapter(COSEAlgorithmIdentifier::class)
            val actual = adapter.fromJson(it)
            assertThat(actual).isEqualTo(COSEAlgorithmIdentifier.RS512)
        }
}
