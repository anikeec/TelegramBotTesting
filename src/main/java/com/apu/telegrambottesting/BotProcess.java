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
        System.out.println("Received message: " + txt);
        if (txt.equals("/start")) {
            sendMessage(msg, "Hello! I'm a bot!"); 
        }
    }

    @Override
    public String getBotUsername() {
        return BotParameters.TELEGRAMM_BOT_USERNAME;
    }
    
    private void sendMessage(Message msg, String text) {
        SendMessage s = new SendMessage();
        s.setChatId(msg.getChatId()); // Боту может писать не один человек, и поэтому чтобы отправить сообщение, грубо говоря нужно узнать куда его отправлять
        s.setText(text);
        try { //Чтобы не крашнулась программа при вылете Exception 
            execute(s);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    
}
