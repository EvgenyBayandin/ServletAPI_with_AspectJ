package ru.webdev.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import ru.webdev.annotations.Loggable;
import ru.webdev.domain.HealthResponceDto;
import ru.webdev.domain.enums.HealthStatus;
import ru.webdev.service.HealthCheckService;

/**
 * Сервлет для обработки запросов проверки состояния здоровья системы.
 *
 * @Loggable аннотация предполагает, что действия этого сервлета будут логироваться.
 * @WebServlet("/health") указывает, что сервлет будет обрабатывать запросы по пути "/health".
 *
 * @author webdev
 * @version 1.0
 * @since 2024-07-09
 */
@Loggable
@WebServlet("/health")
public class HealthCheckServlet extends HttpServlet {
    
    private final ObjectMapper objectMapper;
    private final HealthCheckService healthCheckService;
    
    /**
     * Конструктор, инициализирующий ObjectMapper и HealthCheckService.
     */
    public HealthCheckServlet() {
        this.objectMapper = new ObjectMapper();
        // Настройка ObjectMapper, чтобы не выбрасывать исключение при сериализации пустых объектов
        this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        this.healthCheckService = new HealthCheckService();
    }
    
    /**
     * Обрабатывает GET-запросы к сервлету.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Устанавливаем статус ответа 200 OK
        resp.setStatus(HttpServletResponse.SC_OK);
        // Указываем, что ответ будет в формате JSON
        resp.setContentType("application/json");
        
        // Получаем статус здоровья системы
        HealthStatus healthStatus = healthCheckService.getHealthStatus();
        // Создаем DTO с полученным статусом
        HealthResponceDto healthResponceDto = new HealthResponceDto(healthStatus);
        
        // Сериализуем DTO в JSON и отправляем в ответ
        byte[] bytes = objectMapper.writeValueAsBytes(healthResponceDto);
        resp.getOutputStream().write(bytes);
    }
}
