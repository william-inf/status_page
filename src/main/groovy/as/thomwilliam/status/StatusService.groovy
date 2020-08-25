package as.thomwilliam.status

import as.thomwilliam.conf.UrlEntry
import as.thomwilliam.conf.UrlStatusResult
import as.thomwilliam.utils.api.handlers.EndpointHandler
import as.thomwilliam.utils.api.handlers.EndpointHandlerFactory
import groovy.util.logging.Slf4j
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers

import javax.inject.Inject
import javax.inject.Singleton
import java.util.function.Supplier

@Slf4j
@Singleton
class StatusService {

    @Inject EndpointHandlerFactory handlerFactory

    Maybe<UrlStatusResult> fetchResult(final UrlEntry entry) {
        log.info("Looking up status result for url ${entry.name}")
        return Maybe.just(entry)
            .subscribeOn(Schedulers.io())
            .map(it -> callUrlEntry(it).get())
            .onErrorComplete()
    }

    private Supplier<UrlStatusResult> callUrlEntry(UrlEntry entry) {
        EndpointHandler handler = handlerFactory.forType(entry.type)

        return () -> {
            handler.callEndpoint(entry)
        }
    }
}
