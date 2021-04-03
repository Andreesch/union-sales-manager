package com.union.salesmanagementcore.helpers;

import static com.union.salesmanagementcore.AbstractTestController.SALESMAN_CONFIG_RESOURCE;
import static com.union.salesmanagementcore.AbstractTestController.SALESMAN_RESOURCE;
import static io.restassured.RestAssured.given;

import com.union.salesmanagementcore.api.dto.SalesmanConfigResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanResponseDto;
import com.union.salesmanagementcore.entities.Region;

public class SalesmanHelper {

    public static final String DEFAULT_SALESMAN_NAME = "André Schneider";
    public static final Region DEFAULT_REGION = Region.CENTRAL;

    public static SalesmanCreateDto createDto(String name, Region region, String salesmanConfigId) {
        return new SalesmanCreateDto()
                .setName(name)
                .setRegion(region)
                .setSalesmanConfigId(salesmanConfigId);
    }

    public static SalesmanResponseDto createDefault() {
        SalesmanConfigResponseDto salesmanConfigResponseDto = SalesmanConfigHelper.createAndReturnDefaultDto();

        return createDefault(salesmanConfigResponseDto.getId());
    }

    private static SalesmanResponseDto createDefault(String configId) {
        return given()
                .header("Content-Type", "application/json")
                .body(createDto(DEFAULT_SALESMAN_NAME, DEFAULT_REGION, configId))
                .post(SALESMAN_RESOURCE)
                .then()
                .statusCode(201)
                .extract()
                .as(SalesmanResponseDto.class);
    }
}
