package mattframpton.endclothing_mattframpton.di.components;

import javax.inject.Singleton;

import dagger.Component;
import mattframpton.endclothing_mattframpton.di.modules.EndClothingServiceModule;
import mattframpton.endclothing_mattframpton.di.modules.NetworkModule;
import mattframpton.endclothing_mattframpton.network.EndClothingService;

@Singleton
@Component (modules = {EndClothingServiceModule.class, NetworkModule.class})
public interface EndClothingApplicationComponent {

	EndClothingService getEndClothingService();
}
