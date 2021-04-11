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
import com.union.salesmanagementcore.api.dto.SalesmanCurrentStatusReportDto;
import com.union.salesmanagementcore.services.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Relatórios")
@RestController("ReportsController")
@RequestMapping(path = RestPath.BASE_PATH + "/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "salesman/current/{code}/{quarterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obter status atual do vendedor")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Successful request with body content", response = SalesResponseDto.class),
    })
    public SalesmanCurrentStatusReportDto create(
            @ApiParam(value = "Código do vendedor", required = true) @PathVariable("code") String code,
            @ApiParam(value = "Código do vendedor", required = true) @PathVariable("quarterId") String quarterId) {
        return reportService.salesmanCurrentStatus(code, quarterId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obter todas as vendas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = SalesResponseDto.class),
    })
    public List<SalesResponseDto> findAll() {
        return reportService.listSales();
    }
}
