package as.thomwilliam.endpoints.handlers

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.endpoints.EndpointAuthenticationType

interface EndpointHandler {

    Map callEndpoint(final UrlEntry urlEntry)

    EndpointAuthenticationType getEndpointType()

}
