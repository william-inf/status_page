package as.thomwilliam.endpoints.handlers

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.endpoints.EndpointAuthenticationType
import groovy.util.logging.Slf4j

@Slf4j
class EndpointHandlerFactory {

    static private final Map<EndpointAuthenticationType, EndpointHandler> _endpointHandlers = [:]

    static {
        registerHandler(new UnauthenticatedEndpointHandler())
        registerHandler(new BasicAuthenticatedEndpointHandler())
    }

    Map call(final UrlEntry entry) throws RuntimeException {
        log.debug("Calling URL entrypoint - ${entry.addr}")
        EndpointHandler handler = _endpointHandlers[entry.type]

        if (!handler) {
            throw new RuntimeException("Missing handler for endpoint authentication type - ${entry.type}")
        }

        return handler.callEndpoint(entry)
    }

    private static void registerHandler(EndpointHandler handler) {
        def endpointType = handler.getEndpointType()
        if (!endpointType) {
            throw new RuntimeException("No endpoint handler registered for ${endpointType}")
        }

        _endpointHandlers[endpointType] = handler
    }
}
