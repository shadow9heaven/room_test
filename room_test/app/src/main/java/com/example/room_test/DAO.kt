package com.example.room_test

import androidx.room.*

interface DAO {

    @Dao
    interface RoomDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(item: RoomEntity): Long

        @Insert
        fun insertAll(item: RoomEntity)

        @Query("SELECT * FROM room_entity WHERE name LIKE :name")
        fun findByName(name: String): RoomEntity


        @Query("SELECT * FROM room_entity")
        fun getAll(): List<RoomEntity>

        @Delete
        fun delete(item: RoomEntity)

        @Update
        fun update(item: RoomEntity)
    }
}