import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class AR extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('AR View'),
      ),
      body: Center(
        child: defaultTargetPlatform == TargetPlatform.android ?
          AndroidView(viewType: 'NativeView') :
          UiKitView(viewType: 'NativeView')
      ),
    );
  }
}