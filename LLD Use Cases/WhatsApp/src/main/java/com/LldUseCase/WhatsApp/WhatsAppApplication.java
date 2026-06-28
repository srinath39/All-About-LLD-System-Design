package com.LldUseCase.WhatsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LldUseCase.WhatsApp.Chat.AbstractChat;
import com.LldUseCase.WhatsApp.ChatService.WhatsAppService;
import com.LldUseCase.WhatsApp.Enums.EnumMessageType;
import com.LldUseCase.WhatsApp.User.User;

@SpringBootApplication
public class WhatsAppApplication {

	public static void main(String[] args) {
		WhatsAppService whatsAppService=WhatsAppService.getInstance();
		User user1=whatsAppService.createUserAccount("srinath", "12345678");
		User user2=whatsAppService.createUserAccount("Vineet", "75474447");

		AbstractChat chat= whatsAppService.createSingleChat(user1.getUserId(), user2.getUserId());
		whatsAppService.sendMessage(user1.getUserId(), EnumMessageType.TEXT, "HI BRO", chat.getChatId());

	}

}
