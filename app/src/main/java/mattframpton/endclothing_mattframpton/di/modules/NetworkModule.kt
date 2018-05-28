package mattframpton.endclothing_mattframpton.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    @Singleton
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(
                HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
    }
}
