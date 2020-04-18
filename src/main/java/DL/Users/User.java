package DL.Users;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


/**
 * Description:     Represents a user in the system
 * ID:              X
 **/
@MappedSuperclass
@NamedQueries( value = {
        @NamedQuery(name = "UserByUsername", query = "SELECT u From User u WHERE u.username = :username"),
        @NamedQuery(name = "UserByUsernameAndPassword", query = "SELECT u FROM User u WHERE u.username = :username AND u.hashedPassword = :hashedPassword"),
        @NamedQuery(name = "UpdateUserPermission", query = "update User u set u.userPermission = :permission where u = :user"),
        @NamedQuery(name = "DeactivateUser", query = "UPDATE User u SET u.active = false where user = :user"),
        @NamedQuery(name = "ActivateUser", query = "UPDATE User u SET u.active = true where user=:user")
})
public abstract class User
{
    @Id
    private String username;
    @Column
    private boolean active;
    @Column
    private List<String> searches;
    @Column
    private String email;
    @Column
    private String hashedPassword;
    @OneToOne
    private UserPermission userPermission;
    @OneToMany
    private HashMap<Notification, Boolean> notificationsOwner; //maps from notification to a boolean of read or not read
    @OneToMany
    private List<UserComplaint> userComplaintsOwner;

    /**
     *constructor with PermissionList
     * @param userName
     * @param email
     * @param hashedPassword
     * @param permissionList
     */
    public User (String userName, String email, String hashedPassword, List<UserPermission.Permission> permissionList)
    {
        this.username = userName;
        this.active = true;
        this.searches = new ArrayList<String>();
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.userPermission = new UserPermission(permissionList);
        this.notificationsOwner = new HashMap<Notification,Boolean>();
        this.userComplaintsOwner = new ArrayList<UserComplaint>();
    }

    public User(User other)
    {
        this(other.username,other.email,other.hashedPassword);

    }

    /**
     * constructor without PermissionList
     */
    public User (String userName, String email, String hashedPassword)
    {
        this(userName, email, hashedPassword, new ArrayList<UserPermission.Permission>());
    }

    public User ()
    {
        this("", "", "");
    }


    public boolean hasPermission(UserPermission.Permission permission)
    {
        return userPermission.hasPermission(permission);
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getHashedPassword()
    {
        return this.hashedPassword;
    }

    public List<UserComplaint> getUserComplaintsOwner()
    {
        return this.userComplaintsOwner;
    }

    public boolean addUserComplaint(UserComplaint userComplaint)
    {
        if(userComplaint == null)
        {
            return false;
        }
        this.userComplaintsOwner.add(userComplaint);
        return true;
    }
    public String getEmail() {
        return email;
    }


    @Override
    public String toString ()
    {
        return this.username;
    }

    public void setUserPermission(UserPermission userPermission)
    {
        this.userPermission = userPermission;
    }

    public UserPermission getUserPermission() { return userPermission; }
    @Override
    public boolean equals(Object other)
    {
        if(other == null || !(other instanceof User))
        {
            return false;
        }
        User otherUser = (User)other;
        if(otherUser.username.equals(this.username))
        {
            return true;
        }
        return false;
    }

    public boolean setActive(boolean active)
    {
        this.active = active;
        return true;
    }
    public boolean getActive()
    {
        return active;
    }



}
