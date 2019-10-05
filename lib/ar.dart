import 'package:flutter/material.dart';

class AR extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('AR View'),
      ),
      body: Center(
        child: UiKitView(viewType: 'NativeView'),
      ),
    );
  }
}