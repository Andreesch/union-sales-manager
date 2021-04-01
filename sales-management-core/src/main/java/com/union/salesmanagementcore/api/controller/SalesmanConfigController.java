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

import com.union.salesmanagementcore.api.dto.SalesmanConfigCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanConfigUpdateDto;
import com.union.salesmanagementcore.services.SalesmanConfigService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Comissão")
@RestController("SalesmanConfigController")
@RequestMapping(path = RestPath.BASE_PATH + "/salesman-config")
public class SalesmanConfigController {

    @Autowired
    private SalesmanConfigService salesmanConfigService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.salesmanconfig.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = SalesmanConfigResponseDto.class),
    })
    public SalesmanConfigResponseDto create(
            @ApiParam(value = "${v1.salesmanConfig}", required = true) @RequestBody SalesmanConfigCreateDto salesmanConfigCreateDto) {
        return salesmanConfigService.create(salesmanConfigCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{code}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = SalesmanConfigResponseDto.class),
    })
    @ApiOperation(value = "${v1.salesmanConfig.findByCode}")
    public SalesmanConfigResponseDto findByCode(@ApiParam(value = "${v1.salesmanConfig.code}", required = true) @PathVariable("code") String code) {
        return salesmanConfigService.find(code);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.salesmanconfig.update}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = SalesmanConfigResponseDto.class),
    })
    public SalesmanConfigResponseDto update(
            @ApiParam(value = "${v1.salesmanConfig}", required = true) @RequestBody SalesmanConfigUpdateDto salesmanConfigUpdateDto) {
        return salesmanConfigService.update(salesmanConfigUpdateDto);
    }
}
