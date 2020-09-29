package dev.haenara.epoxyexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val controller = SampleController(
        createData(),
        onClick = {
            Toast.makeText(
                this@MainActivity,
                "${it.title} has clicked.",
                Toast.LENGTH_SHORT
            ).show()
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.setController(controller)
        recycler_view.requestModelBuild()
    }

    private fun createData(): List<Data> {
        return (1..100).map {
            Data(
                title = "Title $it",
                subtitle = "subtitle $it"
            )
        }
    }
}
