package mattframpton.endclothing_mattframpton.di.modules

import IdlingResources
import dagger.Module
import dagger.Provides
import mattframpton.endclothing_mattframpton.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        if (BuildConfig.DEBUG) {
            IdlingResources.registerOkHttp(client)
        }
        return client
    }

    @Singleton
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(
                HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
    }
}
