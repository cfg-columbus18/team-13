package org.ohioguidestone.models;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Activities extends RealmObject {
    private String description;
    private String name;
    private boolean isFavorite;
    private String icon;
    private Category category;
    private Template template;
    private RealmList<Tag> tags;
    private RealmList<Usage> usage;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public RealmList<Tag> getTags() {
        return tags;
    }

    public void setTags(RealmList<Tag> tags) {
        this.tags = tags;
    }

    public RealmList<Usage> getUsage() {
        return usage;
    }

    public void setUsage(RealmList<Usage> usage) {
        this.usage = usage;
    }
}
