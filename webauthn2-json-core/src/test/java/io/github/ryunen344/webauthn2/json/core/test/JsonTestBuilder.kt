package io.github.ryunen344.webauthn2.json.core.test

private class JsonTestBuilder

fun runJsonTest(
    path: String,
    testBody: (String) -> Unit
) {
    val json = loadJson(path) ?: throw IllegalStateException("resource not found: $path")
    testBody(json)
}

private fun loadJson(path: String): String? {
    return JsonTestBuilder::class.java.classLoader?.getResourceAsStream(path)?.use {
        it.readBytes().toString(Charsets.UTF_8)
    }
}
