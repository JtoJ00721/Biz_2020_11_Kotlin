package com.biz.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.biz.hello.adapter.MemoViewAdapter
import com.biz.hello.adapter.MemoViewModel
import com.biz.hello.model.MemoVO
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

/**
 * MainActivity class
 * Android 의 진입점 클래스
 * AppCompatActivity 클래스를 상속받아 사용
 * Android의 App이 실행하는데 필요한 기본 속성들이 정의 되어 있다.
 */
class MainActivity : AppCompatActivity() {

    // lateinit : 지금은 변수를 선언만 하지만
    // 이 클래스 어딘가에서 반드시 초기화를 하겠다
    private lateinit var txtMemoInput : TextInputEditText
    private lateinit var btnSave : Button
    private lateinit var memoViewModel : MemoViewModel
    private lateinit var  memoAdapter : MemoViewAdapter


    /**
     * onCreate() method를 override하여 사용
     * App이 화면에 떠올라서 작동되느 순간 호출하는 최초의 method
     * activity_main.xml파일에 설정한 코드를 읽어서
     * 화면에 컴포넌트를 구성하고 layout을 설정하는 일을 한다.
     * 
     * 만약 버튼에 event를 설정하거나 하는 코드가 필요하면
     * 여기에 그 코드를 작성한다.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // activity_main.xml 파일을 읽어서 화면을 그려라
        setContentView(R.layout.activity_main)

        txtMemoInput = findViewById(R.id.txt_memo)
        btnSave = findViewById(R.id.btn_save)
        memoViewModel = MemoViewModel(this.application)

        // 입력도중 키보드의 Send 버튼을 클릭했을때 반응할 event
        txtMemoInput.setOnEditorActionListener {view,actionId,event->

            return@setOnEditorActionListener when(actionId) {
                EditorInfo.IME_ACTION_SEND ->{
                    // Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()

                    val text = txtMemoInput.text.toString()
                    val sd = SimpleDateFormat("yyyy-MM-dd")
                    val st = SimpleDateFormat("HH:mm:ss")
                    val date = Date(System.currentTimeMillis())

                    val memoVO : MemoVO = MemoVO()
                    memoViewModel.insert(memoVO)

                    true
                } else -> false
        }
        }

        btnSave.setOnClickListener { view ->
            Log.d("MAIN", "btnSave") // debug

            val text : String = txtMemoInput.text.toString()
            // 스넥바는 키보드 위 다른 공간에 나타나고
            // 토스트는 키보드 따위 하찮은것 쿨하게 씹고 새치기질을 하는 새끼이다
            // Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }

        val memoList : MutableList<MemoVO> = mutableListOf()
        memoAdapter = MemoViewAdapter(this, memoList)

        //=========================================
        // recyclerView와 데이터를 바인딩하는 코드
        //=========================================
        // 내용이 없는 mutableList 선언 및 초기화, null 값이 되지 않도록 하기 위한 조치

        memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)
                memoViewModel.selectAll().observe(this,{
                    list ->
                    if(list != null) {
                        memoAdapter.setList(list)
                    }
                    memoAdapter.notifyDataSetChanged()
                })

//        memoViewModel
//            .selectAll()?
//            .observe(this, {voList->
//            if()
//
//        })
            .toMutableList() //mutableListOf<MemoVO>()

        /*
        for(i in 0..30) {

            var memoVO : MemoVO = MemoVO()
            memoVO.memo = i.toString()

            val sd = SimpleDateFormat("yyyy-MM-dd")
            val st = SimpleDateFormat("HH:mm:ss")
            val date = Date(System.currentTimeMillis())

            memoVO.date = sd.format(date).toString()
            memoVO.time = st.format(date).toString()

            memoList.add(memoVO)
        }
         */


        val rView : RecyclerView = findViewById(R.id.data_list_view)
        rView.adapter = memoAdapter

        val layoutManager = LinearLayoutManager(this)
        rView.layoutManager = layoutManager

    }
}