package com.example.recipe.common.handler.advice;

import com.example.recipe.common.consts.ErrorCodeEnum;
import com.example.recipe.common.dto.response.BaseResDto;
import com.example.recipe.common.dto.response.ErrorInfoDto;
import com.example.recipe.common.exception.CustomApplicationException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.slf4j.MDC;
import org.springframework.context.MessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Locale;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalResponseAdvice extends BaseAdvice implements ResponseBodyAdvice<Object> {

    private HttpServletRequest request;

    private MessageSource messageSource;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleException(Throwable ex) {

        BaseResDto baseResDto = new BaseResDto();
        baseResDto.setResultCode(9);

        String sessionId = request.getSession().getId();
        String requestId = MDC.get(REQUEST_ID_HEADER);

        if (ex instanceof CustomApplicationException cae) {
            logger.error("SessionID: {}, RequestID: {}, DebugCode: {}, ErrorCode: {}, ErrorItem: {}", sessionId, requestId, cae.getDebugCode(), cae.getErrorCode(), cae.getErrorItem());
            String errorMessage = messageSource.getMessage(cae.getErrorCode().getCode(), (Object[]) cae.getPlaceholder(), Locale.getDefault());
            baseResDto.setErrorInfo(crreateErrorInfoDto(cae.getDebugCode(), cae.getErrorCode().getCode(), cae.getErrorItem(), errorMessage));
        } else {
            logger.error("SessionID: {}, RequestID: {}, DebugCode: {}, ErrorCode: {}, ErrorItem: {}", sessionId, requestId, "GR001", ErrorCodeEnum.A001E00003, null, ex);
            String errorMessage = messageSource.getMessage(ErrorCodeEnum.Z001E00001.getCode(), null, Locale.getDefault());
            baseResDto.setErrorInfo(crreateErrorInfoDto("GR001", ErrorCodeEnum.Z001E00001.getCode(), null, errorMessage));
        }
        return ResponseEntity.ok().headers(createHeaders()).body(baseResDto);
    }

    private ErrorInfoDto crreateErrorInfoDto(String debugCode, String errorCode, String errorItem, String errorMessage) {
        ErrorInfoDto errorInfoDto = new ErrorInfoDto();
        errorInfoDto.setDebugCode(debugCode);
        errorInfoDto.setErrorCode(errorCode);
        errorInfoDto.setErrorItem(errorItem);
        errorInfoDto.setErrorMessage(errorMessage);
        return errorInfoDto;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        String requestId = MDC.get(REQUEST_ID_HEADER);

        if (body instanceof BaseResDto) {
            ((BaseResDto) body).setRequestId(requestId);
        }
        return body;
    }
}
