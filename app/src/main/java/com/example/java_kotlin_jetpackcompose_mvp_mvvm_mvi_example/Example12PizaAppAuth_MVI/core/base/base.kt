package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example12PizaAppAuth_MVI.core.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow

interface EffectEvent
interface UnidirectionalViewModel<EVENT, STATE, EFFECT> {
    val uiState: StateFlow<STATE>
    val effect: StateFlow<EFFECT>
    fun event(event:EVENT)
    fun consume()
}


@Composable
fun <EVENT, STATE, EFFECT> UnidirectionalViewModel<EVENT, STATE, EFFECT>.useEffects(
    function: (value:EFFECT) -> Unit
) {
    val key by effect.collectAsStateWithLifecycle()

    DisposableEffect(key) {
        key?.let { localEffect -> function(localEffect) }
        onDispose {
            consume()
        }
    }
}
