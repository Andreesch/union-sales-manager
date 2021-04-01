package com.union.salesmanagementcore.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.union.salesmanagementcore.api.dto.SalesmanCreateDto;
import com.union.salesmanagementcore.api.dto.SalesmanResponseDto;
import com.union.salesmanagementcore.api.dto.SalesmanUpdateDto;
import com.union.salesmanagementcore.services.SalesmanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cadastro de vendedor")
@RestController("SalesmanController")
@RequestMapping(path = RestPath.BASE_PATH + "/salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.salesman.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = SalesmanResponseDto.class),
    })
    public SalesmanResponseDto create(
            @ApiParam(value = "${v1.salesmanCreate}", required = true) @RequestBody SalesmanCreateDto salesmanCreateDto) {
        return salesmanService.create(salesmanCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.salesman.update}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = SalesmanResponseDto.class),
    })
    public SalesmanResponseDto update(
            @ApiParam(value = "${v1.salesmanUpdate}", required = true) @RequestBody SalesmanUpdateDto salesmanUpdateDto) {
        return salesmanService.update(salesmanUpdateDto);
    }

}
