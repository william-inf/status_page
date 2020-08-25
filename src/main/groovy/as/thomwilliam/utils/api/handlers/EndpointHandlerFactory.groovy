package as.thomwilliam.utils.api.handlers

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.utils.api.EndpointAuthenticationType
import groovy.util.logging.Slf4j

@Slf4j
class EndpointHandlerFactory {

    static private final Map<EndpointAuthenticationType, EndpointHandler> _endpointHandlers = [:]

    static {
        registerHandler(new UnauthenticatedEndpointHandler())
        registerHandler(new BasicAuthenticatedEndpointHandler())
    }

    static EndpointHandler forType(final EndpointAuthenticationType type) throws RuntimeException {
        log.debug("Retrieving handler for type ${type}")
        EndpointHandler handler = _endpointHandlers[type]

        if (!handler) {
            throw new RuntimeException("Missing handler for endpoint authentication type - ${type}")
        }

        return handler
    }

    private static void registerHandler(EndpointHandler handler) {
        def endpointType = handler.getEndpointType()
        if (!endpointType) {
            throw new RuntimeException("No endpoint handler registered for ${endpointType}")
        }

        _endpointHandlers[endpointType] = handler
    }
}
