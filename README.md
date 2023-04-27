## Micronaut OpenAPI upgrade stops generating swaggerUI

ref issue: [micronaut-openapi/issues/994](https://github.com/micronaut-projects/micronaut-openapi/issues/994

On upgrade from `io.micronaut.openapi:micronaut-openapi:4.8.6` to `io.micronaut.openapi:micronaut-openapi:4.8.7`, 
swagger-ui is no longer generated. 

## Steps to recreate

1. Clone this project


2. Build

   `./gradlew clean build`

    * Notice the console output confirms generation of both swagger and views/swagger-ui:

```
➜  micronautguide git:(main) ./gradlew clean build

> Task :kaptKotlin
Note: Generating OpenAPI Documentation
Note: Generating OpenAPI Documentation
Note: Writing OpenAPI file to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/hello-world.yml
Note: Writing OpenAPI views to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views
Note: Writing OpenAPI View to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views/swagger-ui/index.html
Note: Writing OpenAPI View Resources to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views/swagger-ui/res/res/swagger-ui.css
Note: Writing OpenAPI View Resources to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views/swagger-ui/res/res/favicon-16x16.png
Note: Writing OpenAPI View Resources to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views/swagger-ui/res/res/favicon-32x32.png
Note: Writing OpenAPI View Resources to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views/swagger-ui/res/res/swagger-ui-bundle.js
Note: Writing OpenAPI View Resources to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views/swagger-ui/res/res/swagger-ui-standalone-preset.js
Note: Writing OpenAPI View Resources to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views/swagger-ui/res/classic.css

```

3. Run

    `./gradlew run`


4. Visit http://localhost:8080/swagger-ui/index.html 
    
    * Swagger UI is available 



5. Stop the server 


6. In `build.gradle.kts`, upgrade `io.micronaut.openapi:micronaut-openapi` from `4.8.6` to `4.8.7`


7. Build again

 * Note that views/swagger-ui is not generated

```
➜  micronautguide git:(main) ✗ ./gradlew clean build

> Task :kaptKotlin
[WARN] Issue detected with io.micronaut.annotation.processing.TypeElementVisitorProcessor. Expected 1 originating source file when generating /home/carolyn/code/micronaut/micronautguide/build/generated/source/kapt/main/dummy, but detected 0: [].
Note: Generating OpenAPI Documentation
Note: Generating OpenAPI Documentation
Note: Writing OpenAPI file to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/hello-world.yml
Note: Writing OpenAPI views to destination: /home/carolyn/code/micronaut/micronautguide/build/tmp/kapt3/classes/main/META-INF/swagger/views
Note: Creating bean classes for 2 type elements

```

 * Micronaut test `SwaggerUiTest` fails with `io.micronaut.http.client.exceptions.HttpClientResponseException: Not Found`

9. Run again

   `./gradlew run`



4. Visit http://localhost:8080/swagger-ui/index.html

   * Swagger UI is not available :

         ```{"message":"Not Found","_links":{"self":{"href":"/swagger-ui/index.html","templated":false}},"_embedded":{"errors":[{"message":"Page Not Found"}]}}```
