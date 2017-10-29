package com.example.jaka.toastsms_v2;

/**
 * Created by Jaka on 26. 10. 2017.
 */

public interface SmsListener {
    void messageReceived(String messageText, String senderName);
}
