package com.union.salesmanagementcore.helpers;

import static com.union.salesmanagementcore.AbstractTestController.SALESMAN_CONFIG_RESOURCE;
import static io.restassured.RestAssured.given;

import com.union.salesmanagementcore.api.dto.CommissionCreateDto;
import com.union.salesmanagementcore.api.dto.ComissionResponseDto;
import com.union.salesmanagementcore.entities.CommissionType;

public class SalesmanConfigHelper {
    private static final Double DEFAULT_VALUE = 10.00;
    private static final CommissionType COMMISSION_TYPE = CommissionType.VALUE;

    public static CommissionCreateDto createDto(CommissionType commissionType, Double value) {
        return new CommissionCreateDto()
                .setValue(value)
                .setCommissionType(commissionType);
    }

    public static ComissionResponseDto createAndReturnDefaultDto(CommissionCreateDto commissionCreateDto) {
        return given()
                .header("Content-Type", "application/json")
                .body(commissionCreateDto)
                .post(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(ComissionResponseDto.class);
    }

    public static ComissionResponseDto createAndReturnDefaultDto() {
        return given()
                .header("Content-Type", "application/json")
                .body(createDto(COMMISSION_TYPE, DEFAULT_VALUE))
                .post(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(ComissionResponseDto.class);
    }
}
