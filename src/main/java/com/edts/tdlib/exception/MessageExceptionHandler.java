package com.edts.tdlib.exception;


import com.edts.tdlib.bean.GeneralWrapper;
import com.edts.tdlib.bean.LoggerBean;
import com.edts.tdlib.mapper.CommonMapper;
import com.edts.tdlib.messagebroker.Producer;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.text.ParseException;

/**
 * Handler for all exceptions and generate response in json format.
 */
@RestControllerAdvice
public class MessageExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Producer producer;
    private final CommonMapper commonMapper;

    @Autowired
    public MessageExceptionHandler(Producer producer, CommonMapper commonMapper) {
        this.producer = producer;
        this.commonMapper = commonMapper;
    }

    /**
     * Handle general error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> general(Exception ex) {
        //handleErrorMessage(ex);
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GeneralWrapper().fail(ex, ex.getMessage()));
    }

    /**
     * Handle unauthorized error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> unauthorized(AuthenticationException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new GeneralWrapper().fail(ex, HttpStatus.UNAUTHORIZED.getReasonPhrase()));
    }

    /**
     * Handle forbidden error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> forbidden(AccessDeniedException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new GeneralWrapper().fail(ex, HttpStatus.FORBIDDEN.getReasonPhrase()));
    }

    /**
     * Handle bad request message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new GeneralWrapper().fail(ex));
    }

    /**
     * A single place to customize the response body of all exception types.
     * <p>The default implementation sets the {@link WebUtils#ERROR_EXCEPTION_ATTRIBUTE}
     * request attribute and creates a {@link ResponseEntity} from the given
     * body, headers, and status.
     *
     * @param ex      the exception
     * @param body    the body for the response
     * @param headers the headers for the response
     * @param status  the response status
     * @param request the current request
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //handleErrorMessage(ex);
        super.handleExceptionInternal(ex, body, headers, status, request);
        return ResponseEntity
                .status(status)
                .headers(headers)
                .body(new GeneralWrapper().fail(ex, status.getReasonPhrase()));
    }

    /**
     * Handle error massage from exception.
     * Will send message to {@link Producer#sendLogger(LoggerBean)}
     *
     * @param ex from exception handler
     */
    private void handleErrorMessage(Exception ex) {
        logger.error("Error : ", ex);
        LoggerBean loggerBean = commonMapper.toLoggerBean(ex);
        //producer.sendLogger(loggerBean);
    }


    @ExceptionHandler(HandledException.class)
    public ResponseEntity<?> flowException(HandledException ex) {
        handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new GeneralWrapper().fail(ex, ex.getMessage()));
    }

    /**
     * Handle general error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<?> uploadFile(MaxUploadSizeExceededException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                .body(new GeneralWrapper().fail(ex, "Size Too Large"));
    }


    /**
     * Handle entity not found error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> noEntityNotFound(EntityNotFoundException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new GeneralWrapper().fail(ex, "Data tidak di temukan"));
    }

    /**
     * Handle constrain error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> constraint(DataIntegrityViolationException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new GeneralWrapper().fail(ex, "Data tidak valid"));
    }


    /**
     * Handle SQLGrammarException error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(SQLGrammarException.class)
    public ResponseEntity<?> sqlGrammarException(SQLGrammarException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new GeneralWrapper().fail(ex, "Kesalahan sistem"));
    }

    /**
     * Handle SQLGrammarException error message.
     *
     * @param ex exception to be handled
     * @return response entity with error message
     */
    @ExceptionHandler(ParseException.class)
    public ResponseEntity<?> parseException(ParseException ex) {
        //handleErrorMessage(ex);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                .body(new GeneralWrapper().fail(ex, "Kesalahan format"));
    }

}
