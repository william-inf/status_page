package as.thomwilliam.endpoints.handlers.client

import as.thomwilliam.endpoints.handlers.conf.AbstractEndpointConfiguration
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.RxHttpClient
import io.reactivex.Flowable

class UnauthenticatedLowLevelClient {

    private RxHttpClient httpClient
    private AbstractEndpointConfiguration configuration

    UnauthenticatedLowLevelClient(AbstractEndpointConfiguration configuration) {
        this.httpClient = RxHttpClient.create(new URL(configuration.apiEndpoint))
        this.configuration = configuration
    }

    Flowable<HttpResponse<Map>> performGet() {
        HttpRequest<?> request = HttpRequest.GET(configuration.path)
        Flowable<HttpResponse<Map>> flowable = httpClient.exchange(request, Map.class)
        return flowable as Flowable<HttpResponse<Map>>
    }

}
