package be.technifutur.java202.gestionStage.model;

import java.time.LocalDateTime;

public class Stage {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    public Stage(String name, LocalDateTime start, LocalDateTime end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stage stage = (Stage) o;

        if (!name.equals(stage.name)) return false;
        if (start != null ? !start.equals(stage.start) : stage.start != null) return false;
        return end != null ? end.equals(stage.end) : stage.end == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
