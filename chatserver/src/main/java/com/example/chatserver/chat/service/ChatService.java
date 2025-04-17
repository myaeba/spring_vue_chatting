package com.example.chatserver.chat.service;

import com.example.chatserver.chat.repository.ChatMessageRepository;
import com.example.chatserver.chat.repository.ChatParticipantRepository;
import com.example.chatserver.chat.repository.ChatRoomRepository;
import com.example.chatserver.chat.repository.ReadStatusRepository;
import com.example.chatserver.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatParticipantRepository chatParticipantRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ReadStatusRepository readStatusRepository;
    private final MemberRepository memberRepository;

    public ChatService(MemberRepository memberRepository, ReadStatusRepository readStatusRepository, ChatMessageRepository chatMessageRepository, ChatParticipantRepository chatParticipantRepository, ChatRoomRepository chatRoomRepository) {
        this.memberRepository = memberRepository;
        this.readStatusRepository = readStatusRepository;
        this.chatMessageRepository = chatMessageRepository;
        this.chatParticipantRepository = chatParticipantRepository;
        this.chatRoomRepository = chatRoomRepository;
    }


}
