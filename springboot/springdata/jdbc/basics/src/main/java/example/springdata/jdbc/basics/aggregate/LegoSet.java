package example.springdata.jdbc.basics.aggregate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.With;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Data
@AccessType(AccessType.Type.PROPERTY)
public class LegoSet {
    @Id
    private int id;
    private String name;
    @Transient
    private Period minimumAge;
    @Transient
    private Period maximumAge;

    @Column("HANDBUCH_ID")
    private Manual manual;

	@MappedCollection(keyColumn = "NAME")
    @AccessType(AccessType.Type.FIELD)
    private Map<String, Model> models;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Period getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Period minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Period getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(Period maximumAge) {
        this.maximumAge = maximumAge;
    }

    public Manual getManual() {
        return manual;
    }

    public void setManual(Manual manual) {
        this.manual = manual;
    }

    public Map<String, Model> getModels() {
        return models;
    }

    public void setModels(Map<String, Model> models) {
        this.models = models;
    }

    public LegoSet() {
        this.models = new HashMap<>();
    }

    @Column("MIN_AGE")
    public int getIntMinimumAge() {
        return toInt(minimumAge);
    }

    public  void setIntMinimumAge(int years) {
        this.minimumAge = toPeriod(years);
    }

    @Column("MAX_AGE")
    public int getIntMaximumAge() {
        return toInt(maximumAge);
    }

	public void setIntMaximumAge(int years) {
        this.maximumAge = toPeriod(years);
    }

    private static  int toInt(Period period) {
        return (int) (period == null ? 0 : period.get(ChronoUnit.YEARS));
    }

    private static Period toPeriod(int years) {
        return Period.ofYears(years);
    }

    public  void addModel(String name, String description) {
        Model model = new Model(name, description);
        models.put(name, model);
    }
}
