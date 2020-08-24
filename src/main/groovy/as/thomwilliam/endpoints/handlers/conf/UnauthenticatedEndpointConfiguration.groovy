package as.thomwilliam.endpoints.handlers.conf

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.endpoints.handlers.conf.AbstractEndpointConfiguration


class UnauthenticatedEndpointConfiguration extends AbstractEndpointConfiguration {

    UnauthenticatedEndpointConfiguration(UrlEntry urlEntry) {
        super(urlEntry)
    }

}