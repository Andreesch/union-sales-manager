package com.union.salesmanagementcore.controller;

import static com.union.salesmanagementcore.helpers.SalesmanConfigHelper.createAndReturnDefaultDto;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import com.union.salesmanagementcore.AbstractTestController;
import com.union.salesmanagementcore.api.dto.SalesmanConfigCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigUpdateDto;
import com.union.salesmanagementcore.entities.CommissionType;
import com.union.salesmanagementcore.helpers.SalesmanConfigHelper;

public class SalesmanConfigControllerIT extends AbstractTestController {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void create() throws Exception {
        SalesmanConfigCreateDto salesmanConfigCreateDto = SalesmanConfigHelper.createDto(CommissionType.VALUE, 100d);

        SalesmanConfigResponseDto salesmanConfigResponseDto = createAndReturnDefaultDto(salesmanConfigCreateDto);

        assertNotNull(salesmanConfigResponseDto.getId());
        assertEquals(salesmanConfigResponseDto.getCommissionType(), salesmanConfigCreateDto.getCommissionType());
        assertEquals(salesmanConfigResponseDto.getValue(), salesmanConfigCreateDto.getValue());
    }

    @Test
    public void update() throws Exception {
        SalesmanConfigCreateDto salesmanConfigCreateDto = SalesmanConfigHelper.createDto(CommissionType.VALUE, 100d);
        SalesmanConfigResponseDto salesmanConfigResponseDto = createAndReturnDefaultDto(salesmanConfigCreateDto);

        SalesmanConfigUpdateDto salesmanConfigUpdateDto = updateDto(salesmanConfigResponseDto.getId(), CommissionType.PERCENT, 10d);

        SalesmanConfigResponseDto salesmanConfigUpdateResponseDto = given()
                .header("Content-Type", "application/json")
                .body(salesmanConfigUpdateDto)
                .put(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(200)
                .extract()
                .as(SalesmanConfigResponseDto.class);

        assertNotNull(salesmanConfigResponseDto.getId());
        assertEquals(salesmanConfigUpdateDto.getCommissionType(), salesmanConfigUpdateResponseDto.getCommissionType());
        assertEquals(salesmanConfigUpdateDto.getValue(), salesmanConfigUpdateResponseDto.getValue());
    }

    @Disabled
    @Test
    public void findSalesmanConfig() throws Exception {
        SalesmanConfigCreateDto salesmanConfigCreateDto = SalesmanConfigHelper.createDto(CommissionType.VALUE, 100d);
        SalesmanConfigResponseDto salesmanConfigResponseDto = createAndReturnDefaultDto(salesmanConfigCreateDto);

        SalesmanConfigResponseDto salesmanConfigFounded = given()
                .urlEncodingEnabled(false)
                .header("Content-Type", "application/json")
                .queryParam("code", salesmanConfigResponseDto.getId())
                .get(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(200)
                .extract()
                .as(SalesmanConfigResponseDto.class);

        assertEquals(salesmanConfigResponseDto.getId(), salesmanConfigFounded.getId());
        assertEquals(salesmanConfigResponseDto.getValue(), salesmanConfigFounded.getValue());
        assertEquals(salesmanConfigResponseDto.getCommissionType(), salesmanConfigFounded.getCommissionType());
    }

    private SalesmanConfigUpdateDto updateDto(String id, CommissionType commissionType, Double value) {
        return new SalesmanConfigUpdateDto()
                .setId(id)
                .setCommissionType(commissionType)
                .setValue(value);
    }
}
