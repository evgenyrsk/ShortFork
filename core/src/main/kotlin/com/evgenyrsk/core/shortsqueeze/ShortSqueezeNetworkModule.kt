package com.evgenyrsk.core.shortsqueeze

import com.evgenyrsk.core.data.BaseUrls
import com.evgenyrsk.core.shortsqueeze.data.ShortSqueezeApi
import com.evgenyrsk.core.shortsqueeze.data.ShortSqueezeHtmlDocumentParser
import com.evgenyrsk.core.shortsqueeze.data.ShortSqueezeNetworkDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Evgeny Rasskazov
 */
@Module
class ShortSqueezeNetworkModule {

    @Provides
    @Singleton
    fun provideShortSqueezeApi(responseParser: ShortSqueezeHtmlDocumentParser): ShortSqueezeApi {
        return ShortSqueezeNetworkDataSource(BaseUrls.BASE_SHORT_SQUEEZE_URL, responseParser)
    }
}
