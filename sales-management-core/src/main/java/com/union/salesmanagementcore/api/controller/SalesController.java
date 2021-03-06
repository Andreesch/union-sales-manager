package com.union.salesmanagementcore.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.union.salesmanagementcore.api.dto.SalesCreateDto;
import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.api.dto.ComissionResponseDto;
import com.union.salesmanagementcore.services.SalesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Vendas")
@RestController("SalesController")
@RequestMapping(path = RestPath.BASE_PATH + "/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.sales.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = SalesResponseDto.class),
    })
    public SalesResponseDto create(
            @ApiParam(value = "${v1.sales}", required = true) @RequestBody SalesCreateDto salesCreateDto) {
        return salesService.create(salesCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/salesman/{code}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = ComissionResponseDto.class),
    })
    @ApiOperation(value = "Listar vendas por vendedor")
    public List<SalesResponseDto> findByCode(@ApiParam(value = "C??digo do vendedor", required = true) @PathVariable("code") String code) {
        return salesService.findAllSalesBySalesman(code);
    }
}
