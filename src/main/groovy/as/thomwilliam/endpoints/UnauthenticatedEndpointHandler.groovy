package as.thomwilliam.endpoints

import as.thomwilliam.conf.UrlEntry

class UnauthenticatedEndpointHandler implements EndpointHandler {

    @Override
    Map callEndpoint(UrlEntry urlEntry) {
        return null
    }

    @Override
    EndpointAuthenticationType getEndpointType() {
        return EndpointAuthenticationType.Unauthenticated
    }

}
