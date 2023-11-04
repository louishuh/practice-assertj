package com.example;

import org.assertj.core.data.Index;
import org.assertj.core.groups.Tuple;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.notIn;

public class AssertionListTest {

    @Test
    void filterAndContains() {

        Person p1 = new Person(17, "joe");
        Person p2 = new Person(21, "louis");
        Person p3 = new Person(15, "john");
        Person p4 = new Person(23, "peter");
        List<Person> personList = Lists.list(p1, p2, p3, p4);

        assertThat(personList)
                .filteredOn(p -> p.getAge() > 20)
                .containsExactly(p2, p4)
                .containsExactlyInAnyOrder(p4, p2)
                .containsOnly(p4, p2)
                .contains(p2, Index.atIndex(0))
                .contains(p2, p4)
                .contains(p4)
                .containsAnyOf(p1, p3, p4);

        assertThat(personList)
                .filteredOn("age", 17)
                .filteredOn("age", notIn(16, 18, 19))
                .containsExactly(p1);
    }

    @Test
    void extracting() {
        Person p1 = new Person(17, "joe");
        Person p2 = new Person(21, "louis");
        Person p3 = new Person(15, "john");
        Person p4 = new Person(23, "peter");
        List<Person> personList = Lists.list(p1, p2, p3, p4);

        assertThat(personList)
                .extracting("name")
                .contains("joe", "peter");

        assertThat(personList)
                .extracting("name", "age")
                .contains(Tuple.tuple("louis", 21));
    }


}
