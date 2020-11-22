package com.assessment.nytimes.constants

import androidx.annotation.StringDef

object AppConstants{

    annotation class ApiConfiguration{
        companion object{
            const val URL = "https://api.nytimes.com/svc/"
            const val API_KEY_MOST_POPULAR_ARTICLES_VIEWED = "Jt3u9XiBK0TmBuSGCBrxjvXwCOAhu1pE"
        }
    }

    @StringDef(ApiPath.MOST_POPULAR_ARTICLES_VIEWED)
    annotation class ApiPath{
        companion object{
            const val MOST_POPULAR_ARTICLES_VIEWED = "mostpopular/v2/viewed/{period}.json"
        }
    }
}
