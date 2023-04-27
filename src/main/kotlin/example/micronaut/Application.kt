package example.micronaut

import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "Hello World",
        description = "To demonstrate swagger-ui breaking on micronaut-openapi upgrade."
    )
)
class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            run(*args)
        }
    }
}

