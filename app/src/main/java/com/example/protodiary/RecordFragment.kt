package com.example.protodiary

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_record.*
import kotlinx.android.synthetic.main.fragment_record.view.*

class RecordFragment : Fragment() {

    lateinit var  mainActivity: MainActivity
    var state = 1

    companion object{
        const val TAG : String = "로그"

        fun newInstance() : RecordFragment{
            return RecordFragment()
        }
    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "RecordFragment - oncreate() called")

    }

    //프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    //뷰가 생성되었을때
    //프레그먼트와 레이아웃을 연결 시켜주는 부분임.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "RecordFragment - oncreateview() called")

        val view = inflater.inflate(R.layout.fragment_record, container, false)

        view.view_cross.setOnTouchListener { v, e ->
            var centerX = view.view_cross.width / 2
            var centerY = view.view_cross.height / 2

            var pointX = e.x - centerX
            var pointY = e.y - centerY

            //1사분면 +- 2사분면 -- 3사분면 -+ 4사분면 ++

            if(pointX > 0){
                if(pointY > 0){

                    //4사분면

                    mainActivity.onDialogClicked(view)
                }
                else{
                    //1사분면
                    mainActivity.onDialogClicked(view)
                }
            }
            else{
                if(pointY > 0){
                    //3사분면
                    mainActivity.onDialogClicked(view)
                }
                else{
                    //2사분면
                    mainActivity.onDialogClicked(view)
                }
            }

            true
        }

        return view
    }

}