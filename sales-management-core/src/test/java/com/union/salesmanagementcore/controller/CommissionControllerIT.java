package com.union.salesmanagementcore.controller;

import static com.union.salesmanagementcore.helpers.SalesmanConfigHelper.createAndReturnDefaultDto;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import com.union.salesmanagementcore.AbstractTestController;
import com.union.salesmanagementcore.api.dto.CommissionCreateDto;
import com.union.salesmanagementcore.api.dto.ComissionResponseDto;
import com.union.salesmanagementcore.api.dto.CommissionUpdateDto;
import com.union.salesmanagementcore.entities.CommissionType;
import com.union.salesmanagementcore.helpers.SalesmanConfigHelper;

public class CommissionControllerIT extends AbstractTestController {

    @Before
    public void setup() throws Exception {
        super.setup();
    }

    @Test
    public void create() throws Exception {
        CommissionCreateDto commissionCreateDto = SalesmanConfigHelper.createDto(CommissionType.VALUE, 100d);

        ComissionResponseDto comissionResponseDto = createAndReturnDefaultDto(commissionCreateDto);

        assertNotNull(comissionResponseDto.getId());
        assertEquals(comissionResponseDto.getCommissionType(), commissionCreateDto.getCommissionType());
        assertEquals(comissionResponseDto.getValue(), commissionCreateDto.getValue());
    }

    @Test
    public void update() throws Exception {
        CommissionCreateDto commissionCreateDto = SalesmanConfigHelper.createDto(CommissionType.VALUE, 100d);
        ComissionResponseDto comissionResponseDto = createAndReturnDefaultDto(commissionCreateDto);

        CommissionUpdateDto commissionUpdateDto = updateDto(comissionResponseDto.getId(), CommissionType.PERCENT, 10d);

        ComissionResponseDto salesmanConfigUpdateResponseDto = given()
                .header("Content-Type", "application/json")
                .body(commissionUpdateDto)
                .put(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(200)
                .extract()
                .as(ComissionResponseDto.class);

        assertNotNull(comissionResponseDto.getId());
        assertEquals(commissionUpdateDto.getCommissionType(), salesmanConfigUpdateResponseDto.getCommissionType());
        assertEquals(commissionUpdateDto.getValue(), salesmanConfigUpdateResponseDto.getValue());
    }

    @Disabled
    @Test
    public void findSalesmanConfig() throws Exception {
        CommissionCreateDto commissionCreateDto = SalesmanConfigHelper.createDto(CommissionType.VALUE, 100d);
        ComissionResponseDto comissionResponseDto = createAndReturnDefaultDto(commissionCreateDto);

        ComissionResponseDto salesmanConfigFounded = given()
                .header("Content-Type", "application/json")
                .queryParam("code", comissionResponseDto.getId())
                .get(SALESMAN_CONFIG_RESOURCE)
                .then()
                .statusCode(200)
                .extract()
                .as(ComissionResponseDto.class);

        assertEquals(comissionResponseDto.getId(), salesmanConfigFounded.getId());
        assertEquals(comissionResponseDto.getValue(), salesmanConfigFounded.getValue());
        assertEquals(comissionResponseDto.getCommissionType(), salesmanConfigFounded.getCommissionType());
    }

    private CommissionUpdateDto updateDto(String id, CommissionType commissionType, Double value) {
        return new CommissionUpdateDto()
                .setId(id)
                .setCommissionType(commissionType)
                .setValue(value);
    }
}
