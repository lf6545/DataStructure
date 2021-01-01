package day1;

import org.junit.Test;

import javax.lang.model.element.VariableElement;
import java.util.*;

public class TestHashCode {
    @Test
    public void testHashCode(){
        Set<String> hset = new HashSet<>();
        Set<String> tset = new TreeSet<>();
        AbstractSet<String> ahset= new HashSet<>();
        System.out.println(ahset.hashCode());
        System.out.println(hset.hashCode());
        System.out.println(tset.hashCode());
        StringBuffer sb = new StringBuffer("abc");
    }
}
