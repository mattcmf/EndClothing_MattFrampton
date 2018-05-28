package mattframpton.endclothing_mattframpton.di.application;

import android.app.Application;

import mattframpton.endclothing_mattframpton.di.components.DaggerEndClothingApplicationComponent;
import mattframpton.endclothing_mattframpton.di.components.EndClothingApplicationComponent;
import mattframpton.endclothing_mattframpton.network.EndClothingService;

public class EndClothingApplication extends Application {
	private EndClothingService client;

	@Override
	public void onCreate() {
		injectDependencies();
		super.onCreate();
	}

	private void injectDependencies() {
		EndClothingApplicationComponent component = DaggerEndClothingApplicationComponent.builder().build();
		client = component.getEndClothingService();
	}

	public EndClothingService getEndClothingService(){
		return client;
	}
}
