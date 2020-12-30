package com.example.taskmanagerkotlin.data

interface IRepository<T> {
    fun get(id:Long):T
    fun getList() : List<T>
    fun insert(t:T)
    fun delete(t:T)
    fun update(t:T)
}