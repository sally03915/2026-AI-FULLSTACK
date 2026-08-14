package com.thejoa703.analysis; 
 
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsSyncService statisticsSyncService;

    // 수동으로 Django에 통계 전송을 요청하는 엔드포인트
    // 호출 URL: POST http://localhost:8080/api/statistics/sync
    @PostMapping("/sync")
    public ResponseEntity<String> syncStatistics() {
        try {
            statisticsSyncService.sendRealStatsToDjango();
            return ResponseEntity.ok("✅ 스프링 부트 -> 장고 통계 동기화 성공!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("❌ 동기화 실패: " + e.getMessage());
        }
    }
}