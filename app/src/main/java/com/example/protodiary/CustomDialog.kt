package com.example.protodiary

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.dialog_custom.*

class CustomDialog(context: Context, customDialogInterface: CustomDialogInterface): Dialog(context), View.OnClickListener {

    val TAG: String = "로그"

    private var customDialogInterface: CustomDialogInterface? = null

    //인터페이스 연결
    init{
        this.customDialogInterface = customDialogInterface
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.dialog_custom)

        //배경 투명
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btn_option1.setOnClickListener(this)
        btn_option2.setOnClickListener(this)
        btn_option3.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            btn_option1 ->{
                this.customDialogInterface?.onOption1BtnClicked()
                //dismiss()
            }
            btn_option2 ->{
                this.customDialogInterface?.onOption2BtnClicked()
                //dismiss()
            }
            btn_option3 ->{
                this.customDialogInterface?.onOption3BtnClicked()
                //dismiss()
            }
        }
    }

}