package com.example.payzer;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;


public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        if(Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())){
            for(SmsMessage SmaMsg: Telephony.Sms.Intents.getMessagesFromIntent(intent)){
                String msg=SmaMsg.getMessageBody();
                Log.e("TAG", "onRevive: " +msg);
            }
        }
    }
}

