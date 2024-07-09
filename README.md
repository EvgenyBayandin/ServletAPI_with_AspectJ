# Health Check Servlet Application

Это Java веб-приложение, которое представляет простой сервлет для проверки состояния здоровья системы и использует аспектно-ориентированное программирование (AOP) для логирования.

## Установка и настройка Tomcat 10 (для Windows)

1. Скачайте Apache Tomcat 10 с [официального сайта](https://tomcat.apache.org/download-10.cgi).
2. Распакуйте скачанный архив в удобное место на вашем компьютере (например, `C:\Program Files\Apache Software Foundation\Tomcat 10.0`).
3. Добавьте переменную среды `CATALINA_HOME`, указывающую на директорию установки Tomcat.
4. Добавьте `%CATALINA_HOME%\bin` в переменную среды PATH.

## Сборка проекта

1. Клонируйте репозиторий:<br>
   `git clone https://github.com/EvgenyBayandin/ServletAPI_with_AspectJ.git`
2. Перейдите в директорию проекта:<br>
   `cd JavaServletAPI`
3. Соберите проект с помощью Maven:<br>
   `mvn clean package`

## Развертывание приложения

1. Скопируйте собранный WAR-файл `JavaServletAPI.war` из директории `target` в директорию `webapps` вашего Tomcat.
2. Запустите Tomcat:
`%CATALINA_HOME%\bin\startup.bat`

## Проверка работоспособности

После запуска Tomcat, приложение будет доступно по следующим URL:

- Проверка здоровья: `http://localhost:8080/JavaServletAPI/health`
- Версия: `http://localhost:8080/JavaServletAPI/version`

## Разработка
Проект использует аспектно-ориентированное программирование (AOP) для логирования.
Классы и методы, помеченные аннотацией @Loggable, автоматически логируются с помощью аспекта LoggableAspect.

## Использованные технологии

- Java 21
- Apache Maven
- Apache Tomcat 10

## Дополнительная информация

Каждый класс-пример содержит подробные комментарии, объясняющие его функциональность и особенности использования.