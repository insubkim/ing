package mvc.controller;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

/*
 * ws 통신을 제어할용도의 컨트롤러 구현
 * 	1. WebSocketHandler (I) 를 implements 걸어서 목적에 개조해서 사용.
 * 	2. 목적에 맞는 WebSocketHandler를 extends 걸어서 사용
 * 		- TextWebSocketHandler  / BinaryWebSocketHandler 
 * 
 *  WebSocket handler 의 매핑은, spring 설정파일에.
 */
@Controller("wsController") // scan으로 등록되는 빈은 클래스명으로 등록됨. 바쑬수 있음
public class WSController extends TextWebSocketHandler {
	Set<WebSocketSession> wsSessions;

	@PostConstruct // init-method 빈으로 자동으로 등록할때 수동 설정 가능
	public void init() {
		wsSessions = new LinkedHashSet<>();
	}

	@Override // 클라인트측에서 웹 소켓 연결되었을때,
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished " + session.getId());
		// 우리가 아는 http session과 webSocket의 session은 다르다.
		// session.getRemoteAddress().getAddress().getHostAddress();
		wsSessions.add(session);
			for (WebSocketSession ws : wsSessions) {
			ws.sendMessage(new TextMessage(String.valueOf(wsSessions.size())));
			ws.sendMessage(new TextMessage(session.getRemoteAddress().getAddress().
					getHostAddress() + "접속"));
		}
	}

	@Override // 클라이언트측에서 메세지가 들어올때,
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage " + message);
	}

	@Override // 클라인트측와 연결이 해제될때,
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed " + status);
		wsSessions.remove(session);
		for (WebSocketSession ws : wsSessions) {
			ws.sendMessage(new TextMessage(String.valueOf(wsSessions.size())));
			ws.sendMessage(new TextMessage(session.getRemoteAddress().getAddress().
					getHostAddress() + "접속 해제"));
		}
	}
}
