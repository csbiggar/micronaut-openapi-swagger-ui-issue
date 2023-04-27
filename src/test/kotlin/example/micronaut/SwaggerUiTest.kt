package example.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class SwaggerUiTest(@Client("/") val client: HttpClient) {

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/swagger-ui")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
    }
}