package com.example.latian7;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        for (int i=1; i<=10; i++){
            try{
                Thread.sleep(1000);
                displayNotification("It's Time For Coffe", " Bangunnn....." + i);
            }
            catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
        return Result.success();
    }
    public void displayNotification(String task, String desc) {NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("pesan", "test123", NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "pesan")
                .setSmallIcon(R.drawable.ic_baseline_coffee_24)
                .setContentTitle(task)
                .setContentText(desc)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        manager.notify(1, builder.build());
    }
}
