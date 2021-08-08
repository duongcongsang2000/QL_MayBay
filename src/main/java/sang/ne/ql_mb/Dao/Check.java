/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.Dao;

/**
 *
 * @author Yahiko
 */
public class Check {
    public static boolean CheckSDT(String s)
    {   
    if (s.length()!=10) return false;
    char[] chars = s.toCharArray();
    for (char c : chars) {
        if(Character.isLetter(c)) 
        {
            return false;
        }
    }
    return true;
    }
}
