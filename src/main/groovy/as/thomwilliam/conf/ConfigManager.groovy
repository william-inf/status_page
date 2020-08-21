package as.thomwilliam.conf

import javax.inject.Singleton;

@Singleton
class ConfigManager {

    synchronized private ConfigProperties _properties

    void initialize(ConfigProperties properties) {
        _properties = properties
    }

    List<UrlEntry> getUrls() {
        return _properties.urls
    }

    synchronized void persistConfig() {

    }

}
