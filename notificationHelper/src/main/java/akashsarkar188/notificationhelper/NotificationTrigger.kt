package akashsarkar188.notificationhelper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.lang.ref.WeakReference

class NotificationTrigger constructor(context : Context) {

    var context : WeakReference<Context>? = null
    lateinit var title : String
    lateinit var description : String
    lateinit var notificationManager: NotificationManager
    lateinit var notificationCompatBuilder: NotificationCompat.Builder
    var notificationChannelHelper: NotificationChannelHelper? = null

    init {
        this@NotificationTrigger.context = WeakReference<Context>(context)
    }

    fun setTitle(title : String) : NotificationTrigger {
        this@NotificationTrigger.title = title

        return this
    }

    fun setDescription(description : String) : NotificationTrigger {
        this@NotificationTrigger.description = description

        return this
    }

    fun setNotificationChannel(notificationChannel : NotificationChannelHelper) : NotificationTrigger {
        this@NotificationTrigger.notificationChannelHelper = notificationChannel

        return this
    }

    fun showNotification() {
        createNotificationChannelIfRequired()

        notificationCompatBuilder = NotificationCompat.Builder(context!!.get()!!, notificationChannelHelper?.channelId!!)
            .setSmallIcon(R.drawable.happy_happy)
            .setContentTitle(title)
            .setContentText(description)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context?.get()!!)) {
            notify(1, notificationCompatBuilder.build())
        }
    }

    private fun createNotificationChannelIfRequired() {
        if (notificationChannelHelper == null) {
            notificationChannelHelper = NotificationChannelHelper()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager = context?.get()?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannelHelper?.getNotificationChannel()!!)
        }
    }
}