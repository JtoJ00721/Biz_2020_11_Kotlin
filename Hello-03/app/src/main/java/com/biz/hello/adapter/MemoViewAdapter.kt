package com.biz.hello.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.biz.hello.R
import com.biz.hello.model.MemoVO

class MemoViewAdapter(var context : Context, var memoList : MutableList<MemoVO>) :
            RecyclerView.Adapter<MemoViewAdapter.MemoHolder?>() {

    // 생성자를 클래스 생성자(first Constructor)로 선언하면
    // 별도로 private 변수를 선언하지 않아도 된다
    // 자동으로 생성이 되기 때문에
    // 그리고 이 변수를 클래스 내에서 사용할때에는 null 값을 체크할 필요가 없어진다.
    // private var memoList : MutableList<MemoVO>

    fun setList(memoList: MutableList<MemoVO>) {
        this.memoList = memoList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoHolder {

        // layout/*.xml 파일을 읽어서 화면의
        // 일부 컴포넌트(View)에 부착하여 사용하기 위한 조치
        val view : View = LayoutInflater
                        .from(context)
                        .inflate(R.layout.memo_item, parent, false)

        // return new MemoHolder(view) : java
        // MemoHolder 클래스에 layout view를 주입하고 객체로 생성하여 return
        return MemoHolder(view)

    }

    // 생성된 Holder를 list의 item 개수만큼 복제하여 Holder 들을 생성한다.
    // 이 메서드는 list의 item개수만큼 반복실행이 되면서 Holder 들을 생성하고 RecyclerView에 보여지도록 한다.
    // 단 한번에 실행되는 회수는 데이터개수가 아니고 한 화면에 보여지는 리스트만큼만 실행되고 기다린다.
    override fun onBindViewHolder(holder: MemoHolder, position: Int) {
        //holder.txtDate.setDate(memolist.get(position).getDate())
        holder.txtDate.text = memoList[position]?.date.toString()
        holder.txtTime.text = memoList[position]?.time.toString()
        holder.txtMemo.text = memoList[position]?.memo.toString()
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    inner class MemoHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var txtDate : TextView = itemView.findViewById(R.id.text_date)
        var txtTime : TextView = itemView.findViewById(R.id.text_time)
        var txtMemo : TextView = itemView.findViewById(R.id.txt_memo_item)
    }
}