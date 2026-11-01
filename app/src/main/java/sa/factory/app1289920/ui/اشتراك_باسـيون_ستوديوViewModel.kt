package sa.factory.app1289920.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sa.factory.app1289920.data.اشتراك_باسـيون_ستوديوRepository
import sa.factory.app1289920.model.اشتراك_باسـيون_ستوديو
import sa.factory.app1289920.model.ملاحظة_تواصل_مع_مشتركة_باسـيون
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class اشتراك_باسـيون_ستوديوViewModel(
    private val repository: اشتراك_باسـيون_ستوديوRepository
) : ViewModel() {
    val catalog: StateFlow<List<ملاحظة_تواصل_مع_مشتركة_باسـيون>> = repository.getAvailableCatalog()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeRequest: StateFlow<اشتراك_باسـيون_ستوديو?> = repository.getActiveRequest()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun submitNewOrder(request: اشتراك_باسـيون_ستوديو) {
        viewModelScope.launch {
            repository.submitRequest(request)
        }
    }
}
