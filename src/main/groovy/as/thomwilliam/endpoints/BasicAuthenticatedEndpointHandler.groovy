package as.thomwilliam.endpoints

import as.thomwilliam.conf.UrlEntry

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
