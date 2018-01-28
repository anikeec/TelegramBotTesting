/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apu.telegrambottesting;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author apu
 */
public class BotProcess extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return BotParameters.TELEGRAMM_BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage(); 
        String txt = msg.getText();
        BotParameters.setChatId(msg.getChatId()); 
        System.out.println("Received message: " + txt);
        if (txt.equals("/start")) {
            sendMessage(msg, "Hello! I'm a bot!"); 
        }
    }

    @Override
    public String getBotUsername() {
        return BotParameters.TELEGRAMM_BOT_USERNAME;
    }
    
    public void sendMessage(Message msg, String text) {
        sendMessage(msg.getChatId(), text);
    }
    
    public void sendMessage(long chatId, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(chatId); 
        s.setText(text);
        try { 
            execute(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    
}
