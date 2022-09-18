package akashsarkar188.notificationhelperexample

import akashsarkar188.notificationhelper.NotificationTrigger
import akashsarkar188.notificationhelperexample.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            NotificationTrigger(this@MainActivity)
                .setTitle("Jaba")
                .setDescription("ri Jaba")
                .showNotification()
        }
    }
}