package com.union.salesmanagementcore.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.union.salesmanagementcore.api.dto.QuarterCreateDto;
import com.union.salesmanagementcore.api.dto.QuarterResponseDto;
import com.union.salesmanagementcore.api.dto.QuotaCreateDto;
import com.union.salesmanagementcore.api.dto.QuotaResponseDto;
import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.services.QuotaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cotas")
@RestController("QuotasController")
@RequestMapping(path = RestPath.BASE_PATH + "/quotas")
public class QuotaController {

    @Autowired
    private QuotaService quotaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um nova cota")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = SalesResponseDto.class),
    })
    public QuotaResponseDto create(
            @ApiParam(value = "Cota", required = true) @RequestBody QuotaCreateDto quotaCreateDto) {
        return quotaService.create(quotaCreateDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/quarter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Criação de um novo periodo para comissão")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = QuarterResponseDto.class),
    })
    public QuarterResponseDto create(
            @ApiParam(value = "Período", required = true) @RequestBody QuarterCreateDto quarterCreateDto) {
        return quotaService.createQuarter(quarterCreateDto);
    }
}
