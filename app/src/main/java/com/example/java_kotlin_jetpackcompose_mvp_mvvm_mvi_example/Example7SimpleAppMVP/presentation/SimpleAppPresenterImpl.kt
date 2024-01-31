package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.presentation

import android.util.Log
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.model.SaveUserNameParam
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.model.UserName
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.usecases.GetUserNameUseCase
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example7SimpleAppMVP.domain.usecases.SaveUserNameUseCase

// Теперь нужно преврать вьюМодель в презентер. Сам класс переименовываем в SimpleAppPresenterImpl
// Наследоваться от вьюМодели уже не нужно, вместо нее наследуемся от интерфейса презентера
class SimpleAppPresenterImpl (
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val view: SimpleAppView // принимаем на вход SimpleAppView
): SimpleAppPresenter {

    init {
        Log.d("MyLog", "ViewModel created")
    }

    // здесь добавляем override
    override fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
//        liveData.value = "Save result = $resultData" // лайфДату уже не используем
        view.showResult("Save result = $resultData") // Вместо этого вызваем у view .showResult() и закидываем туда  "Save result = $resultData"
    }

    // и здесь добавляем override
    override fun load() {
        val userName: UserName = getUserNameUseCase.execute()
//        liveData.value = "${userName.firstName} ${userName.lastName}" // Здесь делаем тоже самое
        view.showResult("${userName.firstName} ${userName.lastName}")
    }

    // В результате мы имеем публичные методы, которые можем вызвать активити (View)
    // И здесь же мы можем вызвать у View какие то доступные методы т.е. можем показать результат

}