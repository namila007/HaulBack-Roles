package me.namila.haulmatic.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static me.namila.haulmatic.constants.statics.ApiEndPoints.BASE_END_POINT;
import static me.namila.haulmatic.constants.statics.ApiEndPoints.STATUS_END_POINT;

@RestController
@RequestMapping(BASE_END_POINT)
@Api(value = "Health Check")
public class BaseController {

    @GetMapping(value = STATUS_END_POINT)
    @ApiOperation(value = "Test Health")
    private ResponseEntity<String> status() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
