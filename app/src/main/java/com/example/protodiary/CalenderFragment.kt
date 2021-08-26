package com.example.protodiary

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class CalenderFragment : Fragment() {

    companion object{
        const val TAG : String = "로그"

        fun newInstance() : CalenderFragment{
            return CalenderFragment()
        }
    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "CalenderFragment - oncreate() called")
    }

    //프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "CalenderFragment - onattach() called")
    }

    //뷰가 생성되었을때
    //프레그먼트와 레이아웃을 연결 시켜주는 부분임.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "CalenderFragment - oncreateview() called")

        val view = inflater.inflate(R.layout.fragment_calender, container, false)

        return view
    }
}