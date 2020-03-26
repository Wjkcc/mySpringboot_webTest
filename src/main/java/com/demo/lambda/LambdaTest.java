package com.demo.lambda;

import com.demo.springboot_web_test01.pojo.Employee;
import com.demo.springboot_web_test01.pojo.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/26 10:31
 */
public class LambdaTest {

    public static void main(String[] args) {
//        Cook cook = () -> {
//            System.out.println("2222");
//        };
//        cook.print();
        List<User> l = new ArrayList<>();
        l.add(new User("1",22));
        l.add(new User("2",23));
        l.add(new User("3",11));
        l.add(new User("4",133));

//        Comparator<User> comparator = new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getAge()  - o2.getAge();
//            }
//        };

        Collections.sort(l,(User o1, User o2) -> {
            return o1.getAge()  - o2.getAge();
        }
        );

        for (User user:l
             ) {
            System.out.println(user);
        }
    }
}
