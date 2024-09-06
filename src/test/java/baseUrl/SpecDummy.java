package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class SpecDummy {
    protected RequestSpecification specDummy;

    @BeforeTest
    public void setUp(){
        specDummy=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1/").build();
    }

}
