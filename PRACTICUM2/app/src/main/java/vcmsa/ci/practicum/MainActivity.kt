package vcmsa.ci.practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize

private val Any.text: Any
 get() {}
private val Int.text: Any
    get() {

        class MainActivity<Song : Any?> : AppCompatActivity() {

            private lateinit var playlist: ArrayList<Song>


            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_main)

                val edtSongTitle = findViewById<EditText>(R.id.edtSongTitle)
                val edtArtist = findViewById<EditText>(R.id.edtArtist)
                val edtRate = findViewById<EditText>(R.id.edtRate)
                val edtComment = findViewById<EditText>(R.id.edtComment)

                val btnAdd = findViewById<Button>(R.id.btnAdd)
                val btnView = findViewById<Button>(R.id.btnDetails)
                val btnExit = findViewById<Button>(R.id.btnExit)

                // Add to Playlist
                btnAdd.setOnClickListener {
                    val edtSongTitle = edtSongTitle.text.toString()
                    val edtArtist = edtArtist.text.toString()
                    val edtRate = edtRate.text.toString().toIntOrNull() ?: 0
                    val edtComment = edtComment.text.toString()

                    if (edtSongTitle.isNotEmpty() && edtArtist.isNotEmpty() && edtRate in 1..5) {
                        val song = Song(edtSongTitle, edtArtist, edtRate, edtComment)
                        playlist.add(song)
                        edtSongTitle.text.clear()
                        edtArtist.text.clear()
                        edtRate.text.clear()
                        edtComment.text.clear()

                        Toast.makeText(this, "$title added playlist", Toast.LENGTH_SHORT).show()

                    } else {

                        Toast.makeText(
                            this,
                            "Please enter valid song info (rating 1-5)",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    // View playlist details
                    btnView.setOnClickListener {
                        val intent = Intent(this, MainActivity2::class.java)
                        intent.putParcelableArrayListExtra("playlist", playlist)
                        startActivity(intent)
                    }

                    // Exit App
                    btnExit.setOnClickListener {
                        finish()
                    }


                }
            }

            private fun Song(
                edtSongTitle: String,
                edtArtist: String,
                edtRate: Int,
                edtComment: String
            ): Any {
                TODO("Not yet implemented")
            }


        }

        class Song {

        }
        {}}


private fun <E> ArrayList<E>.add(element: Any) {

}


private fun Any.clear() {
    TODO("Not yet implemented")
}
