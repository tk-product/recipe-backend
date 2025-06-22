package com.example.recipe.common.handler.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@AllArgsConstructor
public class DebugLogAspect extends BaseAspect {

    private HttpServletRequest request;

    private ObjectMapper objectMapper;

    @Pointcut("execution(* com.example.recipe.app..*.controller..*(..))")
    public void controllerMethods() {
    }

    @Pointcut("execution(* com.example.recipe.app..*.service..*(..))")
    public void serviceMethods() {
    }

    @Around("controllerMethods() || serviceMethods()")
    public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String sessionId = request.getSession().getId();

        // メソッドの引数を出力
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            String argVal;
            try {
                // ObjectMapperの設定で失敗しにくくする
                argVal = arg == null ? "" : objectMapper.writeValueAsString(arg);
            } catch (Exception e) {
                // ObjectMapperでシリアライズできない場合に toString() にフォールバック
                argVal = arg.toString();
            }
            logger.debug("SessionID: {}, {}.{} argument value: {}", sessionId, className, methodName, argVal);
        }

        // メソッドを実行
        Object result = joinPoint.proceed();
        String resultVal = result == null ? "" : objectMapper.writeValueAsString(result);
        // メソッドの戻り値を出力
        logger.debug("SessionID: {}, {}.{} return value: {}", sessionId, className, methodName, resultVal);

        return result;
    }

}
