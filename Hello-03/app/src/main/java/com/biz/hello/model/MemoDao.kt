package com.biz.hello.model

import androidx.lifecycle.LiveData
import androidx.room.*

interface MemoDao {
    
    @Query("SELECT * FROM tbl_memo")
    open fun selectAll() : LiveData<MutableList<MemoVO>>

    @Query("SELECT * FROM tbl_memo WHERE id = :id")
    open fun findById(id : Long) : MemoVO

    // OnConflictStrategy.REPLACE
    // 새로운 데이터이면 insert를 수행하고 아니면 update를 수행하라
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    open fun save(memoVO: MemoVO)

    @Update
    open fun update(memoVO: MemoVO)

    @Query("DELETE FROM tbl_memo WHERE id = :id")
    open fun delete(id : Long)

}