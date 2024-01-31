package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example9SimpleApp_MVI.presentation

interface SimpleAppMVI_Event

class SaveEvent(val text: String) : SimpleAppMVI_Event
class LoadEvent() : SimpleAppMVI_Event