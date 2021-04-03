package com.union.salesmanagementcore;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.union.salesmanagementcore.api.controller.RestPath;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public abstract class AbstractTestController {

    public static String API_V1;
    public static String SALESMAN_RESOURCE;
    public static String SALESMAN_CONFIG_RESOURCE;
    public static String SALES_RESOURCE;

    @LocalServerPort
    public int randomPort;

    @Autowired
    protected RequestSpecificationBuilder requestSpecificationBuilder;

    public void setup() throws Exception {
        RestAssured.port = randomPort;
        API_V1 = RestPath.BASE_PATH;
        SALESMAN_RESOURCE = API_V1 + "/salesman";
        SALESMAN_CONFIG_RESOURCE= API_V1 + "/salesman-config";
        SALES_RESOURCE = API_V1 + "/sales";
    }
}
