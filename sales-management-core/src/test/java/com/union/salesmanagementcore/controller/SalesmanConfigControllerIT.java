package com.union.salesmanagementcore.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.union.salesmanagementcore.AbstractTestController;
import com.union.salesmanagementcore.api.dto.SalesmanConfigCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigResponseDto;
import com.union.salesmanagementcore.entities.CommissionType;

public class SalesmanConfigControllerIT extends AbstractTestController {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void create() throws Exception {
        SalesmanConfigCreateDto salesmanConfigCreateDto = createDto(CommissionType.VALUE, 100d);

        SalesmanConfigResponseDto salesmanConfigResponseDto = given()
                .header("Content-Type", "application/json")
                .body(salesmanConfigCreateDto)
                .post(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(SalesmanConfigResponseDto.class);

        assertNotNull(salesmanConfigResponseDto.getId());
        assertEquals(salesmanConfigResponseDto.getCommissionType(), salesmanConfigCreateDto.getCommissionType());
        assertEquals(salesmanConfigResponseDto.getValue(), salesmanConfigCreateDto.getValue());
    }

    private SalesmanConfigCreateDto createDto(CommissionType commissionType, Double value) {
        return new SalesmanConfigCreateDto()
                .setCommissionType(commissionType)
                .setValue(value);
    }
}
