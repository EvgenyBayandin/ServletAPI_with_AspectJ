package ru.webdev.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Аспект для логирования методов, помеченных аннотацией @Loggable.
 *
 * @author webdev
 * @version 1.0
 * @since 2024-07-09
 */
@Aspect
public class LoggableAspect {
    
    /**
     * Определяет точку среза для методов, помеченных аннотацией @Loggable.
     * Этот pointcut будет соответствовать любому методу в классе, помеченном @Loggable.
     */
    @Pointcut("within(@ru.webdev.annotations.Loggable *) && execution(* * (..))")
    public void annotatedByLoggable() {}
    
    /**
     * Совет (advice) для логирования выполнения методов, соответствующих pointcut'у.
     *
     * @param proceedingJoinPoint точка соединения, представляющая выполняемый метод
     * @return результат выполнения метода
     * @throws Throwable если метод выбрасывает исключение
     */
    @Around("annotatedByLoggable()")
    public Object logging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Логируем начало выполнения метода
        System.out.println("Calling method: " + proceedingJoinPoint.getSignature());
        
        // Засекаем время начала выполнения
        long start = System.currentTimeMillis();
        
        // Выполняем сам метод
        Object result = proceedingJoinPoint.proceed();
        
        // Вычисляем время выполнения
        long end = System.currentTimeMillis() - start;
        
        // Логируем окончание выполнения метода и время выполнения
        System.out.println("Execution method: " + proceedingJoinPoint.getSignature() +
                " finished. Execution time is: " + end + " ms");
        
        // Возвращаем результат выполнения метода
        return result;
    }
}
