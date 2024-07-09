package ru.webdev.domain.enums;

/**
 * Перечисление (enum), представляющее возможные статусы здоровья системы.
 *
 * @author webdev
 * @version 1.0
 * @since 2024-07-09
 */
public enum HealthStatus {
    /**
     * Указывает, что система работает нормально.
     */
    UP,
    
    /**
     * Указывает, что система не функционирует должным образом или недоступна.
     */
    DOWN
}