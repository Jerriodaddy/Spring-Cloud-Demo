package com.icewould.common.exception;

import com.icewould.common.enums.ResultCode;

/**
 * 自定义API异常
 *
 * @author macro
 * @date 2020/2/27
 */
public class ApiException extends RuntimeException {
    private ResultCode resultCode;

    public ApiException(ResultCode errorCode) {
        super(errorCode.getMessage());
        this.resultCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultCode getErrorCode() {
        return resultCode;
    }
}
