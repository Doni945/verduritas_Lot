package danilo.moreno.verduritassa;

public class Cultivo {
    private String alias;
    private String fechaSiembra;
    private String planta;

    // Constructor
    public Cultivo(String alias, String fechaSiembra, String planta) {
        this.alias = alias;
        this.fechaSiembra = fechaSiembra;
        this.planta = planta;
    }

    // Getters
    public String getAlias() {
        return alias;
    }

    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public String getPlanta() {
        return planta;
    }

    // Setters (opcional, si necesitas modificar los valores)
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }
}
