package com.union.salesmanagementcore.api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.union.salesmanagementcore.api.dto.ComissionResponseDto;
import com.union.salesmanagementcore.api.dto.PaymentResponseDto;
import com.union.salesmanagementcore.api.dto.SalesResponseDto;
import com.union.salesmanagementcore.services.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Pagamentos")
@RestController("PaymentsController")
@RequestMapping(path = RestPath.BASE_PATH + "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/quarter/{code}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful request with body content", response = PaymentResponseDto.class),
    })
    @ApiOperation(value = "Listar todos os pagamentos por período")
    public List<PaymentResponseDto> findAllByQuarter(@ApiParam(value = "Código do período", required = true) @PathVariable("code") String code) {
        return paymentService.findAllByQuarter(code);
    }
}
