package as.thomwilliam.status

import as.thomwilliam.conf.ConfigManager
import as.thomwilliam.utils.JSONUtils
import groovy.transform.CompileStatic
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.reactivex.Maybe

import javax.inject.Inject

@CompileStatic
@Controller("/status")
class StatusController {

    @Inject ConfigManager configManager

    @Get("/")
    @Produces(MediaType.TEXT_JSON)
    Maybe<String> index() {
        return Maybe.just(JSONUtils.toJson(configManager.urls))
    }


}
