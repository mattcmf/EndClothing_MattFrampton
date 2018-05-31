package mattframpton.endclothing_mattframpton

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import mattframpton.endclothing_mattframpton.view.ShopFrontActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShopFrontActivityTest {
    private var robot = ShopFrontRobot()

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(
            ShopFrontActivity::class.java)

    @Test
    fun shopFrontActivityTest() {
        robot.verifyProductAtPosition(1, "Test Shirt", "£199")

    }
}
