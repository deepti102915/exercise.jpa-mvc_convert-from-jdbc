package com.github.perscholas.jpa.personrepository;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.config.JdbcConfigurator;
import com.github.perscholas.dao.PersonJdbcRepository;
import com.github.perscholas.dao.PersonJpaRepository;
import com.github.perscholas.dao.RepositoryInterface;
import com.github.perscholas.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */
public class FindAllTest {
    private DatabaseConnection databaseConnection;

    @Before
    public void setup() {
        // given
        this.databaseConnection = DatabaseConnection.TESTING_DATABASE;
        JdbcConfigurator configurator = new JdbcConfigurator(databaseConnection);
        configurator.appendSqlScript("testing.person_create-table.sql");
        configurator.appendSqlScript("testing.person_populate-table.sql");
        configurator.initialize();
    }

    @Test
    public void test() {
        // given
        RepositoryInterface<Long, Person> repository = new PersonJpaRepository("testing");

        // when
        List<Person> personList = repository.findAll();

        // then
        Assert.assertFalse(personList.isEmpty());
    }
}
