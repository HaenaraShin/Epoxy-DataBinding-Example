package dev.haenara.epoxyexample

import com.airbnb.epoxy.EpoxyController

class SampleController(
    private val dataList: List<Data>,
    private val onClick: (Data) -> Unit
) :
    EpoxyController() {
    override fun buildModels() {
        dataList.forEachIndexed { index, data ->
            itemSample {
                id("sample$index")
                title(data.title)
                subtitle(data.subtitle)
                onClick { _ ->
                    onClick(data)
                }
            }
            if ((index + 1) % 10 == 0) {
                itemAdvertise {
                    id("AD$index")
                    advertise("AD ID:$index")
                }
            }
        }
    }
}
