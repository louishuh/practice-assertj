package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionNestObjectListTest {

    @Test
    void test() {

        List<Car> carList = ObjectMother.get().objects(Car.class, 4).toList();

        Car secondCar = carList.get(1);

        Car shallowCloneSecondCar = new Car(secondCar.getName(), secondCar.getPassenger());
        assertThat(carList)
                .contains(secondCar)
                .doesNotContain(shallowCloneSecondCar)
                .usingRecursiveFieldByFieldElementComparator()
                .contains(shallowCloneSecondCar);

        List<Person> passenger = secondCar.getPassenger();
        List<Person> copiedPassenger = new ArrayList<>();
        for (Person person : passenger) {
            Person copiedPerson = new Person(person.getAge(), person.getName());
            copiedPassenger.add(copiedPerson);
        }

        Car deepCloneSecondCar = new Car(secondCar.getName(), copiedPassenger);
        assertThat(carList)
                .doesNotContain(deepCloneSecondCar, shallowCloneSecondCar)
                .usingRecursiveFieldByFieldElementComparator()
                .contains(deepCloneSecondCar);

        Person person = secondCar.getPassenger().get(1);
        assertThat(carList)
                .flatMap(Car::getPassenger)
                .filteredOn("name", person.getName())
                .map(Person::getAge)
                .hasSize(1)
                .singleElement()
                .isInstanceOf(Integer.class);

    }


}
