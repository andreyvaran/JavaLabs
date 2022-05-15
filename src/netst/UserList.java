package netst;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListResourceBundle;
import java.util.stream.Collectors;



public class UserList {
    private ArrayList<User> lstrusr ;


    public UserList() {
        User admin = new User("Admn" );
        User danil = new User("Daniel" );
        lstrusr = new ArrayList<User>();
        this.lstrusr.add(admin);
        this.lstrusr.add(danil);

    }
    
    public void addUser(String name ){
        User temp = new User(name );
        this.lstrusr.add(temp);
    }

    public boolean isRegistred(String name ){
        return lstrusr.stream().filter(x -> x.equals(name))
                        .collect(Collectors.toList()).isEmpty();
    }

    @Override
    public String toString() {
        return "UserList{" +
                "lstrusr=" + lstrusr +
                '}';
    }
}