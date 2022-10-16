package lecture12;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.ProductPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lecture12_1Test extends BaseTest {

    @Test
    public void test(){
        List<String> data1 = new ArrayList<>();
        data1.add("Audi RS");
        data1.add("VW Polo");
        data1.add("Lada Granta");
        data1.add("Audi Q3");


        List<String> data2 = new ArrayList<>() {{
            add("Audi");
            add("VW");
            add("Lada");
        }};

        List<String> data3 = Arrays.asList("Audi", "VW", "Lada");
        System.out.println(data3);
        List<String> data3WithV = data3.stream().map(car -> car + " 2.0").collect(Collectors.toList());
        System.out.println(data3WithV);

        List<String> audiData = data1.stream().map(car -> {
            if(car.contains("Audi")){
                return car + " Quattro";
            }
            return car;
        }).collect(Collectors.toList());
        System.out.println(audiData);
    }



    @Test(enabled = false)
    public void productPageTest() {
        String productName = "Sauce Labs Backpack";
        get(ProductPage.class)
                .verifyPageTitle();
    }
}
