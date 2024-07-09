package ru.webdev.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс демонстрирует работу с сервлетом.
 * Расширяет класс HttpServlet для обработки HTTP-запросов.
 * endpoint "/version" установлен в web.xml
 *
 * @author webdev
 * @version 1.0
 * @since 2024-07-09
 */
public class VersionServlet extends HttpServlet {
    
    /**
     * Обрабатывает GET-запросы к сервлету.
     *
     * @param req объект HttpServletRequest, представляющий запрос клиента
     * @param resp объект HttpServletResponse, используемый для отправки ответа клиенту
     * @throws ServletException если происходит ошибка, специфичная для сервлета
     * @throws IOException если происходит ошибка ввода-вывода при обработке запроса
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("req= " + req + "resp= " + resp);
    }
}
