package com.example.chatserver.chat.controller;

import com.example.chatserver.chat.dto.ChatMessageDto;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    private final SimpMessageSendingOperations messageTemplate;

    public StompController(SimpMessageSendingOperations messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    //    방법1.MessageMapping(수신)과 SenTo(topic에 메시지전달)한꺼번에 처리
//    @MessageMapping("/{roomId}")//클라이언트에서 특정 publish/roomId형태로 메시지를 발행시 MessageMapping 수신
//    @SendTo("/topic/{roomId}")  //해당 roomId에 메시지를 발행하여 구독중인 클라이언트에게 메시지 전송
//    public String sendMessage(@DestinationVariable Long roomId, String message) {
//        System.out.println(message);
//
//        return message;
//    }

    @MessageMapping("/{roomId}")
    public void sendMessage(@DestinationVariable Long roomId, ChatMessageDto chatMessageDto) {
        System.out.println(chatMessageDto.getMessage());

//        @SendTo("/topic/{roomId}") 과 같다 좀더 유연하게 코드사용이 가능
        messageTemplate.convertAndSend("/topic/" + roomId, chatMessageDto);
    }
}
