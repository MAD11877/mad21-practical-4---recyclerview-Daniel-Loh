package sg.edu.np.practical3;

public class User {
    public  int imageID;
    public String name;
    public String Description;
    public int id;
    public boolean followed;

    public User(int image,String name, String description, int id, boolean followed) {
        this.imageID = image;
        this.name = name;
        this.Description = description;
        this.id = id;
        this.followed = followed;
    }

    public User(int imageID) {
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}
