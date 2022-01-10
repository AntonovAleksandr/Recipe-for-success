package com.example.tdddevelopment.data.dto;

import com.example.tdddevelopment.data.excepptions.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StepDtoTest {
    private StepDto stepSetDto;
    private String validDescription;
    private String tooLargeDescriptor;
    private Long validNumber;
    private Long invalidNumber;

    @BeforeEach
    public void setUp() {
        stepSetDto = new StepDto();
        validDescription = "A".repeat(500);
        tooLargeDescriptor = "A".repeat(501);
        validNumber = 1L;
        invalidNumber = 0L;
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void stepDtoSetDescTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> stepSetDto.setDesc(null));
        assertEquals(thrown.getMessage(), "Description cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void setTooLargeDescTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> stepSetDto.setDesc(tooLargeDescriptor));
        assertEquals(thrown.getMessage(), "Description cannot be longer than 500 characters");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void setLargeDescTest() {
        stepSetDto.setDesc(validDescription);
        Assertions.assertEquals(stepSetDto.getDesc(), validDescription);
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void StepConstructorTestNullNumberTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> new StepDto(null, validDescription));
        assertEquals(thrown.getMessage(), "Number cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void StepConstructorTestNullDescTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> new StepDto(validNumber, null));
        assertEquals(thrown.getMessage(), "Description cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void StepConstructorTestTooLargeDescTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> new StepDto(validNumber, tooLargeDescriptor));
        assertEquals(thrown.getMessage(), "Description cannot be longer than 500 characters");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void StepConstructorTestTest() {
        StepDto stepDto = new StepDto(validNumber, validDescription);
        Assertions.assertEquals(stepDto.getDesc(), validDescription);
        Assertions.assertEquals(stepDto.getNumber(), validNumber);
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void StepConstructorLessThanOneNumberTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> new StepDto(invalidNumber, validDescription));
        assertEquals(thrown.getMessage(), "Number cannot be less than one");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void setNullNumberTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> stepSetDto.setNumber(null));
        assertEquals(thrown.getMessage(), "Number cannot be null");
    }

    @Test
    @DisplayName("StepDto set description test - description cannot be null")
    public void setLessThanOneNumberTest() {
        Throwable thrown = assertThrows(BusinessException.class, ()-> stepSetDto.setNumber(invalidNumber));
        assertEquals(thrown.getMessage(), "Number cannot be less than one");
    }
}