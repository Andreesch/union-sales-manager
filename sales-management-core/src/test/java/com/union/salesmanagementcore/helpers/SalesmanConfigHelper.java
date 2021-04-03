package com.union.salesmanagementcore.helpers;

import static com.union.salesmanagementcore.AbstractTestController.SALESMAN_CONFIG_RESOURCE;
import static io.restassured.RestAssured.given;

import com.union.salesmanagementcore.api.dto.SalesmanConfigCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigResponseDto;
import com.union.salesmanagementcore.entities.CommissionType;

public class SalesmanConfigHelper {
    private static final Double DEFAULT_VALUE = 10.00;
    private static final CommissionType COMMISSION_TYPE = CommissionType.VALUE;

    public static SalesmanConfigCreateDto createDto(CommissionType commissionType, Double value) {
        return new SalesmanConfigCreateDto()
                .setValue(value)
                .setCommissionType(commissionType);
    }

    public static SalesmanConfigResponseDto createAndReturnDefaultDto(SalesmanConfigCreateDto salesmanConfigCreateDto) {
        return given()
                .header("Content-Type", "application/json")
                .body(salesmanConfigCreateDto)
                .post(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(SalesmanConfigResponseDto.class);
    }

    public static SalesmanConfigResponseDto createAndReturnDefaultDto() {
        return given()
                .header("Content-Type", "application/json")
                .body(createDto(COMMISSION_TYPE, DEFAULT_VALUE))
                .post(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(SalesmanConfigResponseDto.class);
    }
}
