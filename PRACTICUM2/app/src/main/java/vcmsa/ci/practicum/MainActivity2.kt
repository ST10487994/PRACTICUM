package vcmsa.ci.practicum

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private val Drawable.Callback.rate: Unit
    get() {}

class MainActivity2 : AppCompatActivity() {

    private lateinit var playlist:ArrayList<Song>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        //Displays playlist from MainActivity1
        playlist = intent.getParcelableArrayListExtra("playlist") ?: arrayListOf()

        //View Playlist
        btnDetails.setOnClickListener {
            val details = StringBuilder()
            this.playlist.forEachIndexed { index, song ->
                details.append("${index + 1}. ${song.title} by ${song.artist}\n")
                details.append("Rate: ${song.rating}/5\n")
                details.append("Comment: ${song.comment}\n\n")
            }
            txtDetails.text = details.toString()
        }

        // Calculate average rating
        btnAverage.setOnClickListener {
            if (playlist.isNotEmpty()) {
                val total = playlist.sumOf { it.rate }
                val average = total.toDouble() / playlist.size
                txtAverage.text = "Average Rating: %.2f".format(average)
            } else {
                txtAverage.text = "No songs to calculate"
            }
        }

        // Return to Main screen
        btnReturn.setOnClickListener {
            finish()
        }





















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtAverage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun Any.sumOf(function: () -> Unit): Any {


    {}}


