package model;

public enum AccessLevel{
    ADMINUSER,
    ADMINRESOURCES,
    CLIENT;
    public String getAccessLevel(){
        return this.name();
    }

}
