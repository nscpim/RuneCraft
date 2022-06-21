package ikweetgeennamen.runecraft.files;

public enum Config {
    MONEYSTARTINGVALUE("StartingValue", Integer.valueOf(0)),;

    private String location;

    private Object value;

    Config(String location, Object val) {
        this.location = location;
        this.value = val;
    }
    public Object getValue() {
        return this.value;
    }

    public String getLocation() {
        return this.location;
    }

    public Integer getIntVal() {
        return FileLoader.config.getObject(getLocation(), Integer.class);
    }




    public static void load() {
        for (Config lang : values()) {
            if (FileLoader.config.getString(lang.getLocation()) == null) {
                FileLoader.config.set(lang.getLocation(), lang.getValue());
                System.out.println("Missing config option '" + lang.getLocation() + "' setting to default option: " + lang.getValue());
            }
            else
                {
                    System.out.println("Your config option "+  lang.getLocation() + " was loaded succesfully: "  +lang.getValue());
                }
        }
    }

}