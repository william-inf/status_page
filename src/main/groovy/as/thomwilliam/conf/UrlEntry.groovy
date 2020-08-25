package as.thomwilliam.conf

import as.thomwilliam.utils.api.EndpointAuthenticationType

class UrlEntry {
    String addr
    String name
    String path
    EndpointAuthenticationType type

    Map toMap() {
        return [
            addr: addr,
            name: name,
            path: path,
            type: type
        ]
    }
}