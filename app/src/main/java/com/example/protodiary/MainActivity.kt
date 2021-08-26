package com.example.protodiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.accessibility.AccessibilityManager
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_record.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, CustomDialogInterface{

    //
    private lateinit var recordFragment : RecordFragment
    private lateinit var calenderFragment: CalenderFragment
    private lateinit var analysisFragment: AnalysisFragment
    private lateinit var editFragment: EditFragment
    private lateinit var detailFragment: DetailFragment

    companion object{
        const val TAG: String = "로그"
    }

    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //레이아웃과 연결
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreat() called")

        bottom_nav.setOnNavigationItemSelectedListener(this)

        recordFragment = RecordFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frag_frame, recordFragment).commit()



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "MainActivity - onNavigationItemSelectd() called")

        when(item.itemId){
            R.id.menu_record ->{
                recordFragment = RecordFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frag_frame, recordFragment).commit()
            }
            R.id.menu_calender ->{
                calenderFragment = CalenderFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frag_frame, calenderFragment).commit()
            }
            R.id.menu_analysis->{
                analysisFragment = AnalysisFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frag_frame, analysisFragment).commit()
            }
            R.id.menu_edit-> {
                editFragment = EditFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frag_frame, editFragment).commit()
            }
        }

        return true
    }

    public fun onDialogClicked(view: View){

        val myCustomDialog = CustomDialog(this, this)
        myCustomDialog.show()
    }

    override fun onOption1BtnClicked() {
        Toast.makeText(this, "Option1", Toast.LENGTH_LONG).show()
        detailFragment = DetailFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.frag_frame, detailFragment).commit()
    }

    override fun onOption2BtnClicked() {
        Toast.makeText(this, "Option2", Toast.LENGTH_LONG).show()
        supportFragmentManager.beginTransaction().replace(R.id.frag_frame, detailFragment).commit()
    }

    override fun onOption3BtnClicked() {
        Toast.makeText(this, "Option3", Toast.LENGTH_LONG).show()
        supportFragmentManager.beginTransaction().replace(R.id.frag_frame, detailFragment).commit()
    }

    fun onCommitButtonClicked(){
        recordFragment = RecordFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.frag_frame, recordFragment).commit()
    }
}