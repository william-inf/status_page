package as.thomwilliam.endpoints.handlers.client

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.endpoints.handlers.conf.UnauthenticatedEndpointConfiguration
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test;

@MicronautTest
class UnauthenticatedLowLevelClientTest {

    @Test
    void test1() {
        def conf = new UnauthenticatedEndpointConfiguration(
            new UrlEntry(addr: "http://d238-maestro-api.azurewebsites.net", path: "/status/status")
        )
        def client = new UnauthenticatedLowLevelClient(conf)
        def response = client.performGet()

    }
}
