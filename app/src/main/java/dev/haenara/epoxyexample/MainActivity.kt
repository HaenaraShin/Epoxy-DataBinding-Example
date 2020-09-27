package dev.haenara.epoxyexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.setController(
            SampleController(
                SampleViewModel(
                    createData(),
                    onClick = {
                        Toast.makeText(
                            this@MainActivity,
                            "${it}번째 아이템이 클릭되었습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
            )
        )
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
