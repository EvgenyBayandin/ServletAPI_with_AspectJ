package ru.webdev.service;

import ru.webdev.annotations.Loggable;
import ru.webdev.domain.enums.HealthStatus;

/**
 * Сервис для проверки состояния здоровья системы.
 * Аннотация @Loggable предполагает, что действия этого сервиса будут логироваться.
 *
 * @author webdev
 * @version 1.0
 * @since 2024-07-09
 */
@Loggable
public class HealthCheckService {
    
    /**
     * Получает текущий статус здоровья системы.
     *
     * @return HealthStatus текущий статус здоровья системы
     */
    public HealthStatus getHealthStatus() {
        try {
            // Имитация задержки при проверке состояния системы
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Вывод информации об исключении, если поток был прерван
            e.printStackTrace();
        }
        // В данной реализации всегда возвращается статус UP
        return HealthStatus.UP;
    }
}
