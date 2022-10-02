package com.example.payzer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Objects;


public class SmsReceiver extends BroadcastReceiver {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference();


    @Override
    public void onReceive(Context context, Intent intent){
        int mainMsg=0;
        double Debitedmount=0.0;
        String lol="",str="",msg="";
        String[] words;
        StringBuilder amount= new StringBuilder();
        if(Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())){
            for(SmsMessage SmaMsg: Telephony.Sms.Intents.getMessagesFromIntent(intent)){
                msg=SmaMsg.getMessageBody();
                words = msg.split(" ");
                for (String word : words){
                    if(Objects.equals(word, "debited") || Objects.equals(word, "DEBITED") || Objects.equals(word, "sent") || Objects.equals(word, "Debited")){
                        for(String NewWord :words){
                            if(Objects.equals(NewWord,"INR")){
                                mainMsg=msg.indexOf("INR");
//                                For Testing Purporse Igonore it
//                                lol = msg.substring(mainMsg+3);
//                                int charr=msg.charAt(mainMsg+3);
//                                Log.e("TAG", "onRevive: " +charr);
//                                Log.e("TAG", "onRevive: " +lol);
//                                Log.e("TAG", "onRevive: " +"on INR");
                                for(int i=mainMsg+4; i<msg.length();i++){
                                    int temp=msg.charAt(i);
                                    if(temp>=46 && temp <=57 && temp !=47){
                                        amount.append(msg.charAt(i));
                                    }else if(temp==32){
                                        break;
                                    }
                                }
                            } else if (NewWord.contains("Rs") || NewWord.contains("RS")){
                                mainMsg=msg.indexOf("R",msg.indexOf(word));
//                                For Testing Purporse Igonore it
//                                lol = msg.substring(mainMsg+3);
//                                int charr=msg.charAt(mainMsg+3);
//                                Log.e("TAG", "onRevive: " +charr);
//                                Log.e("TAG", "onRevive: " +lol);
//                                Log.e("TAG", "onRevive: " +"on RS");
                                for(int i=mainMsg+3; i<msg.length();i++){
                                    int temp=msg.charAt(i);
                                    if(temp>=46 && temp <=57 && temp !=47){
                                        amount.append(msg.charAt(i));
                                    }else if(temp==32){
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    str=amount.toString();
                }
            }
        }
        if(!str.equals("")){
            Debitedmount=Double.parseDouble(str);
            Log.e("TAG", "Debited Amount: "+Debitedmount);
        }

        HashMap<String,Double> userMap = new HashMap<>();
        userMap.put("Amount", Debitedmount);
        root.push().setValue(userMap);
    }
}
