package com.rnsberid.sberid

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.ReactStylesDiffMap
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.rnsberid.R
import sberid.sdk.auth.view.SberIDButton
import android.view.Gravity

// class MyView(context: Context) : FrameLayout(context) {
//     private var mRequestedLayout = false
//     public var button = LayoutInflater.from(context).inflate(R.layout.sber_id_white_login_button, null) as SberIDButton

//     init {
//        // button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//         this.addView(button)
//         val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
//         params.gravity = Gravity.CENTER
//         this.layoutParams = params
//     }

// //    override fun requestLayout() {
// //        super.requestLayout()
// //        if (!mRequestedLayout) {
// //            mRequestedLayout = true
// //            post {
// //                mRequestedLayout = false
// //                layout(left, top, right, bottom)
// //                onLayout(true, left, top, right, bottom)
// //            }
// //        }
// //    }
// }

class SberIDButtonManager : ViewGroupManager<ViewGroup>() {
    override fun getName() = "SberIDButton"

//    override fun receiveCommand(root: MyView, commandId: String?, args: ReadableArray?) {
//        if (commandId == "create") {
//            val text = root.button.findViewById<AppCompatTextView>(R.id.sber_id_login_text_view)
//            text.requestLayout()
//            text.invalidate()
//            text.text = "Hi"
//            //text.layoutParams = FrameLayout.LayoutParams(200, 400)
//            text.minWidth = 160
//            text.width = 70
//
////            root.button.layoutParams.height = 41
////            root.button.layoutParams.height = 400
////            root.button.requestLayout()
////            root.button.invalidate()
//        //     root.removeAllViews()
//        //     val button = TextView(root.context)
//        //     button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
//        //     button.text = "Hello !"
//        //     root.addView(button, 40, 100)
//        //     root.refreshDrawableState()
//           // root.invalidate()
//           // root.requestLayout()
//        }
//    }\

    override fun createViewInstance(reactContext: ThemedReactContext): ViewGroup {
        val layout = LinearLayout(reactContext)
        LayoutInflater.from(reactContext).inflate(R.layout.sber_id_white_login_button, layout)
        return layout
    }
}