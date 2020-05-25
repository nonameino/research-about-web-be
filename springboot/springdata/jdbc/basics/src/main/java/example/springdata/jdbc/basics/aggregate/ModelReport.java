package example.springdata.jdbc.basics.aggregate;

public class ModelReport {
    protected String modelName;
    protected String description;

    public ModelReport() {
    }

    public ModelReport(String modelName, String description) {
        this.modelName = modelName;
        this.description = description;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
