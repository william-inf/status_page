package as.thomwilliam.endpoints.handlers

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.endpoints.EndpointAuthenticationType

class BasicAuthenticatedEndpointHandler implements EndpointHandler {

    @Override
    Map callEndpoint(UrlEntry urlEntry) {
        return null
    }

    @Override
    EndpointAuthenticationType getEndpointType() {
        return EndpointAuthenticationType.Basic
    }

}
