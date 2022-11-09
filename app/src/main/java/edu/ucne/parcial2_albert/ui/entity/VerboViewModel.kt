package edu.ucne.parcial2_albert.ui.entity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial2_albert.data.Repository.VerboApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class VerboViewModel @Inject constructor(
    private val verbosRepository: VerboApiRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(VerboState())
    val uiState: StateFlow<VerboState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                try {
                    it.copy(verbos = verbosRepository.getVerbos())
                }catch (ioe: IOException){
                    val mgs = ioe.message.toString()
                    it.copy(error = mgs)
                }
            }
        }
    }
}