package mattframpton.endclothing_mattframpton.di.components

import dagger.Component
import mattframpton.endclothing_mattframpton.di.modules.EndClothingServiceModule
import mattframpton.endclothing_mattframpton.di.modules.NetworkModule
import mattframpton.endclothing_mattframpton.network.EndClothingService
import javax.inject.Singleton

@Singleton
@Component(modules = [(EndClothingServiceModule::class), (NetworkModule::class)])
interface EndClothingApplicationComponent {

    val endClothingService: EndClothingService
}
