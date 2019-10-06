package com.example.flutter_nasa
import android.content.Context
import android.graphics.Color
import android.view.View
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class NativeViewFactory : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, id: Int, o: Any?): PlatformView {
        return NativeView(context, id)
    }
}

class NativeView internal constructor(context: Context, id: Int) : PlatformView {
    private val view: View = View(context)

    override fun getView(): View {
        view.setBackgroundColor(Color.RED)
        return view
    }

    override fun dispose() {
        // TODO dispose actions if needed
    }
}