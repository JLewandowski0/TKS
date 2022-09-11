package RepoModel;

public enum AccessLevelEnt{
    ADMINUSER,
    ADMINRESOURCES,
    CLIENT;
    public String getAccessLevel(){
        return this.name();
    }

}
