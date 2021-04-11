package com.union.salesmanagementcore.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.union.salesmanagementcore.api.dto.CommissionCreateDto;
import com.union.salesmanagementcore.api.dto.ComissionResponseDto;
import com.union.salesmanagementcore.api.dto.CommissionUpdateDto;
import com.union.salesmanagementcore.services.CommissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Comissão")
@RestController("SalesmanConfigController")
@RequestMapping(path = RestPath.BASE_PATH + "/salesman-config")
public class CommissionController {

    @Autowired
    private CommissionService comissionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.salesmanconfig.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = ComissionResponseDto.class),
    })
    public ComissionResponseDto create(
            @ApiParam(value = "${v1.salesmanConfig}", required = true) @RequestBody CommissionCreateDto commissionCreateDto) {
        return comissionService.create(commissionCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{code}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = ComissionResponseDto.class),
    })
    @ApiOperation(value = "${v1.salesmanConfig.findByCode}")
    public ComissionResponseDto findByCode(@ApiParam(value = "${v1.salesmanConfig.code}", required = true) @PathVariable("code") String code) {
        return comissionService.find(code);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.salesmanconfig.update}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = ComissionResponseDto.class),
    })
    public ComissionResponseDto update(
            @ApiParam(value = "${v1.salesmanConfig}", required = true) @RequestBody CommissionUpdateDto commissionUpdateDto) {
        return comissionService.update(commissionUpdateDto);
    }
}
