
package com.vivekvishwanath.zoos;


import com.vivekvishwanath.zoos.model.Role;
import com.vivekvishwanath.zoos.model.User;
import com.vivekvishwanath.zoos.model.UserRoles;
import com.vivekvishwanath.zoos.repo.RoleRepository;
import com.vivekvishwanath.zoos.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("zoodata");
        Role r3 = new Role("animaldata");
        Role r4 = new Role("mgr");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));

        ArrayList<UserRoles> zoodatas = new ArrayList<>();
        zoodatas.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> animaldatas = new ArrayList<>();
        animaldatas.add(new UserRoles(new User(), r3));

        ArrayList<UserRoles> mgrs = new ArrayList<>();
        mgrs.add(new UserRoles(new User(), r4));

        rolerepos.save(r1);
        rolerepos.save(r2);
        rolerepos.save(r3);
        rolerepos.save(r4);

        User u1 = new User("prisonmike", "lalala", admins);
        User u2 = new User("jimhalpert", "lalala", zoodatas);
        User u3 = new User("dwightschrute", "lalala", animaldatas);
        User u4 = new User("pamela", "lalala", mgrs);

        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);
        userrepos.save(u4);
    }
}
