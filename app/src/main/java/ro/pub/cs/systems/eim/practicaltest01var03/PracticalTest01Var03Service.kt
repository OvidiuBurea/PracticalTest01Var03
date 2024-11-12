package ro.pub.cs.systems.eim.practicaltest01var03

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper

class PracticalTest01Var03Service : Service() {

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val number1 = intent?.getIntExtra("number1", 0) ?: 0
        val number2 = intent?.getIntExtra("number2", 0) ?: 0

        val sum = number1 + number2
        val difference = number1 - number2

        runnable = Runnable {
            sendBroadcastMessage("ro.pub.cs.systems.eim.practicaltest01var03.SUM_ACTION", sum)
            handler.postDelayed({
                sendBroadcastMessage("ro.pub.cs.systems.eim.practicaltest01var03.DIFFERENCE_ACTION", difference)
            }, 5000)
        }
        handler.post(runnable)

        return START_STICKY
    }

    private fun sendBroadcastMessage(action: String, result: Int) {
        val broadcastIntent = Intent()
        broadcastIntent.action = action
        broadcastIntent.putExtra("result", result)
        sendBroadcast(broadcastIntent)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        handler.removeCallbacks(runnable)
        super.onDestroy()
    }
}