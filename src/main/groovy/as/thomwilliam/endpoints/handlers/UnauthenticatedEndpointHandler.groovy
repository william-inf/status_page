package as.thomwilliam.endpoints.handlers

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.endpoints.EndpointAuthenticationType
import io.micronaut.http.client.RxHttpClient

class UnauthenticatedEndpointHandler implements EndpointHandler {

    RxHttpClient rxHttpClient

    @Override
    Map callEndpoint(UrlEntry urlEntry) {
        return null
    }

    @Override
    EndpointAuthenticationType getEndpointType() {
        return EndpointAuthenticationType.Unauthenticated
    }

}
