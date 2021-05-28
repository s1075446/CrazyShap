package tw.edu.pu.s410754469.crazyshap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*
@GlideModule
public final class MyAppGlideModule : AppGlideModule()

class MainActivity : AppCompatActivity() {

    var Flag:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img: ImageView = findViewById(R.id.imgTitle)
        GlideApp.with(this)
        .load(R.drawable.cover)
            .circleCrop()
        .override(800, 600)
        .into(img)

        Toast.makeText(baseContext, "作者：劉玉婷", Toast.LENGTH_LONG).show()
        rndShape()

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
                return true
            }
        })
        imgNext.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?){
                rndShape()
            }
        })
    }
    fun rndShape(){
        Flag=(1..4).random()
        when(Flag){
            1->imgNext.setImageResource(R.drawable.circle)
            1->imgNext.setImageResource(R.drawable.square)
            1->imgNext.setImageResource(R.drawable.star)
            1->imgNext.setImageResource(R.drawable.triangle)
        }

    }
}