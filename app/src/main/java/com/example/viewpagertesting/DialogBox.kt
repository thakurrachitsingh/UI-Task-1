package com.example.viewpagertesting

import android.annotation.SuppressLint
import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.method.MovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.toSpannable
import androidx.fragment.app.DialogFragment

class DialogBox : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val crrView =  inflater.inflate(R.layout.fragment_dialog_box, container, false)
        val termsAndCondition = "By entering my mobile number and confirming I agree to opt in to receive SMS messages from Haverdash Updates with account alerts and recurring promotional offers using an automatic telephone dialing system and I understand that I am not required to opt in as a condition of purchasing any property, goods, or services. Message frequency varies. Text HELP to 64243 for help, Text STOP to 64243 to end. Msg&amp;Data Rates May Apply. Click to read Terms and Conditions, Privacy Policy."
        val spannableString = SpannableString(termsAndCondition)
        val tNC: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                println(spannableString)

            }
        }

        val privacyPolicy: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                println(spannableString)

            }
        }

        spannableString.setSpan(tNC, 445, 465, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(getResources().getColor(R.color.requiredBlack)), 445, 465, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(BackgroundColorSpan(getResources().getColor(R.color.white)), 445, 465, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(privacyPolicy, 467, 482, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(getResources().getColor(R.color.requiredBlack)), 467, 482, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(BackgroundColorSpan(getResources().getColor(R.color.white)), 467, 482, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        val textView = crrView.findViewById<TextView>(R.id.termsAndCondition)
        textView.setText(spannableString)
        textView.movementMethod = LinkMovementMethod.getInstance()
        return crrView
    }


}