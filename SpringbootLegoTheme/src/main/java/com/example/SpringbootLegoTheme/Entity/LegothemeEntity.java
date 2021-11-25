package com.example.SpringbootLegoTheme.Entity;

import lombok.Data;

@Data
public class LegothemeEntity {

    private int id;
    private String name;
    private int parentId;

    public LegothemeEntity(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
