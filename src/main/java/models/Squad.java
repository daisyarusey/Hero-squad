package models;

import java.util.Objects;

public class Squad {
    private String name;
    private int maxSize;
    private  String cause;
    private int id;



    public Squad(String name, int maxSize, String cause) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public String getName() {
        return name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Squad)) return false;
        Squad squad = (Squad) o;
        return maxSize == squad.maxSize &&
                id == squad.id &&
                Objects.equals(name, squad.name) &&
                Objects.equals(cause, squad.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxSize, cause, id);
    }

}
