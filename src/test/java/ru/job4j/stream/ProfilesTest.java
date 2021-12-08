package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenAddAddressAndSortCity() {
        List<Profile> list = List.of(
                new Profile(new Address("Sochi", "1 Line", 33, 2)),
                new Profile(new Address("Moscow", "Lenina", 24, 142)),
                new Profile(new Address("Sochi", "3 Line", 2, 10))
        );
        List<Address> rsl = new Profiles().collect(list);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 24, 142));
        expected.add(new Address("Sochi", "1 Line", 33, 2));
        expected.add(new Address("Sochi", "3 Line", 2, 10));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortCityAndDuplicates() {
        List<Profile> list = List.of(
                new Profile(new Address("Sochi", "1 Line", 33, 2)),
                new Profile(new Address("Moscow", "Lenina", 24, 142)),
                new Profile(new Address("Moscow", "Lenina", 24, 142)),
                new Profile(new Address("Sochi", "3 Line", 2, 10)),
                new Profile(new Address("Sochi", "3 Line", 2, 10))
        );
        List<Address> rsl = new Profiles().collect(list);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 24, 142));
        expected.add(new Address("Sochi", "1 Line", 33, 2));
        expected.add(new Address("Sochi", "3 Line", 2, 10));
        assertThat(rsl, is(expected));

    }

}