package as.thomwilliam.utils.api.handlers.client

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.utils.api.handlers.conf.UnauthenticatedEndpointConfiguration
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test;

@MicronautTest
class UnauthenticatedLowLevelClientTest {

    @Test
    void test1() {
        when:
        UnauthenticatedEndpointConfiguration conf = new UnauthenticatedEndpointConfiguration(
            new UrlEntry(addr: "http://d238-maestro-api.azurewebsites.net", path: "/status/status")
        )

        UnauthenticatedLowLevelClient client = new UnauthenticatedLowLevelClient(conf)
        HttpResponse response

        try {
            response = client.performGet().blockingFirst()
        } catch (HttpClientResponseException exception) {
            response = exception.response
        }

        then:
        HttpStatus.OK == response.getStatus()
        Optional<Map> content = response.getBody(Map.class)
        content.isPresent()
        content.get()
    }
}
