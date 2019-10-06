package com.example.flutter_nasa

import android.os.Bundle
import io.flutter.app.FlutterActivity
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val nativeViewFactory = NativeViewFactory(application, this)
    registrarFor("com.example.flutter_nasa")
            .platformViewRegistry()
            .registerViewFactory("NativeView", nativeViewFactory)
    GeneratedPluginRegistrant.registerWith(this)
  }
}
