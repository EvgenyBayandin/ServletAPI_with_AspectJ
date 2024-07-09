package ru.webdev.domain;

import ru.webdev.domain.enums.HealthStatus;

/**
 * Запись (record) для представления ответа о состоянии здоровья системы.
 *
 * Records - это новая функция Java, введенная в Java 14, которая предоставляет
 * компактный способ объявления классов, в основном предназначенных для хранения данных.
 *
 * @author webdev
 * @version 1.0
 * @since 2024-07-09
 */
public record HealthResponceDto(HealthStatus status) {

}
