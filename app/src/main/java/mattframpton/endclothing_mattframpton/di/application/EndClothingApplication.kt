package mattframpton.endclothing_mattframpton.di.application

import android.app.Application
import mattframpton.endclothing_mattframpton.di.components.DaggerEndClothingApplicationComponent

import mattframpton.endclothing_mattframpton.network.EndClothingService

class EndClothingApplication : Application() {
    var endClothingService: EndClothingService? = null
        private set

    override fun onCreate() {
        injectDependencies()
        super.onCreate()
    }

    private fun injectDependencies() {
        val component = DaggerEndClothingApplicationComponent.builder().build()
        endClothingService = component.endClothingService
    }
}
