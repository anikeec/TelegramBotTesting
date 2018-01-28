/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apu.telegrambottesting;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 *
 * @author apu
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
	ApiContextInitializer.init(); // Инициализируем апи
	TelegramBotsApi botapi = new TelegramBotsApi();
	try {
            botapi.registerBot(new BotProcess());
	} catch (TelegramApiException e) {
            e.printStackTrace();
	}
    }
}
