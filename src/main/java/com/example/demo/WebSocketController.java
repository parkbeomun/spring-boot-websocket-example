package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        //HtmlUtils.htmlEscape : 사용자가 입력한 문자열에 HTML 코드가 섞여있으면 문제가 될 경우 이스케이프 처리
        //Griting 객체에 사용자가 입력한 문자열을 넣은후 리턴한다. 클라이언트에서는 Greeting 객체에서 content 를 가져온다.
    }

}
