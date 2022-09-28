package com.example.payzer;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;


public abstract class SmsReciver extends BroadcastReceiver {
    public void onRecive(Context context, Intent intent){
        if(Telephony.Sms.Intents.SMS_REJECTED_ACTION.equals(intent.getAction())){
            for(SmsMessage SmaMsg: Telephony.Sms.Intents.getMessagesFromIntent(intent)){
                String msg=SmaMsg.getMessageBody();
                Log.e("TAG", "onRevive: " +msg);
            }
        }
    }
}

