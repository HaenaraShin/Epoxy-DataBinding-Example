package dev.haenara.epoxyexample

import com.airbnb.epoxy.EpoxyController

class SampleController(val viewModel: SampleViewModel) : EpoxyController() {
    override fun buildModels() {
        viewModel.data.forEachIndexed { index, data ->
            sample {
                id("sample$index")
                data(data)
                onClick { _ ->
                    viewModel.onClick(index)
                }
            }
            if ((index + 1) % 10 == 0) {
                advertise {
                    id("AD$index")
                    advertise("광고 ID:$index")
                }
            }
        }
    }
}
