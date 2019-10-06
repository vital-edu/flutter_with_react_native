package com.example.flutter_nasa
import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage
import com.viromedia.bridge.ReactViroPackage
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class NativeViewFactory(val application: Application, val activity: Activity) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, id: Int, o: Any?): PlatformView {
        return NativeView(context, id, application, activity)
    }
}

class NativeView internal constructor(val context: Context, id: Int, val application: Application, val activity: Activity) : PlatformView {
    private var mReactRootView: ReactRootView? = null
    private var mReactInstanceManager: ReactInstanceManager? = null

    override fun getView(): View {

        mReactRootView = ReactRootView(context)
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(application)
                .setCurrentActivity(activity)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(MainReactPackage())
                .addPackage(ReactViroPackage(ReactViroPackage.ViroPlatform.AR))
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build()
        // The string here (e.g. "MyReactNativeApp") has to match
        // the string in AppRegistry.registerComponent() in index.js
        mReactRootView!!.startReactApplication(mReactInstanceManager, "HelloWorldScene", null)

        return mReactRootView as ReactRootView
    }

    override fun dispose() {
        // TODO dispose actions if needed
    }
}