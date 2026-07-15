package com.the703.api;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiNotificationService {

    private final RestClient restClient;

    @Value("${webhook.slack.url}")
    private String slackUrl;

    @Value("${webhook.discord.url}")
    private String discordUrl;

    @Value("${webhook.slack.enabled}")
    private boolean slackEnabled;

    @Value("${webhook.discord.enabled}")
    private boolean discordEnabled;

    public ApiNotificationService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    /**
     * 통합 알림 발송 메서드
     */
    public void sendAllNotifications(String docUrl) {
        String message = "📢 **[주간 보고서 발행 완료]**\n" +
                         "AI 요약 보고서 문서가 생성되었습니다.\n" +
                         "👉 링크: " + docUrl;

        // 1. 슬랙 발송
        if (slackEnabled) {
            sendToPlatform(slackUrl, Map.of("text", message));
        }

        // 2. 디스코드 발송
        if (discordEnabled) {
            sendToPlatform(discordUrl, Map.of("content", message));
        }
    }

    private void sendToPlatform(String url, Map<String, Object> body) {
        try {
            restClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(body)
                    .retrieve()
                    .toBodilessEntity();
        } catch (Exception e) {
            System.err.println("알림 전송 실패 (" + url + "): " + e.getMessage());
        }
    }
}


//1. ⚙️ 사전 준비: 웹훅 URL(주소) 따오기
//프로그램(자바)이 채팅방에 말을 걸려면, 해당 채팅방 전용 '전화번호(웹훅 URL)'가 필요합니다.
//
//슬랙(Slack):
//
//Slack App Directory에서 Create New App 생성.
//
//왼쪽 메뉴에서 Incoming Webhooks 활성화(On).
//
//하단의 Add New Webhook to Workspace를 눌러 알림을 보낼 채널을 선택하면 [https://hooks.slack.com/services/](https://hooks.slack.com/services/)... 주소가 발급됩니다.
//
//디스코드(Discord):
//
//알림을 받을 채널의 설정(톱니바퀴 ⚙️) 클릭.
//
//연동(Integrations) -> 웹훅(Webhooks) -> 새 웹훅 만들기 클릭.
//
//생성된 웹훅의 웹훅 URL 복사 버튼을 누르면 [https://discord.com/api/webhooks/](https://discord.com/api/webhooks/)... 주소가 발급됩니다.
//
//💡 딴 주소는 application.properties에 webhook.url=여기에복사한주소 형태로 저장해 두시면 됩니다.