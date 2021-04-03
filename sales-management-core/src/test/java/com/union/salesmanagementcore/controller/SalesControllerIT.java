package com.union.salesmanagementcore.controller;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.union.salesmanagementcore.AbstractTestController;
import com.union.salesmanagementcore.api.dto.SalesCreateDto;
import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanResponseDto;
import com.union.salesmanagementcore.helpers.SalesmanHelper;

public class SalesControllerIT extends AbstractTestController {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void create() throws Exception {
        SalesmanResponseDto salesmanResponseDto = SalesmanHelper.createDefault();

        SalesCreateDto createDto = createDto(salesmanResponseDto.getId(), 20.00d, LocalDateTime.now(), "Apple Iphone 11 256gb");

        SalesResponseDto responseDto = given()
                .header("Content-Type", "application/json")
                .body(createDto)
                .post(SALES_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(SalesResponseDto.class);

        assertEquals(createDto.getSalesmanId(), responseDto.getSalesmanId());
        assertEquals(createDto.getCreatedAt(), responseDto.getCreatedAt());
        assertEquals(createDto.getValue(), responseDto.getValue());
        assertEquals(createDto.getDescription(), responseDto.getDescription());

    }

    private SalesCreateDto createDto(String salesmanId, Double value, LocalDateTime createdAt, String description) {
        return new SalesCreateDto()
                .setSalesmanId(salesmanId)
                .setValue(value)
                .setCreatedAt(createdAt)
                .setDescription(description);
    }

}
