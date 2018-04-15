package guru.springframework.repository;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryITest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @DirtiesContext
    public void findByUom() throws Exception {
        Optional<UnitOfMeasure> uomTeaspoon = unitOfMeasureRepository.findByUom("Teaspoon");

        assertEquals("Teaspoon", uomTeaspoon.get().getUom());
    }

    @Test
    public void findByUomCup() throws Exception {
        Optional<UnitOfMeasure> uomCup = unitOfMeasureRepository.findByUom("Cup");

        assertEquals("Cup", uomCup.get().getUom());
    }
}