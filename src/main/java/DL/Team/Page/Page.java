package DL.Team.Page;

import DL.Users.Fan;
import DL.Users.User;
import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: Defines a Page object - a personal page of coach/player/team fan can follow    X
 * ID:              6
 **/
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PAGE_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Page implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    protected String content;

    @ManyToMany(cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
    @JoinTable(name = "JOIN_PAGE_FAN", joinColumns = {@JoinColumn(name = "PAGE_ID")}, inverseJoinColumns = {@JoinColumn(name = "FAN_ID")})
    Set<Fan> followers;

    public Page()
    {
        followers = new HashSet<>();
    }

    public boolean addFollower(Fan fan)
    {
        return this.followers.add(fan);
    }

    public boolean removeFollower(Fan fan)
    {
        return followers.remove(fan);
    }

    public boolean isFollower(Fan fan)
    {
        if(followers.contains(fan))
        {
            return true;
        }
        return false;
    }

    public Set<Fan> getFollowers()
    {
        return followers;
    }


}
