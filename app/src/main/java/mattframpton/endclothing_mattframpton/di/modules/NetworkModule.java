package mattframpton.endclothing_mattframpton.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
public class NetworkModule {

	@Singleton
	@Provides
	public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
		return new OkHttpClient.Builder()
				.addInterceptor(httpLoggingInterceptor)
				.build();
	}

	@Singleton
	@Provides
	public HttpLoggingInterceptor httpLoggingInterceptor(){
		return new HttpLoggingInterceptor(
				new HttpLoggingInterceptor.Logger() {
					@Override
					public void log(String message) {
						Timber.i(message);
					}
				});
	}
}
