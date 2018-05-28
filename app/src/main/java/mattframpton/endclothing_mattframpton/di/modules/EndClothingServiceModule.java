package mattframpton.endclothing_mattframpton.di.modules;

import dagger.Module;
import dagger.Provides;
import mattframpton.endclothing_mattframpton.network.EndClothingService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class EndClothingServiceModule {

	@Provides
	public EndClothingService endClothingService(Retrofit retrofit){
		return retrofit.create(EndClothingService.class);
	}

	@Provides
	public Retrofit retrofit(OkHttpClient okHttpClient){
		return new Retrofit.Builder()
				.baseUrl("https://www.endclothing.com")
				.client(okHttpClient)
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}
}
