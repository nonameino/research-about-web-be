package example.springdata.jdbc.basics.aggregate;

import example.springdata.jdbc.basics.Output;
import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Period;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AggregateConfiguration.class)
@AutoConfigureDataJdbc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AggregateTests {
    @Autowired
    private LegoSetRepository repository;

    @Test
    public void exerciseSomewhatComplexEntity() {
        LegoSet smallCar = createLegoSet("Small Car 01", 5, 12);
        smallCar.setManual(new Manual("Just put all the pieces together in the right order", "Jens Schauder"));
        smallCar.addModel("suv", "SUV with sliding doors.");
        smallCar.addModel("roadster", "Slick red roadster.");

        repository.save(smallCar);
        Iterable<LegoSet> legoSets = repository.findAll();
        Output.list(legoSets, "Original LegoSet");
        checkLegoSets(legoSets, "Just out all the pieces together in the right orther", 2);

        smallCar.getManual().setText("Just make it so it looks like car");
        smallCar.addModel("pickup", "A pickup truck with some toos in the back");

        repository.save(smallCar);
        legoSets = repository.findAll();
        Output.list(legoSets, "Updated");
        checkLegoSets(legoSets, "Just make it so it looks like a car", 3);

        smallCar.setManual(new Manual("One last attempt: Just build a car! OK?", "Jens Schauder"));

        repository.save(smallCar);
        legoSets = repository.findAll();
        Output.list(legoSets, "Manual replaced");
        checkLegoSets(legoSets, "One last attempt: Just build a car! OK?", 3);
    }

    @Test
    public void customQueries() {
        LegoSet smallCar = createLegoSet("Small Car - 01", 5, 10);
        smallCar.setManual(new Manual("Just put all the pieces together in the right orther", "Jens Schauder"));;

        smallCar.addModel("SUV", "SUV with sliding doors");
        smallCar.addModel("roadster", "Slick red roadster");

        LegoSet f1Racer = createLegoSet("F1 Racer", 6, 15);
        f1Racer.setManual(new Manual("Build a helicopter or a plane", "M. Shoemaker"));

        f1Racer.addModel("F1 Ferrari 2018", "A very fast red car");

        LegoSet constructionVehicles = createLegoSet("Construction Vehicles", 3, 6);
        constructionVehicles.setManual(new Manual("Build a Road Roler, a Mobile Crane, a Tracked Dumper, or a Backhoe Loader",
                "Bob the Builder"));

        constructionVehicles.addModel("scoop", "A backhoe loader");
        constructionVehicles.addModel("Muck", "Muck is a continuous tracker dump truck with an added bulldozer blade");
        constructionVehicles.addModel("lofty", "A mobile crane");
        constructionVehicles.addModel("roley", "A road roller that loves to make up songs and frequently spins his eyes when he is exited");

        repository.saveAll(Arrays.asList(smallCar, f1Racer, constructionVehicles));

        List<ModelReport> report = repository.reportModelForAge(6);
        Output.list(report, "Model Report");

        assertThat(report).hasSize(7)
                .allMatch(m->m.getDescription() != null && m.getModelName() != null && m.getSetName() != null);

        int update = repository.lowerCaseMapKeys();
        assertThat(update).isEqualTo(3);
    }

    private LegoSet createLegoSet(String name, int minimumAge, int maximumAge) {
        LegoSet smallCar = new LegoSet();

        smallCar.setName(name);
        smallCar.setMinimumAge(Period.ofYears(minimumAge));
        smallCar.setMaximumAge(Period.ofYears(maximumAge));

        return smallCar;
    }

    private void checkLegoSets(Iterable<LegoSet> legoSets, String manualText, int numberOfModels) {
        assertThat(legoSets)
                .extracting(
                        ls -> ls.getManual().getText(),
                        ls -> ls.getModels().size())
                .containsExactly(new Tuple(manualText, numberOfModels));
    }
}
