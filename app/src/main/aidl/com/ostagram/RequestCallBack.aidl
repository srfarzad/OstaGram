// RequestCallBack.aidl
package com.ostagram;

// Declare any non-default types here with import statements

interface RequestCallBack {
   void onSuccess(String success);
   void onError(String error);
}
