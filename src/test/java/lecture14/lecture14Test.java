package lecture14;

import lecture14.entity.Car;
import lecture14.entity.Home;
import lecture14.entity.Person;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

@Log4j
public class lecture14Test {
    @Test
    public void personTest() {
        Person person1 = new Person() {{
            setAddress("Minsk");
            setFirstName("Ivan");
            setLastName("Ivanov");
        }};
        Person person2 = new Person("", "", "", 0, "", "");
        log.debug(person1);
        log.debug(person2);

    }

    @Test
    public void carTest() {
        Car car = new Car() {{
            setColor("black");
            setModel("Tesla");
            setYear(2013);
            setType("electric");
        }};
        log.debug(car.getModel());
        log.debug(car);
    }

    @Test
    public void homeTest() {
        Home home = new Home.HomeBuilder()
                .withColor("white")
                .withAddress("Minsk")
                .create();
        log.debug(home);
    }
}
