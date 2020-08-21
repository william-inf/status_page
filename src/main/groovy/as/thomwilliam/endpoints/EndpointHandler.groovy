package as.thomwilliam.endpoints

import as.thomwilliam.conf.UrlEntry
import groovy.util.logging.Slf4j

@Slf4j
interface EndpointHandler {

    Map callEndpoint(final UrlEntry urlEntry)

    EndpointAuthenticationType getEndpointType()

}
