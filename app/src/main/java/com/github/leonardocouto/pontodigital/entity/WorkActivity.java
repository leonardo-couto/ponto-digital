package com.github.leonardocouto.pontodigital.entity;

public class WorkActivity {

    private long id;
    private String area;
    private String client;
    private String project;
    private String name;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", area, client, project);
    }

    public static WorkActivity build(String area, String client, String project, String name) {
        WorkActivity workActivity = new WorkActivity();
        workActivity.setArea(area);
        workActivity.setClient(client);
        workActivity.setName(name);
        workActivity.setProject(project);
        return workActivity;
    }
}
