package mattframpton.endclothing_mattframpton;

import android.support.test.runner.AndroidJUnitRunner;

import com.squareup.rx2.idler.Rx2Idler;

import io.reactivex.plugins.RxJavaPlugins;

public final class RxTestRunner extends AndroidJUnitRunner {
	@Override public void onStart() {
		RxJavaPlugins.setInitComputationSchedulerHandler(
				Rx2Idler.create("RxJava 2.x Computation Scheduler"));

		super.onStart();
	}
}