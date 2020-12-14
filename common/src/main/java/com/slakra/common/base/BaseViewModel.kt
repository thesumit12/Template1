package com.slakra.common.base

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.slakra.common.model.EventIdentifier
import com.slakra.common.model.EventType
import com.slakra.common.utils.Event

/**
 * Base viewModel to be extended by all viewModels of application.
 * @author sumitlakra
 * @date 12/14/2020
 */
abstract class BaseViewModel: ViewModel() {

    val onEventReceived: Event<EventType> = Event()

    /**
     * Function to be used by child view models to trigger any event
     * @author sumitlakra
     * @date 06/01/2020
     */
    fun triggerEvent(type: EventIdentifier, dataObj: Any = "") {
        val eventType = EventType(type, dataObj)
        onEventReceived(eventType)
    }

    /**
     * define a property change callback which calls "callback " on change
     * @return Unit
     * @author sumitlakra
     * @date 06/01/2020
     */
    @Suppress("UNCHECKED_CAST")
    fun <T : Observable> T.addOnPropertyChanged(callback: (T) -> Unit) =
        object : Observable.OnPropertyChangedCallback() {
            @Suppress("UNCHECKED_CAST")
            override fun onPropertyChanged(observable: Observable?, i: Int) =
                callback(observable as T)
        }.also { addOnPropertyChangedCallback(it) }
}