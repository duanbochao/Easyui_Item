package com.model;

/**
 * @author duanbochao
 * @creat 2019/7/20
 */
public class Market {

    private Integer id;
    private String theme;
    private Integer budget;
    private Integer clue;
    private String description;
    private String summary;

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", budget=" + budget +
                ", clue=" + clue +
                ", description='" + description + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getClue() {
        return clue;
    }

    public void setClue(Integer clue) {
        this.clue = clue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
