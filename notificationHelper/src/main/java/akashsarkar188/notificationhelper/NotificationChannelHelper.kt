package akashsarkar188.notificationhelper

import android.app.NotificationChannel
import android.os.Build

class NotificationChannelHelper constructor() {

    var channelId: String = "GeneralNotification"
    var channelName: String = "General Notifications"
    var channelDescriptions: String = "General notifications to keep you updated"
    var channelImportance: Int = 3
    lateinit var channel: NotificationChannel

    constructor(
        channelId: String,
        channelName: String,
        channelDescriptions: String,
        channelImportance: Int
    ) : this() {
        this.channelId = channelId
        this.channelName = channelName
        this.channelDescriptions = channelDescriptions
        this.channelImportance = channelImportance
    }

    fun getNotificationChannel(): NotificationChannel? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = NotificationChannel(channelId, channelName, channelImportance)
            channel.description = channelDescriptions
            channel
        } else {
            null
        }
    }
}