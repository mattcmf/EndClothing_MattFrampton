package mattframpton.endclothing_mattframpton

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText

class ShopFrontRobot {
    fun verifyProductAtPosition(position: Int, productName: String,
                                productPriceString: String) {

        waitForInitialLoad()

        onView(RecyclerViewMatcher(R.id.productCataRecyclerView)
                .atPositionOnView(position, R.id.productName))
                .check(matches(withText(productName)))


        onView(RecyclerViewMatcher(R.id.productCataRecyclerView)
                .atPositionOnView(position, R.id.productPrice))
                .check(matches(withText(productPriceString)))
    }

    private fun waitForInitialLoad(){
        //TODO: Find better solution to this. As Okhttp and RxIdlers not working.
        Thread.sleep(2000)
    }
}
