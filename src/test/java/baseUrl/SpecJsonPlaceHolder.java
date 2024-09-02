package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class SpecJsonPlaceHolder {


    protected RequestSpecification specJsonPlaceHolder;

@BeforeTest
    public void test(){

        specJsonPlaceHolder=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
}
}
